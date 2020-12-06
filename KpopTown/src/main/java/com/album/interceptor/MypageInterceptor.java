package com.album.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.album.vo.MemberVO;

public class MypageInterceptor extends HandlerInterceptorAdapter {

	 @Override 
	 
	 //mypage ���ͼ��� 
	 public boolean preHandle (HttpServletRequest request , HttpServletResponse response , Object obj) throws Exception{
		 
		 HttpSession session = request.getSession();
		 MemberVO memvo = (MemberVO)session.getAttribute("member");
		 
		 //�α����� �Ǿ����� ������ �α��� �������� �̵�
		 if(memvo == null) {
			 response.sendRedirect("/kpop/member/signin");
			 return false;
		 }
		 
		 return true;
	 }
	 
}
