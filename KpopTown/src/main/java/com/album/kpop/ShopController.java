package com.album.kpop;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.album.service.OrderService;
import com.album.service.ShopService;
import com.album.vo.CartVO;
import com.album.vo.CriteriaVO;
import com.album.vo.EventVO;
import com.album.vo.MemberVO;
import com.album.vo.OrderDetailVO;
import com.album.vo.OrderListVO;
import com.album.vo.OrderVO;
import com.album.vo.PageVO;
import com.album.vo.ReviewVO;
import com.album.vo.productVO;
import com.google.gson.JsonObject;
import com.mysql.cj.x.protobuf.MysqlxCrud.Order;

@Controller
@RequestMapping(value="/shop")
public class ShopController {
	
	@Autowired
	private ShopService shopservice;
	private Logger logger = LoggerFactory.getLogger(ShopController.class);
	@Resource(name="uploadPath")
	private String uploadPath;   
	
	// 제품 목록
	@RequestMapping( value="/shoplist" , method=RequestMethod.GET)
	public void getlist (@RequestParam("c") int catecode , Model model) throws Exception{
		
		logger.info("카테고리별 리스트 보여주기 ");

		List<productVO> list = shopservice.list(catecode);
		model.addAttribute("list", list);
		
	}
	

	
	// 상세 페이지
		
		@RequestMapping(value="/shopview" , method=RequestMethod.GET)
		public void goodsview (int goodsnumber , Model model) throws Exception{
			
			logger.info("상세페이지");
			
			model.addAttribute("view", shopservice.view(goodsnumber));
	
		}
		
		
	// 제품 리뷰 	
	@ResponseBody
	@RequestMapping (value="/shopview/reistReview" , method=RequestMethod.POST)
	public void registReview (ReviewVO rvo , HttpSession session) throws Exception{
		MemberVO memvo = (MemberVO)session.getAttribute("member");
		rvo.setUserid(memvo.getUserid());
		
		 shopservice.reviewRegist(rvo);
	}
	
	//ck에디터 파일 업로드 
	
			@RequestMapping(value="shopview/ReviewUpload" , method=RequestMethod.POST)
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
							String ckuploadPath =  uploadPath + File.separator + "ReviewUpload";
							File uploadFile = new File(ckuploadPath);
							
							if(!uploadFile.exists()) {
								uploadFile.mkdir();
							}
							fileName = UUID.randomUUID().toString();
							ckuploadPath = ckuploadPath+"/"+fileName;
							out = new FileOutputStream(new File(ckuploadPath));
							out.write(bytes);

							
							printWriter = response.getWriter();
							response.setContentType("text/html");
							String fileUrl = "/resources/ReviewUpload/"+fileName;
							
							json.addProperty("uploaded", 1);
							json.addProperty("fileName", fileName);
							json.addProperty("url", fileUrl);
							
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
			
	
	// 제품 리뷰 목록 
	@ResponseBody
	@RequestMapping (value="/shopview/reviewList" , method=RequestMethod.GET)
	public List<ReviewVO> ReviewList (@RequestParam("goodsnumber") int goodsnumber) throws Exception{
		
		logger.info("리뷰 목록");
		List<ReviewVO> review = shopservice.reviewList(goodsnumber);
		
		return review;
	}
	
	// 제품 리뷰 삭제 
	@ResponseBody
	@RequestMapping(value="/shopview/reviewDelete", method=RequestMethod.POST)
	public int reviewDelete (ReviewVO rvo , HttpSession session) throws Exception{
		logger.info("리뷰 삭제");
		int result = 0;
		
		 
		 MemberVO memvo = (MemberVO)session.getAttribute("member");
		 String userId = shopservice.reviewIdCheck(rvo.getRwNumber());
		   System.out.println("유저아이디" + userId);
		   System.out.println("멤버" + memvo);
		 if(memvo.getUserid().equals(userId)) {
		  
		  rvo.setUserid(memvo.getUserid());
		  shopservice.reviewDelete(rvo);
		  
		  result = 1;
		 }
		 
		 return result; 
		}

	
	// 이벤트 리스트 
	@RequestMapping(value="/eventList" , method=RequestMethod.GET)
	public void eventList (Model model) throws Exception{
		
		List<EventVO> evo = shopservice.eventList();
		
		model.addAttribute("eventList", evo);
		
	}
	
	// 상세 페이지
	
			@RequestMapping(value="/eventView" , method=RequestMethod.GET)
			public void eventView (int evNumber , Model model) throws Exception{
				
				logger.info("상세페이지");
				
				model.addAttribute("view", shopservice.evenView(evNumber));
		
			}
	
			
}
