package com.album.mapper;

import java.util.List;

import com.album.vo.CartVO;
import com.album.vo.MemberVO;
import com.album.vo.OrderDetailVO;
import com.album.vo.OrderListVO;
import com.album.vo.OrderVO;
import com.album.vo.productVO;

public interface OrderMapper {

	// 장바구니
	public void addCart(CartVO cvo) throws Exception;
	
	// 장바구니 목록 
	public List<CartVO> cartList (String userid) throws Exception;
		
	// 장바구니 삭제
	public void deleteCart (CartVO cvo) throws Exception;
		
	// 주문 정보 
	public void order(OrderVO ovo) throws Exception;
		
	// 주문 상세정보
	public void orderDetail (OrderDetailVO odvo) throws Exception;
		
	// 장바구니 비우기
	public void CartClear (String userid) throws Exception;
	
	// 주문목록
	public List<OrderListVO> orderList (OrderListVO olvo) throws Exception;
	
	// 주문 상세보기
	public List<OrderListVO> orderView (OrderListVO olvo) throws Exception;
	
	// 주문완료시 포인트 추가 
	public void updatePoint(MemberVO mvo) throws Exception;
		
	// 주문완료시 판매량 증가 
	//public void sellCount (productVO pvo) throws Exception;
}
