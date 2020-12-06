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
	
		// ��ü �ֹ� ���
		@Override
		public List<OrderListVO> orderList(OrderListVO olvo) throws Exception {
			
			return adshopmapper.orderList(olvo);
		}


		// Ư�� �ֹ� �� ���
		@Override
		public List<OrderListVO> orderView(OrderListVO olvo) throws Exception {
		
			return adshopmapper.orderView(olvo);
		}

		// ��� ���� ����
		@Override
		public void delivery(OrderVO ovo) throws Exception {
			
			adshopmapper.delivery(ovo);
			
		}

		// ��ǰ ���� ���
		@Override
		public List<ReviewVO> allReview(ReviewVO rvo) throws Exception {
			return adshopmapper.allReview(rvo);
		}

		// ��ǰ ���� ����
		@Override
		public void ReviewDelete(int rwNumber) throws Exception {
			adshopmapper.ReviewDelete(rwNumber);
			
		}

		// �̺�Ʈ ���
		@Override
		public void eventInsert(EventVO evo) throws Exception {
			adshopmapper.eventInsert(evo);
			
		}

		
		// �̺�Ʈ ���
		@Override
		public List<EventVO> eventList() throws Exception {
			
			return adshopmapper.eventList();
		}

		// �̺��� ��
		@Override
		public EventVO eventView(int evNumber) throws Exception {
		
			return adshopmapper.eventView(evNumber);
		}

		// �̺�Ʈ ����
		@Override
		public void evdelete(int evNumber) throws Exception {
			adshopmapper.evdelete(evNumber);
			
		}

		// �̺�Ʈ ����
		@Override
		public void evmodify(EventVO evo) throws Exception {
			adshopmapper.evmodify(evo);
			
		}

		
}
