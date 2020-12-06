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
	
		//ī�װ� 
		public List<CategoryVO> category() throws Exception;

		//��ǰ���eventList
		public void insert (productVO pvo) throws Exception;
		
		//��ǰ����Ʈ 
		public List<productVO> list ()throws Exception;
		
		//����¡ ó�� ��ǰ����Ʈ
		public List<Map<String, Object>> listPage (CriteriaVO cri) throws Exception;
		
		//�� �Խñ� �� 
		public int totalCount (CriteriaVO cri) throws Exception;
		
/*   	//��������
		public productVO view (int goodsnumber)throws Exception;*/
		 
		//��ǰ ����
		public void delete (int pvo) throws Exception;	
		
		//��ǰ ���� 
		public void modify (productVO pvo) throws Exception;

		//�󼼺���+ī�װ� 
		public productVO productView (int goodsnumber)throws Exception;
		
		
}
