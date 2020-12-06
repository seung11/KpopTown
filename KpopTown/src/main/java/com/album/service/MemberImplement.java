package com.album.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.album.mapper.MemberMapper;
import com.album.vo.MemberVO;

@Service
public class MemberImplement implements MemberService{

	
	@Autowired
	private MemberMapper memmapper;
	
	// ȸ������
	@Override
	public void signup(MemberVO memvo) throws Exception {
		memmapper.signup(memvo);
		
	}
	
	// ���̵� �ߺ�Ȯ��
	@Override
	public int idcheck(String userid) throws Exception {
		return memmapper.idcheck(userid);
	}
	
	//�α���
	@Override
	public MemberVO signin(MemberVO memvo) throws Exception {
		
		return memmapper.signin(memvo);
	}
	//���̵� ã��
	@Override
	public String findid(MemberVO memvo) throws Exception {
		
		return memmapper.findid(memvo);
	}
	
	//��й�ȣ ã��
	@Override
	public void findpw(MemberVO memvo) throws Exception {
	
		memmapper.findpw(memvo);
	}

	// ��й�ȣ ã��� select 
	@Override
	public String finduser(MemberVO memvo) throws Exception {
		
		return memmapper.finduser(memvo);
	}

	// ȸ������ ����
	@Override
	public void memModify(MemberVO memvo) throws Exception {
	
		 memmapper.memModify(memvo);
	}
	
	//ȸ��Ż��
	@Override
	public void memDelet(MemberVO memvo) throws Exception {
		memmapper.memDelet(memvo);
		
	}



}
