package com.album.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.album.vo.MemberVO;

public class MypageInterceptor extends HandlerInterceptorAdapter {

	 @Override 
	 
	 //mypage 인터셉터 
	 public boolean preHandle (HttpServletRequest request , HttpServletResponse response , Object obj) throws Exception{
		 
		 HttpSession session = request.getSession();
		 MemberVO memvo = (MemberVO)session.getAttribute("member");
		 
		 //로그인이 되어있지 않으면 로그인 페이지로 이동
		 if(memvo == null) {
			 response.sendRedirect("/kpop/member/signin");
			 return false;
		 }
		 
		 return true;
	 }
	 
}
