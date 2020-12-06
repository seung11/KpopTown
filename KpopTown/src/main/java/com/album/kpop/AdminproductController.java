package com.album.kpop;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.album.service.AdminProductService;
import com.album.upload.UploadFileUtils;
import com.album.vo.CategoryVO;
import com.album.vo.CriteriaVO;
import com.album.vo.EventVO;
import com.album.vo.OrderListVO;
import com.album.vo.OrderVO;
import com.album.vo.PageVO;
import com.album.vo.ReviewVO;
import com.album.vo.productVO;
import com.google.gson.JsonObject;


import net.sf.json.JSONArray;


@Controller
@RequestMapping(value = "/admin")
public class AdminproductController {
	
	@Autowired
	private AdminProductService apservice;
	@Resource(name="uploadPath")
	private String uploadPath;   


	private Logger logger = LoggerFactory.getLogger(AdminproductController.class);

	
	//관리자 페이지 화면 이동 
	@RequestMapping(value = "/adminmain" , method = RequestMethod.GET)
	public void getIndex() throws Exception{
		logger.info("관리자 화면");
	}
	
	
	//제품 등록 화면 이동 
	@RequestMapping(value="/product/insert" , method = RequestMethod.GET)
	public void getInsert (Model model) throws Exception{
		//카테고리 
		List<CategoryVO>category = null;
		category = apservice.category();
		model.addAttribute("category", JSONArray.fromObject(category));
		
		logger.info("제품 등록 화면으로 이동");
	}
	

	//제품 등록 처리
	@RequestMapping(value="/product/insert" , method=RequestMethod.POST)
	public String postupload (productVO pvo , MultipartFile file) throws Exception{
		
		//파일업로드 
				String imgUploadPath = uploadPath + File.separator + "imgUpload";
				String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
				String fileName = null;
				
				if(file.getOriginalFilename()!= null && !file.getOriginalFilename().equals("")) {
					fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
					//gdsimg에 원본 파일 경로 + 파일명 저장 
					pvo.setImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
					// gdsThumbImg에 썸네일 파일 경로 + 파일명 저장 
					pvo.setThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
					
				}else {
					//첨부파일이 없으면 
					 fileName = File.separator + "img" + File.separator + "none.png";
					  // 미리 준비된 none.png파일을 대신 출력함					  
					 pvo.setImg(fileName);
					 pvo.setThumbImg(fileName);
				}
				
			
		apservice.insert(pvo);
		logger.info("상품 등록 처리");
		System.out.println(pvo);
		return "redirect:/admin/product/adlist";
	}
	
	//ck에디터 파일 업로드 
	
		@RequestMapping(value="product/ckUpload" , method=RequestMethod.POST)
		@ResponseBody
		public void ckupload (HttpServletRequest request, HttpServletResponse response,MultipartHttpServletRequest multiFile ) throws Exception{
			JsonObject json = new JsonObject();
			PrintWriter printWriter = null;
			OutputStream out = null;
			MultipartFile file = multiFile.getFile("upload");
			
			if(file.getSize() > 0 && StringUtils.isNotBlank(file.getName())) {
				if(file.getContentType().toLowerCase().startsWith("image/")) {
					try {
						String fileName = file.getName();
						byte [] bytes = file.getBytes();
					//	String uploadPath = request.getServletContext().getRealPath("/resources/ckUpload");
						String ckUploadPath =  uploadPath + File.separator + "ckUpload";

						System.out.println(uploadPath + "ckuploadPath");
					//	File uploadFile2 = new File(uploadPath);
						File uploadFile = new File(ckUploadPath);
						
						if(!uploadFile.exists()) {
							uploadFile.mkdir();
						}
						/*if(!uploadFile2.exists()) {
							uploadFile.mkdir();
						}*/
						fileName = UUID.randomUUID().toString()+".jpg";
						ckUploadPath = ckUploadPath+File.separator+fileName;
						System.out.println("ckuploadPath2 : " + ckUploadPath);
						out = new FileOutputStream(new File(ckUploadPath));
						out.write(bytes);

						
						printWriter = response.getWriter();
						response.setContentType("text/html");
						String fileUrl = request.getContextPath()+"/resources/ckUpload/"+fileName;
						
						json.addProperty("uploaded", 1);
						json.addProperty("fileName", fileName);
						json.addProperty("url", fileUrl);
						System.out.println("fileUrl : " + fileUrl);
						printWriter.println(json);
		
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						if(out != null) {
							out.close();
						}
						if(printWriter != null) {
							printWriter.close();
						}
					}
				}
			}
		}
	
	// 제품 목록
	@RequestMapping(value="/product/adlist" , method = RequestMethod.GET)
	public void goodslist (Model model , CriteriaVO cri) throws Exception{
	
		
		PageVO pageMaker = new PageVO();
		pageMaker.setCri(cri);
		pageMaker.setTotal(apservice.totalCount(cri));
		
		List<Map<String, Object>> listpage = apservice.listPage(cri);
		model.addAttribute("list", listpage);
		model.addAttribute("pageMaker", pageMaker);
	}
	
	
	// 상세 페이지
	@RequestMapping(value="/product/adview" , method=RequestMethod.GET)
	public void goodsview (int goodsnumber , Model model) throws Exception{

		model.addAttribute("view", apservice.productView(goodsnumber));
		// System.out.println(apservice.view(goodsnumber));
		
	}
		
	//상품 삭제
	@RequestMapping(value="/product/delete" , method = RequestMethod.GET)
	public String goodsdelete(@RequestParam("goodsNumber")int pvo) throws Exception{
		logger.info("상품삭제");
		apservice.delete(pvo);
	
		return "redirect:/admin/product/adlist";
	}
	
	
	//상품 수정 이동
	@RequestMapping(value ="/product/goodsmodify", method=RequestMethod.GET)
	public void modifyget (@RequestParam("goodsNumber") int goodsnumber , Model model , productVO pvo ) throws Exception{
		 pvo = apservice.productView(goodsnumber);
		 model.addAttribute("view", pvo);
		 
		List<CategoryVO>category = null;
		category = apservice.category();
		model.addAttribute("category", JSONArray.fromObject(category));
		
		System.out.println(pvo);
	}
	
	//상품 수정 처리 
	@RequestMapping(value="/product/goodsmodify", method=RequestMethod.POST)
	public String modify (productVO pvo , HttpServletRequest request , MultipartFile file)throws Exception{
		
		 apservice.productView(pvo.getGoodsNumber());
		 
		 // 첨부파일 수정 
	
			 if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
			  // 기존 파일 삭제
			  new File(uploadPath + request.getParameter("img")).delete();
			  new File(uploadPath + request.getParameter("ThumbImg")).delete();
			  
			  // 새로 등록된 파일 변경
			  String imgUploadPath = uploadPath + File.separator + "imgUpload";
			  String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
			  String fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
			  
			  pvo.setImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
			  pvo.setThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
			  
			 } else {  
				 
				 //변경x
			  pvo.setImg(request.getParameter("img"));
			  pvo.setThumbImg(request.getParameter("ThumbImg"));
			  
		 }
			 apservice.modify(pvo);
			 logger.info("수정처리");
			 return "redirect:/admin/product/adlist";
	}
	

}
