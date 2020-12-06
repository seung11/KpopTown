package com.album.mapper;

import java.util.List;
import java.util.Map;

import com.album.vo.CategoryVO;
import com.album.vo.CriteriaVO;
import com.album.vo.EventVO;
import com.album.vo.OrderListVO;
import com.album.vo.OrderVO;
import com.album.vo.ReviewVO;
import com.album.vo.productVO;

public interface AdminProductMapper {
	
		//카테고리 
		public List<CategoryVO> category() throws Exception;

		//상품등록eventList
		public void insert (productVO pvo) throws Exception;
		
		//상품리스트 
		public List<productVO> list ()throws Exception;
		
		//페이징 처리 상품리스트
		public List<Map<String, Object>> listPage (CriteriaVO cri) throws Exception;
		
		//총 게시글 수 
		public int totalCount (CriteriaVO cri) throws Exception;
		
/*   	//상세페이지
		public productVO view (int goodsnumber)throws Exception;*/
		 
		//상품 삭제
		public void delete (int pvo) throws Exception;	
		
		//상품 수정 
		public void modify (productVO pvo) throws Exception;

		//상세보기+카테고리 
		public productVO productView (int goodsnumber)throws Exception;
		
		
}
