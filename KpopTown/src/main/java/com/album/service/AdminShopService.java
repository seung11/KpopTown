package com.album.service;

import java.util.List;

import com.album.vo.EventVO;
import com.album.vo.OrderListVO;
import com.album.vo.OrderVO;
import com.album.vo.ReviewVO;

public interface AdminShopService {
	//��ü �ֹ� ��� 
	public List<OrderListVO> orderList(OrderListVO olvo) throws Exception;
		
	//Ư�� �ֹ� �� ��� 
	public List<OrderListVO> orderView (OrderListVO olvo) throws Exception;
		
	// ��� ���� ���� 
	public void delivery (OrderVO ovo) throws Exception;
		
	// ��ǰ ���� ��� 
	public List<ReviewVO> allReview (ReviewVO rvo) throws Exception;
		
	// ��ǰ ���� ���� 
	public void ReviewDelete (int rwNumber) throws Exception;
		
	// �̺�Ʈ ��� 
	public void eventInsert (EventVO evo) throws Exception;
		
	// �̺�Ʈ ��� 
	public List<EventVO> eventList () throws Exception;
		
	// �̺�Ʈ ��� 
	public EventVO eventView (int evNumber) throws Exception;
		
	//�̺�Ʈ ����
	public void evdelete (int evNumber) throws Exception;	
		
	//�̺�Ʈ ���� 
	public void evmodify (EventVO evo) throws Exception;
}
