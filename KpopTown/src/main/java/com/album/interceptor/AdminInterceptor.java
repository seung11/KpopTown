package com.album.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.album.vo.MemberVO;

public class AdminInterceptor extends HandlerInterceptorAdapter {
	
	//������ ������ ���ͼ��� 
	@Override
	public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception{
		
		HttpSession session = request.getSession();
		MemberVO memvo = (MemberVO)session.getAttribute("member");
			
			// ������ ��� : 9  
			// 9����� �ƴϰų� �α����� �Ǿ� ���� ������ �α��� �������� �����̷�Ʈ
		if (memvo == null || memvo.getGrade() != 9) {
			response.sendRedirect("/kpop/member/signin");
			return false;
		}
		
		return true;  
	}
	

}
