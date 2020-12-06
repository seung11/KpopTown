package com.album.mapper;

import com.album.vo.MemberVO;

public interface MemberMapper {

	//회원가입 
	public void signup (MemberVO memvo)throws Exception;
	//아이디 중복확인
	public int idcheck(String userid) throws Exception;
	//로그인
	public MemberVO signin (MemberVO memvo) throws Exception;
	//아이디 찾기 
	public String findid (MemberVO memvo) throws Exception;
	//비밀번호 찾기 
	public void findpw (MemberVO memvo)throws Exception;
	//비밀번호 찾기용 select 
	public String finduser (MemberVO memvo)throws Exception;
	//회원정보 수정
	public void memModify (MemberVO memvo)throws Exception;
	//회원탈퇴
	public void memDelet (MemberVO memvo)throws Exception;
	
}
