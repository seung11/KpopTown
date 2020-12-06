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
	
	// �ֽŵ�� ��ǰ ���ο� �����ֱ�
	@Override
	public List<productVO> newRelease() throws Exception {
		
		return main.newRelease();
	}
	
	// ���ο� ī�װ��� ��ǰ �����ֱ�
	@Override
	public List<productVO> mainProduct() throws Exception {
		
		return main.mainProduct();
	}
	
	
	


	
}
