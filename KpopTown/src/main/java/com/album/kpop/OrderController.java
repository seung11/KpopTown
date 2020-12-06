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
public class OrderController {
	

	@Autowired
	private OrderService oderservice;
	private Logger logger = LoggerFactory.getLogger(OrderController.class);
	@Resource(name="uploadPath")
	private String uploadPath;   
	

	
	//��ٱ���
	@ResponseBody
	@RequestMapping(value="/shopview/addCart" , method=RequestMethod.POST)
	public int addCart (CartVO cvo, HttpSession session) throws Exception{
		
		int result = 0;
		MemberVO memvo = (MemberVO)session.getAttribute("member");
		System.out.println("���� ���� " + memvo);
		
		if( memvo != null) {
			cvo.setUserid(memvo.getUserid());
			oderservice.addCart(cvo);
			result = 1;
		}
		return result;
		}
	
	
	// ��ٱ��� ���
	@RequestMapping(value="/cartList" , method=RequestMethod.GET)
	public String cartList (HttpSession session , Model model) throws Exception{
		 MemberVO memvo = (MemberVO)session.getAttribute("member");
		 if(memvo == null) {
		
			 System.out.println("�α��� ���� �ʾ���");
			 return "/member/signin";
		 }else {
			 String userid = memvo.getUserid();
			 List<CartVO> cartList = oderservice.cartList(userid);
			 System.out.println("�������̵�" + userid);
			 model.addAttribute("cartList", cartList);
			 return "/shop/cartList";
		 }	
	}
	
	// ��ٱ��� ����
	@ResponseBody
	@RequestMapping (value="/deleteCart" , method=RequestMethod.POST)
	public int deleteCart (HttpSession session, @RequestParam (value="Check[]") List<String> chArr, CartVO cvo) throws Exception{
		
		MemberVO memvo = (MemberVO)session.getAttribute("member");
		String userid = memvo.getUserid();
		 int result = 0;
		 int cartnum = 0;
		 
		if(memvo != null) {
			cvo.setUserid(userid);
			
			for(String i : chArr) {
				cartnum = Integer.parseInt(i);
				cvo.setCartNum(cartnum);
				oderservice.deleteCart(cvo);
			}
			  result = 1;
		}
		
		return result;
	}
	
	
	
	// �ֹ� �Է�  
	@RequestMapping (value ="/cartList" , method=RequestMethod.POST)
	public String postorder (HttpSession session , OrderVO ovo , OrderDetailVO odvo , MemberVO mvo , productVO pvo) throws Exception{
		
		logger.info("�ֹ�����");
		
		MemberVO memvo = (MemberVO)session.getAttribute("member");
		String userid = memvo.getUserid();
	
	
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		String ymd = ym + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		String subNum = "";
		
		for (int i = 1; i<=6; i ++) {
			subNum += (int)(Math.random() * 10);
		}
		
		String orderid = ymd + "_" + subNum;
		
		ovo.setOrderId(orderid);
		ovo.setUserid(userid);

		oderservice.order(ovo);	// �ֹ�����
		oderservice.updatePoint(mvo); // ����Ʈ
	   
	   System.out.println("�������̵�" + orderid);
		System.out.println("�ֹ� ���� ���̵�" + userid);		
		
		
		odvo.setOrderId(orderid);

		oderservice.orderDetail(odvo);
		oderservice.CartClear(userid);
		
		// �Ǹŷ� ��ó��
	/*	shopservice.sellCount(pvo); // �Ǹŷ� ����
		int sellcount  = pvo.getSellCount();
		System.out.println("�Ǹŷ�" + sellcount);*/
		
		return "redirect:/shop/orderList";
	}
	
	
	// �ֹ� ���
	@RequestMapping (value ="/orderList" , method=RequestMethod.GET)
	public String cartList (HttpSession session, OrderListVO olvo , Model model)throws Exception{
		
		logger.info("�ֹ� ���");
		

		 MemberVO memvo = (MemberVO)session.getAttribute("member");
		 if(memvo == null) {
		
			 System.out.println("�α��� ���� �ʾ���");
			 return "/member/signin";
		 }else {
			 String userid = memvo.getUserid();
			 olvo.setUserid(userid);
			 
			 List<OrderListVO> orderList = oderservice.orderList(olvo);
			 
			 model.addAttribute("orderList", orderList);
			 
			 return "shop/orderList";
		 }
		 
	}
	
	// �ֹ� �󼼺��� 
	@RequestMapping (value ="/orderView" , method=RequestMethod.GET)
	public String orderView (HttpSession session, @RequestParam("n") String orderid , OrderListVO olvo , Model model)throws Exception{
		
		logger.info("�ֹ� �󼼺���");
		 MemberVO memvo = (MemberVO)session.getAttribute("member");
		 if(memvo == null) {
		
			 System.out.println("�α��� ���� �ʾ���");
			 return "/member/signin";
		 }else {
			 String userid = memvo.getUserid();
			 olvo.setUserid(userid);
			 olvo.setOrderId(orderid);
			 
			 List<OrderListVO> orderView = oderservice.orderView(olvo);
			 
			 model.addAttribute("orderView", orderView);
			 
			 return "shop/orderView";
		 }	
	}
	
	
}
