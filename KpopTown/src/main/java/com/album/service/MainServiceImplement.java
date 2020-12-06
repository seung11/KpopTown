package com.album.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.album.mapper.MainMapper;
import com.album.vo.productVO;

@Service
public class MainServiceImplement implements MainService {

	@Autowired
	private MainMapper main;
	
	// 최신등록 제품 메인에 보여주기
	@Override
	public List<productVO> newRelease() throws Exception {
		
		return main.newRelease();
	}
	
	// 메인에 카테고리별 제품 보여주기
	@Override
	public List<productVO> mainProduct() throws Exception {
		
		return main.mainProduct();
	}
	
	
	


	
}
