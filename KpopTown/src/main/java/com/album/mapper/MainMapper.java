package com.album.mapper;

import java.util.List;

import com.album.vo.productVO;

public interface MainMapper {

	// ���ο� �ֽŵ�� ��ǰ �����ֱ� 
	public List<productVO> newRelease () throws Exception;
	
	// ���ο� ī�װ��� ��ǰ �����ֱ�
	public List<productVO> mainProduct () throws Exception;
}
