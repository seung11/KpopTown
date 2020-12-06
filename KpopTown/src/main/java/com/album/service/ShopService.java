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
	
	// 제품 리스트
	public List<productVO> list (int catecode) throws Exception;
	//페이징 처리 상품리스트
	public List<productVO> listPage (CriteriaVO cri,int catecode) throws Exception;
	//총 게시글 수 
	public int totalCount (CriteriaVO cri) throws Exception;
	//상세보기
	public productVO view (int goodsnumber)throws Exception;
	//상품리뷰작성 
	public void reviewRegist (ReviewVO rvo) throws Exception;
	//리뷰 목록
	public List<ReviewVO> reviewList (int goodsnumber) throws Exception;
	//리뷰 삭제
	public void reviewDelete (ReviewVO rvo) throws Exception;
	// 아이디 확인
	public String reviewIdCheck (int rwNumber) throws Exception;
	// 리뷰 수정
	public void reviewModify (ReviewVO rvo) throws Exception;	
	// 이벤트 리스트 
	public List<EventVO> eventList () throws Exception;
	// 이벤트 상세보기 
	public EventVO evenView (int evNumber) throws Exception;

	
}
