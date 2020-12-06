package com.album.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.album.vo.MemberVO;

public class AdminInterceptor extends HandlerInterceptorAdapter {
	
	//관리자 페이지 인터셉터 
	@Override
	public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception{
		
		HttpSession session = request.getSession();
		MemberVO memvo = (MemberVO)session.getAttribute("member");
			
			// 관리자 등급 : 9  
			// 9등급이 아니거나 로그인이 되어 있지 않으면 로그인 페이지로 리다이렉트
		if (memvo == null || memvo.getGrade() != 9) {
			response.sendRedirect("/kpop/member/signin");
			return false;
		}
		
		return true;  
	}
	

}
