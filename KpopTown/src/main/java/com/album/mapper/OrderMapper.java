package com.album.mapper;

import java.util.List;

import com.album.vo.CartVO;
import com.album.vo.MemberVO;
import com.album.vo.OrderDetailVO;
import com.album.vo.OrderListVO;
import com.album.vo.OrderVO;
import com.album.vo.productVO;

public interface OrderMapper {

	// ��ٱ���
	public void addCart(CartVO cvo) throws Exception;
	
	// ��ٱ��� ��� 
	public List<CartVO> cartList (String userid) throws Exception;
		
	// ��ٱ��� ����
	public void deleteCart (CartVO cvo) throws Exception;
		
	// �ֹ� ���� 
	public void order(OrderVO ovo) throws Exception;
		
	// �ֹ� ������
	public void orderDetail (OrderDetailVO odvo) throws Exception;
		
	// ��ٱ��� ����
	public void CartClear (String userid) throws Exception;
	
	// �ֹ����
	public List<OrderListVO> orderList (OrderListVO olvo) throws Exception;
	
	// �ֹ� �󼼺���
	public List<OrderListVO> orderView (OrderListVO olvo) throws Exception;
	
	// �ֹ��Ϸ�� ����Ʈ �߰� 
	public void updatePoint(MemberVO mvo) throws Exception;
		
	// �ֹ��Ϸ�� �Ǹŷ� ���� 
	//public void sellCount (productVO pvo) throws Exception;
}
