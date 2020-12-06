package com.album.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.album.mapper.MemberMapper;
import com.album.vo.MemberVO;

@Service
public class MemberImplement implements MemberService{

	
	@Autowired
	private MemberMapper memmapper;
	
	// 회원가입
	@Override
	public void signup(MemberVO memvo) throws Exception {
		memmapper.signup(memvo);
		
	}
	
	// 아이디 중복확인
	@Override
	public int idcheck(String userid) throws Exception {
		return memmapper.idcheck(userid);
	}
	
	//로그인
	@Override
	public MemberVO signin(MemberVO memvo) throws Exception {
		
		return memmapper.signin(memvo);
	}
	//아이디 찾기
	@Override
	public String findid(MemberVO memvo) throws Exception {
		
		return memmapper.findid(memvo);
	}
	
	//비밀번호 찾기
	@Override
	public void findpw(MemberVO memvo) throws Exception {
	
		memmapper.findpw(memvo);
	}

	// 비밀번호 찾기용 select 
	@Override
	public String finduser(MemberVO memvo) throws Exception {
		
		return memmapper.finduser(memvo);
	}

	// 회원정보 수정
	@Override
	public void memModify(MemberVO memvo) throws Exception {
	
		 memmapper.memModify(memvo);
	}
	
	//회원탈퇴
	@Override
	public void memDelet(MemberVO memvo) throws Exception {
		memmapper.memDelet(memvo);
		
	}



}
