package com.album.service;

import java.util.List;

import com.album.vo.productVO;

public interface MainService {

	// ���ο� �ֽŵ�� ��ǰ �����ֱ� 
	public List<productVO> newRelease () throws Exception;
	// ���ο� ī�װ��� ��ǰ �����ֱ�
	public List<productVO> mainProduct () throws Exception;
}
