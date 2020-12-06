package com.album.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.album.mapper.ShopMapper;
import com.album.vo.CartVO;
import com.album.vo.CriteriaVO;
import com.album.vo.EventVO;
import com.album.vo.MemberVO;
import com.album.vo.OrderDetailVO;
import com.album.vo.OrderListVO;
import com.album.vo.OrderVO;
import com.album.vo.ReviewVO;
import com.album.vo.productVO;

@Service
public class ShopImplement implements ShopService{
	
	@Autowired
	private ShopMapper shopmapper;
	
	// ��ǰ ����Ʈ
	@Override
	public List<productVO> list(int catecode) throws Exception {
		
		return shopmapper.list(catecode);
	}
	
	// ����¡ ����Ʈ
	@Override
	public List<productVO> listPage(CriteriaVO cri,int catecode) throws Exception {
		return shopmapper.listPage(cri,catecode);
	}

	// �� �Խñ� �� 
	@Override
	public int totalCount(CriteriaVO cri) throws Exception {
		return shopmapper.totalCount(cri);
	}

	
	// �󼼺���
	@Override
	public productVO view(int goodsnumber) throws Exception {
	
		return shopmapper.view(goodsnumber);
	}
	
	// ��ǰ ���� �ۼ�
	@Override
	public void reviewRegist(ReviewVO rvo) throws Exception {
		shopmapper.reviewRegist(rvo);
		
	}

	//���� ����Ʈ
	@Override
	public List<ReviewVO> reviewList(int goodsnumber) throws Exception {
		
		return shopmapper.reviewList(goodsnumber);
	}
	
	// ���� ����
	@Override
	public void reviewDelete(ReviewVO rvo) throws Exception {
		shopmapper.reviewDelete(rvo);
		
	}

	// ���̵� Ȯ��
	@Override
	public String reviewIdCheck(int rwNumber) throws Exception {
		
		return shopmapper.reviewIdCheck(rwNumber);
	}
	
	// ���� ����
	@Override
	public void reviewModify(ReviewVO rvo) throws Exception {
		
		shopmapper.reviewModify(rvo);
		
	}
	
	
	// �̺�Ʈ ����Ʈ
	@Override
	public List<EventVO> eventList() throws Exception {
		
		return shopmapper.eventList();
	}
	
	// �̺�Ʈ �� ����
	@Override
	public EventVO evenView(int evNumber) throws Exception {
		
		return shopmapper.evenView(evNumber);
	}
	

	
}
