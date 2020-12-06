package com.album.kpop;

import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.album.email.Email;
import com.album.email.EmailService;
import com.album.service.MemberService;
import com.album.vo.MemberVO;

@Controller
@RequestMapping(value="/member")
public class MemberController {
	

	@Autowired
	private MemberService memservice; 
	@Autowired
	private EmailService emailservice;
	@Autowired
	private Email email;
	

	private Logger logger = LoggerFactory.getLogger(MemberController.class);

	// 회원가입 이동
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public void getsignup() throws Exception {
		logger.info("회원가입 이동");
	}

	// 회원가입 작성
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String postsignup(MemberVO vo) throws Exception {
		logger.info("회원가입 작성");
		memservice.signup(vo);
		
		return "redirect:/member/signupcomple";
	}
	
	// 회원가입 완료시 이동
	@RequestMapping(value="/signupcomple" , method = RequestMethod.GET)
	public void signupfine () throws Exception{
		logger.info("회원가입 완료 이동");
	}
	
	// 아이디 중복 검사
		@ResponseBody
		@RequestMapping(value = "/IdChek", method = RequestMethod.POST)
		public String memberIdChkPOST(String userid) throws Exception{
			
			//ajax 전송 
			int result = memservice.idcheck(userid);
			
			logger.info("결과값 = " + result);
			
			if(result != 0) {
				
				return "fail";	// 중복 아이디가 존재
			
			} else {
				
				return "success";	// 중복 아이디 x
			}	
		} 

		
	// 로그인 화면이동
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public void getsignin() throws Exception {
		logger.info("로그인 이동");
	 }
	
		
	
	// 로그인 처리
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String postsignin(MemberVO vo, HttpServletRequest request, RedirectAttributes attr) throws Exception {
		HttpSession session = request.getSession();
		MemberVO memvo = memservice.signin(vo);

			if (memvo != null) {
				session.setAttribute("member", memvo);
				return "redirect:/";
			} else {
				attr.addFlashAttribute("msg", false);
				return "redirect:/member/signin";
			}

		}
	
	
	//로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpSession session) throws Exception {
		ModelAndView md = new ModelAndView("redirect:/");
		session.invalidate();

		return md;
	}

	
	// 아이디찾기 페이지 이동 
	@RequestMapping(value="/findid", method=RequestMethod.GET) 
	public void getfindid () throws Exception{
		logger.info("아이디찾기 페이지");
	}
	
	
	// 아이디 찾기 
	@ResponseBody
	@RequestMapping(value="/findid", method=RequestMethod.POST) 
	public String postfindid (MemberVO memvo) throws Exception{
			
		String result = memservice.findid(memvo);
		System.out.println("아이디" + result);
		if(result == null) {
			return null;
		}else {
			
			return result;
		}
	}
	
	//비밀번호 찾기용 select
	@RequestMapping(value="/finduser")
	public void finduUser (MemberVO memvo) throws Exception{
		
	}
	
	// 비밀번호 찾기 
	@RequestMapping(value="/findpw", method=RequestMethod.GET)
	public void getSendMail() {
		logger.info("비밀번호 찾기 페이지");
		
	}
	
	
	//임시 비밀번호 생성
	@RequestMapping(value="/findpw" , method=RequestMethod.POST)
	public void newPassword(MemberVO memvo, HttpSession session , HttpServletRequest request , HttpServletResponse response )throws Exception{
		
		
		String userid = request.getParameter("userid");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html; charset=utf-8");
		if(memservice.idcheck(userid) == 0) {
			out.print("<script>alert('아이디를 다시 확인해 주세요');</script>");
			out.flush();
			out.print("<script>window.location.href=window.location.href</script>");
			System.out.println("아이디가 없습니다");
		}else if(!memvo.getUserEmail().equals(memservice.finduser(memvo))){
			out.print("<script>alert('이메일이 일치 않습니다 다시 확인해 주세요');</script>");
			out.flush();
			out.print("<script>window.location.href=window.location.href</script>");
			System.out.println("일치하지 않습니다");
		}else {

			Random random = new Random();
			int num = random.nextInt(8999)+10000;
			String str = String.valueOf((char) ((int) (random.nextInt(26)) + 65));
			String newpass = str + "TdsGvi" +Integer.toString(num) + str; 
			memvo.setUserPass(newpass);
			session.setAttribute("memvo", memvo);
			memservice.findpw(memvo);
			
			System.out.println(newpass);
			
			memvo = (MemberVO)session.getAttribute("memvo");
			email.setSenderMail(memvo.getUserEmail());
			email.setMessage("임시 비밀번호" + memvo.getUserPass());
			email.setSubject(memvo.getUserEmail() + "님 임시 비밀번호를 확인해 주세요");

			emailservice.SendEmail(email);
			

			out.print("<script>window.location.href='/kpop/member/findpwcomple'</script>");
			out.flush();
		}
	}
	
	//이메일발송 성공 페이지
	@RequestMapping(value="/findpwcomple" , method=RequestMethod.GET)
	public String findpwFine () throws Exception{
		logger.info("메일발송 성공");
		
		return "member/findpwcomple";
	}
	
	// 마이페이지
	@RequestMapping(value="/mypage" , method=RequestMethod.GET)
	public void mypage() throws Exception{
		logger.info("마이페이지");
	}
	

	// 회원정보 수정 페이지 
	@RequestMapping(value="/modify" , method=RequestMethod.GET)
	public String getModify() throws Exception{
		logger.info("회원정보 수정 페이지 이동");
		return "/member/modify";
	}
	
	// 회원정보 수정
	@RequestMapping(value="/modify" , method=RequestMethod.POST)
	public String postModify (MemberVO memvo, HttpSession session) throws Exception{
		
	 	memservice.memModify(memvo);
	    session.invalidate();
	    logger.info("수정처리완료");
	    return "redirect:/member/modifycomple";
	   
	}
	
	//회원정보 수정 완료 안내 
	@RequestMapping (value="/modifycomple" , method=RequestMethod.GET)
	public void modifyFine () throws Exception{
		logger.info("수정처리 완료 안내");
	}
	
	//회원탈퇴 페이지
	@RequestMapping (value="/delet", method=RequestMethod.GET)
	public String getDelet()throws Exception{
		logger.info("회원탈퇴 페이지 이동");
		return "member/delet";
	}
	
	//회원탈퇴
		@RequestMapping (value="/delet", method=RequestMethod.POST)
		public String postDelet(MemberVO memvo , HttpSession session , 
				HttpServletRequest request , RedirectAttributes rttr)throws Exception{
			MemberVO vo = (MemberVO)session.getAttribute("member");
			String sessinopass = vo.getUserPass();
			String vopass = memvo.getUserPass();
				
			if(!sessinopass.equals(vopass)){
				
			rttr.addFlashAttribute("msg",false);
			return "member/delet";
		}else {
			memservice.memDelet(memvo);
			session.invalidate();
			return "redirect:/member/deletcomple";
		}
	}
		
	//회원탈퇴  완료 안내 
	@RequestMapping (value="/deletcomple" , method=RequestMethod.GET)
	public void deletFine () throws Exception{
		logger.info("회원탈퇴 완료 안내");
	}
		
		
}
