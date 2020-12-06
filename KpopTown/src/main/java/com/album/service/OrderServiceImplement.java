package com.album.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.album.mapper.OrderMapper;
import com.album.vo.CartVO;
import com.album.vo.MemberVO;
import com.album.vo.OrderDetailVO;
import com.album.vo.OrderListVO;
import com.album.vo.OrderVO;
import com.album.vo.productVO;

@Service
public class OrderServiceImplement  implements OrderService{

	@Autowired
	private OrderMapper ordermapper;
	
		// 장바구니
		@Override
		public void addCart(CartVO cvo) throws Exception {
			ordermapper.addCart(cvo);
			
		}
		
		// 장바구니 목록
		@Override
		public List<CartVO> cartList(String userid) throws Exception {
			
			return ordermapper.cartList(userid);
		}
		
		// 장바구니 삭제
		@Override
		public void deleteCart(CartVO cvo) throws Exception {
			ordermapper.deleteCart(cvo);
			
		}
		
		// 주문 정보
		@Override
		public void order(OrderVO ovo) throws Exception {
			 
			ordermapper.order(ovo);
			
		}
		
		// 주문 상세정보
		@Override
		public void orderDetail(OrderDetailVO odvo) throws Exception {
			ordermapper.orderDetail(odvo);
		}
		
		// 장바구니 비우기
		@Override
		public void CartClear(String userid) throws Exception {
			ordermapper.CartClear(userid);
			
		}
		
		// 주문 목록
		@Override
		public List<OrderListVO> orderList(OrderListVO olvo) throws Exception {
			
			return ordermapper.orderList(olvo);
		}
		
		// 주문 상세보기
		@Override
		public List<OrderListVO> orderView(OrderListVO olvo) throws Exception {
			
			return ordermapper.orderView(olvo);
		}

		// 주문완료시 포인트 추가
		@Override
		public void updatePoint(MemberVO mvo) throws Exception {
			
			ordermapper.updatePoint(mvo);
			
		}

		
}
