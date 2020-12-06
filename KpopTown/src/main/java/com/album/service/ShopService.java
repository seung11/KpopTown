package com.album.service;

import java.util.List;
import java.util.Map;

import com.album.vo.CartVO;
import com.album.vo.CriteriaVO;
import com.album.vo.EventVO;
import com.album.vo.MemberVO;
import com.album.vo.OrderDetailVO;
import com.album.vo.OrderListVO;
import com.album.vo.OrderVO;
import com.album.vo.ReviewVO;
import com.album.vo.productVO;


public interface ShopService {
	
	// ��ǰ ����Ʈ
	public List<productVO> list (int catecode) throws Exception;
	//����¡ ó�� ��ǰ����Ʈ
	public List<productVO> listPage (CriteriaVO cri,int catecode) throws Exception;
	//�� �Խñ� �� 
	public int totalCount (CriteriaVO cri) throws Exception;
	//�󼼺���
	public productVO view (int goodsnumber)throws Exception;
	//��ǰ�����ۼ� 
	public void reviewRegist (ReviewVO rvo) throws Exception;
	//���� ���
	public List<ReviewVO> reviewList (int goodsnumber) throws Exception;
	//���� ����
	public void reviewDelete (ReviewVO rvo) throws Exception;
	// ���̵� Ȯ��
	public String reviewIdCheck (int rwNumber) throws Exception;
	// ���� ����
	public void reviewModify (ReviewVO rvo) throws Exception;	
	// �̺�Ʈ ����Ʈ 
	public List<EventVO> eventList () throws Exception;
	// �̺�Ʈ �󼼺��� 
	public EventVO evenView (int evNumber) throws Exception;

	
}
