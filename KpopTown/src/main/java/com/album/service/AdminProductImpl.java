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
	
	
	//ī�װ�
	@Override
	public List<CategoryVO> category() throws Exception {
		
		return apmapper.category();
	}
	

	// ��ǰ���
	@Override
	public void insert(productVO pvo) throws Exception {
		apmapper.insert(pvo);
		
	}

	// ��ǰ ���
	@Override
	public List<productVO> list() throws Exception {
		return apmapper.list();
	}
	
	
	// ����¡ ó�� ��ǰ ����Ʈ 
	@Override
	public List<Map<String, Object>> listPage(CriteriaVO cri) throws Exception {
		return apmapper.listPage(cri);
	}

	
	// �� �Խù� �� 
	@Override
	public int totalCount(CriteriaVO cri) throws Exception {
		return apmapper.totalCount(cri);
	}
	
	// ��ǰ ����
	@Override
	public void delete(int pvo) throws Exception {
		apmapper.delete(pvo);
		
	}
	
	// ��ǰ ����
	@Override
	public void modify(productVO pvo) throws Exception {
		apmapper.modify(pvo);
	
	}

	// �󼼺��� + ī�װ�
	@Override
	public productVO productView (int goodsnumber) throws Exception {
		
		return apmapper.productView (goodsnumber);
	}

	

	



	
	
	
	
}
