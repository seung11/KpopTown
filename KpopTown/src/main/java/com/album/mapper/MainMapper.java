package com.album.mapper;

import java.util.List;

import com.album.vo.productVO;

public interface MainMapper {

	// 메인에 최신등록 제품 보여주기 
	public List<productVO> newRelease () throws Exception;
	
	// 메인에 카테고리별 제품 보여주기
	public List<productVO> mainProduct () throws Exception;
}
