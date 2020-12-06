package com.album.service;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.album.mapper.AdminProductMapper;
import com.album.mapper.AdminShopMapper;
import com.album.vo.CategoryVO;
import com.album.vo.CriteriaVO;
import com.album.vo.EventVO;
import com.album.vo.OrderListVO;
import com.album.vo.OrderVO;
import com.album.vo.ReviewVO;
import com.album.vo.productVO;


@Service
public class AdminProductImpl implements AdminProductService{

	@Autowired
	private AdminProductMapper apmapper;
	
	
	//카테고리
	@Override
	public List<CategoryVO> category() throws Exception {
		
		return apmapper.category();
	}
	

	// 제품등록
	@Override
	public void insert(productVO pvo) throws Exception {
		apmapper.insert(pvo);
		
	}

	// 제품 목록
	@Override
	public List<productVO> list() throws Exception {
		return apmapper.list();
	}
	
	
	// 페이징 처리 상품 리스트 
	@Override
	public List<Map<String, Object>> listPage(CriteriaVO cri) throws Exception {
		return apmapper.listPage(cri);
	}

	
	// 총 게시물 수 
	@Override
	public int totalCount(CriteriaVO cri) throws Exception {
		return apmapper.totalCount(cri);
	}
	
	// 상품 삭제
	@Override
	public void delete(int pvo) throws Exception {
		apmapper.delete(pvo);
		
	}
	
	// 상품 수정
	@Override
	public void modify(productVO pvo) throws Exception {
		apmapper.modify(pvo);
	
	}

	// 상세보기 + 카테고리
	@Override
	public productVO productView (int goodsnumber) throws Exception {
		
		return apmapper.productView (goodsnumber);
	}

	

	



	
	
	
	
}
