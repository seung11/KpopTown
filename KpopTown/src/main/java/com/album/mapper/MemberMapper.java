package com.album.mapper;

import com.album.vo.MemberVO;

public interface MemberMapper {

	//ȸ������ 
	public void signup (MemberVO memvo)throws Exception;
	//���̵� �ߺ�Ȯ��
	public int idcheck(String userid) throws Exception;
	//�α���
	public MemberVO signin (MemberVO memvo) throws Exception;
	//���̵� ã�� 
	public String findid (MemberVO memvo) throws Exception;
	//��й�ȣ ã�� 
	public void findpw (MemberVO memvo)throws Exception;
	//��й�ȣ ã��� select 
	public String finduser (MemberVO memvo)throws Exception;
	//ȸ������ ����
	public void memModify (MemberVO memvo)throws Exception;
	//ȸ��Ż��
	public void memDelet (MemberVO memvo)throws Exception;
	
}
