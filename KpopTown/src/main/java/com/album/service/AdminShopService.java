package com.album.service;

import java.util.List;

import com.album.vo.EventVO;
import com.album.vo.OrderListVO;
import com.album.vo.OrderVO;
import com.album.vo.ReviewVO;

public interface AdminShopService {
	//전체 주문 목록 
	public List<OrderListVO> orderList(OrderListVO olvo) throws Exception;
		
	//특정 주문 상세 목록 
	public List<OrderListVO> orderView (OrderListVO olvo) throws Exception;
		
	// 배송 상태 변경 
	public void delivery (OrderVO ovo) throws Exception;
		
	// 제품 리뷰 목록 
	public List<ReviewVO> allReview (ReviewVO rvo) throws Exception;
		
	// 제품 리뷰 삭제 
	public void ReviewDelete (int rwNumber) throws Exception;
		
	// 이벤트 등록 
	public void eventInsert (EventVO evo) throws Exception;
		
	// 이벤트 목록 
	public List<EventVO> eventList () throws Exception;
		
	// 이벤트 상새 
	public EventVO eventView (int evNumber) throws Exception;
		
	//이벤트 삭제
	public void evdelete (int evNumber) throws Exception;	
		
	//이벤트 수정 
	public void evmodify (EventVO evo) throws Exception;
}
