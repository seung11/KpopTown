package com.album.kpop;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
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

import com.album.service.AdminProductService;
import com.album.service.AdminShopService;
import com.album.upload.UploadFileUtils;
import com.album.vo.CriteriaVO;
import com.album.vo.EventVO;
import com.album.vo.OrderListVO;
import com.album.vo.OrderVO;
import com.album.vo.ReviewVO;
import com.google.gson.JsonObject;

@Controller
@RequestMapping(value = "/admin")
public class AdminShopController {
	
	@Resource(name="uploadPath")
	private String uploadPath;   
	@Autowired
	private AdminShopService shopmapper;
	
	private Logger logger = LoggerFactory.getLogger(AdminShopController.class);
	
	// 주문 전체 목록
	@RequestMapping (value="/shop/orderList" , method = RequestMethod.GET)
	public void orderList (Model model , OrderListVO olvo) throws Exception{
		
		logger.info("전체 주문 목록");
		
		List<OrderListVO> orderList = shopmapper.orderList(olvo);
		
		model.addAttribute("orderList", orderList);
	}
	
	// 주문 특정 상세 목록 
	@RequestMapping (value="/shop/orderView", method = RequestMethod.GET)
	public void orderview (HttpSession session, @RequestParam("n") String orderid , OrderListVO olvo , Model model ) throws Exception{
		
		logger.info("주문 상세 목록");
		
		olvo.setOrderId(orderid);
		List<OrderListVO> orderView = shopmapper.orderView(olvo);
		
		model.addAttribute("orderView", orderView);
	}
	
	
	// 배송 상태 변경 	
	@RequestMapping (value="/shop/orderView", method = RequestMethod.POST)
	public String delivery (OrderVO ovo) throws Exception{
		logger.info("배송 상태 변경");
		
		shopmapper.delivery(ovo);
		
		return "redirect:/admin/shop/orderView?n=" + ovo.getOrderId();
	}
	
	// 제품 리뷰 목록 
	@RequestMapping (value="/shop/reviewList", method = RequestMethod.GET)
	public void reviewList (ReviewVO rvo , Model model) throws Exception{
		logger.info("리뷰 불러오기");
		
		List<ReviewVO> review = shopmapper.allReview(rvo);
		
		model.addAttribute("review", review);
	}
	
	// 제품 리뷰 삭제
	@RequestMapping (value="/shop/reviewList", method = RequestMethod.POST)
	public String deleteReview (ReviewVO rvo) throws Exception{
		logger.info("리뷰 삭제");
		
		shopmapper.ReviewDelete(rvo.getRwNumber());
		
		return "redirect:/admin/shop/reviewList";	
	
	}
	
	// 이벤트 등록 페이지 
	@RequestMapping (value="/shop/event", method = RequestMethod.GET)
	public void getEvent () throws Exception{
		logger.info("이벤트 등록 페이지");
	}
	
	
	// 이벤트 등록 페이지 
		@RequestMapping (value="/shop/event", method = RequestMethod.POST)
		public void inserEvent (EventVO evo , MultipartFile file) throws Exception{
			
			//파일업로드 
					String imgUploadPath = uploadPath + File.separator + "eventImg";
					String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
					String fileName = null;
				
					
					if(file.getOriginalFilename()!= null && !file.getOriginalFilename().equals("")) {
						fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
						//gdsimg에 원본 파일 경로 + 파일명 저장 
						evo.setEvImg(File.separator + "eventImg" + ymdPath + File.separator + fileName);
					
						
					}else {
						//첨부파일이 없으면 
						 fileName = File.separator + "img" + File.separator + "none.png";
						  // 미리 준비된 none.png파일을 대신 출력함					  
						 evo.setEvImg(fileName);
						
					}
				
			shopmapper.eventInsert(evo);
			logger.info("상품 등록 처리");
			System.out.println(evo);
			
		}
		
		//ck에디터 파일 업로드 
		
		@ResponseBody
			@RequestMapping(value="shop/eventImg" , method=RequestMethod.POST)
			public void eventckupload (HttpServletRequest request, HttpServletResponse response,MultipartHttpServletRequest multiFile ) throws Exception{
				
				
				JsonObject json = new JsonObject();
				PrintWriter printWriter = null;
				OutputStream out = null;
				MultipartFile file = multiFile.getFile("upload");
				
				if(file.getSize() > 0 && StringUtils.isNotBlank(file.getName())) {
					if(file.getContentType().toLowerCase().startsWith("image/")) {
						try {
							String fileName = file.getName();
							byte [] bytes = file.getBytes();
							String ckuploadPath =  uploadPath + File.separator + "eventImg";
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
							String fileUrl = request.getContextPath()+"/resources/eventImg/"+fileName;
							
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
			
		
	// 이벤트 목록 
	@RequestMapping(value="shop/eventlist" , method=RequestMethod.GET)
	public void eventList ( Model model , CriteriaVO cri) throws Exception{
		logger.info("이벤트 목록");
		List<EventVO> evo = shopmapper.eventList();
		model.addAttribute("event", evo);
	}
	
	// 이벤트 상세
		@RequestMapping(value="shop/eventView" , method=RequestMethod.GET)
		public void eventView (int evNumber , Model model) throws Exception{
			
			logger.info("이벤트 상세 보기");
			model.addAttribute("view", shopmapper.eventView(evNumber));
			
		}

	//이벤트 삭제
	@RequestMapping(value="/shop/evdelete" , method = RequestMethod.GET)
		public String evdelete(@RequestParam("evNumber")int evNumber) throws Exception{
			logger.info("상품삭제");
			shopmapper.evdelete(evNumber);
		
			return "redirect:/admin/shop/eventlist";
		}
		
		
	//이벤트 수정 이동
	@RequestMapping(value ="/shop/evmodify", method=RequestMethod.GET)
		public void evmodifyGet (@RequestParam("evNumber") int evNumber , Model model , EventVO evo) throws Exception{
		evo = shopmapper.eventView(evNumber);
			 model.addAttribute("event", evo);
	
			System.out.println(evo);
		}		
		
	
	//상품 수정 처리 
		@RequestMapping(value="/shop/evmodify", method=RequestMethod.POST)
		public String evmodifyPost (EventVO evo , HttpServletRequest request , MultipartFile file)throws Exception{
			
			shopmapper.eventView(evo.getEvNumber());
			 
			 // 첨부파일 수정 
		
				 if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
				  // 기존 파일 삭제
					 new File(uploadPath + request.getParameter("eventImg")).delete();
				  
				  // 새로 등록된 파일 변경
				
				  String imgUploadPath = uploadPath + File.separator + "eventImg";
				  String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
				  String fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
				  
				  evo.setEvImg(File.separator + "eventImg" + ymdPath + File.separator + fileName);
			
				  
				 } else {  
					 
					 //변경x
				  evo.setEvImg(request.getParameter("eventImg"));
				
				  
			 }
				 shopmapper.evmodify(evo);
				 logger.info("수정처리");
				 return "redirect:/admin/shop/eventlist";
		}
		
}
