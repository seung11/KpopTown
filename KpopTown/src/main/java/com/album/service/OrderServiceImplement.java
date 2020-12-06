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
	
		// ��ٱ���
		@Override
		public void addCart(CartVO cvo) throws Exception {
			ordermapper.addCart(cvo);
			
		}
		
		// ��ٱ��� ���
		@Override
		public List<CartVO> cartList(String userid) throws Exception {
			
			return ordermapper.cartList(userid);
		}
		
		// ��ٱ��� ����
		@Override
		public void deleteCart(CartVO cvo) throws Exception {
			ordermapper.deleteCart(cvo);
			
		}
		
		// �ֹ� ����
		@Override
		public void order(OrderVO ovo) throws Exception {
			 
			ordermapper.order(ovo);
			
		}
		
		// �ֹ� ������
		@Override
		public void orderDetail(OrderDetailVO odvo) throws Exception {
			ordermapper.orderDetail(odvo);
		}
		
		// ��ٱ��� ����
		@Override
		public void CartClear(String userid) throws Exception {
			ordermapper.CartClear(userid);
			
		}
		
		// �ֹ� ���
		@Override
		public List<OrderListVO> orderList(OrderListVO olvo) throws Exception {
			
			return ordermapper.orderList(olvo);
		}
		
		// �ֹ� �󼼺���
		@Override
		public List<OrderListVO> orderView(OrderListVO olvo) throws Exception {
			
			return ordermapper.orderView(olvo);
		}

		// �ֹ��Ϸ�� ����Ʈ �߰�
		@Override
		public void updatePoint(MemberVO mvo) throws Exception {
			
			ordermapper.updatePoint(mvo);
			
		}

		
}
