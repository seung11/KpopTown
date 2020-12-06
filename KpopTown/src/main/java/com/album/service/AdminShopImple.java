package com.album.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.album.mapper.AdminShopMapper;
import com.album.vo.EventVO;
import com.album.vo.OrderListVO;
import com.album.vo.OrderVO;
import com.album.vo.ReviewVO;

@Service
public class AdminShopImple implements AdminShopService{
	@Autowired
	private AdminShopMapper adshopmapper;
	
		// 전체 주문 목록
		@Override
		public List<OrderListVO> orderList(OrderListVO olvo) throws Exception {
			
			return adshopmapper.orderList(olvo);
		}


		// 특정 주문 상세 목록
		@Override
		public List<OrderListVO> orderView(OrderListVO olvo) throws Exception {
		
			return adshopmapper.orderView(olvo);
		}

		// 배송 상태 변경
		@Override
		public void delivery(OrderVO ovo) throws Exception {
			
			adshopmapper.delivery(ovo);
			
		}

		// 제품 리뷰 목록
		@Override
		public List<ReviewVO> allReview(ReviewVO rvo) throws Exception {
			return adshopmapper.allReview(rvo);
		}

		// 제품 리뷰 삭제
		@Override
		public void ReviewDelete(int rwNumber) throws Exception {
			adshopmapper.ReviewDelete(rwNumber);
			
		}

		// 이벤트 등록
		@Override
		public void eventInsert(EventVO evo) throws Exception {
			adshopmapper.eventInsert(evo);
			
		}

		
		// 이벤트 목록
		@Override
		public List<EventVO> eventList() throws Exception {
			
			return adshopmapper.eventList();
		}

		// 이벤드 상세
		@Override
		public EventVO eventView(int evNumber) throws Exception {
		
			return adshopmapper.eventView(evNumber);
		}

		// 이벤트 삭제
		@Override
		public void evdelete(int evNumber) throws Exception {
			adshopmapper.evdelete(evNumber);
			
		}

		// 이벤트 수정
		@Override
		public void evmodify(EventVO evo) throws Exception {
			adshopmapper.evmodify(evo);
			
		}

		
}
