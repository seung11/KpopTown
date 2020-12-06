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
	
	// 제품 리스트
	@Override
	public List<productVO> list(int catecode) throws Exception {
		
		return shopmapper.list(catecode);
	}
	
	// 페이징 리스트
	@Override
	public List<productVO> listPage(CriteriaVO cri,int catecode) throws Exception {
		return shopmapper.listPage(cri,catecode);
	}

	// 총 게시글 수 
	@Override
	public int totalCount(CriteriaVO cri) throws Exception {
		return shopmapper.totalCount(cri);
	}

	
	// 상세보기
	@Override
	public productVO view(int goodsnumber) throws Exception {
	
		return shopmapper.view(goodsnumber);
	}
	
	// 상품 리뷰 작성
	@Override
	public void reviewRegist(ReviewVO rvo) throws Exception {
		shopmapper.reviewRegist(rvo);
		
	}

	//리뷰 리스트
	@Override
	public List<ReviewVO> reviewList(int goodsnumber) throws Exception {
		
		return shopmapper.reviewList(goodsnumber);
	}
	
	// 리뷰 삭제
	@Override
	public void reviewDelete(ReviewVO rvo) throws Exception {
		shopmapper.reviewDelete(rvo);
		
	}

	// 아이디 확인
	@Override
	public String reviewIdCheck(int rwNumber) throws Exception {
		
		return shopmapper.reviewIdCheck(rwNumber);
	}
	
	// 리뷰 수정
	@Override
	public void reviewModify(ReviewVO rvo) throws Exception {
		
		shopmapper.reviewModify(rvo);
		
	}
	
	
	// 이벤트 리스트
	@Override
	public List<EventVO> eventList() throws Exception {
		
		return shopmapper.eventList();
	}
	
	// 이벤트 상세 보기
	@Override
	public EventVO evenView(int evNumber) throws Exception {
		
		return shopmapper.evenView(evNumber);
	}
	

	
}
