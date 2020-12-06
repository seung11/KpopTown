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

	// ȸ������ �̵�
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public void getsignup() throws Exception {
		logger.info("ȸ������ �̵�");
	}

	// ȸ������ �ۼ�
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String postsignup(MemberVO vo) throws Exception {
		logger.info("ȸ������ �ۼ�");
		memservice.signup(vo);
		
		return "redirect:/member/signupcomple";
	}
	
	// ȸ������ �Ϸ�� �̵�
	@RequestMapping(value="/signupcomple" , method = RequestMethod.GET)
	public void signupfine () throws Exception{
		logger.info("ȸ������ �Ϸ� �̵�");
	}
	
	// ���̵� �ߺ� �˻�
		@ResponseBody
		@RequestMapping(value = "/IdChek", method = RequestMethod.POST)
		public String memberIdChkPOST(String userid) throws Exception{
			
			//ajax ���� 
			int result = memservice.idcheck(userid);
			
			logger.info("����� = " + result);
			
			if(result != 0) {
				
				return "fail";	// �ߺ� ���̵� ����
			
			} else {
				
				return "success";	// �ߺ� ���̵� x
			}	
		} 

		
	// �α��� ȭ���̵�
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public void getsignin() throws Exception {
		logger.info("�α��� �̵�");
	 }
	
		
	
	// �α��� ó��
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
	
	
	//�α׾ƿ�
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpSession session) throws Exception {
		ModelAndView md = new ModelAndView("redirect:/");
		session.invalidate();

		return md;
	}

	
	// ���̵�ã�� ������ �̵� 
	@RequestMapping(value="/findid", method=RequestMethod.GET) 
	public void getfindid () throws Exception{
		logger.info("���̵�ã�� ������");
	}
	
	
	// ���̵� ã�� 
	@ResponseBody
	@RequestMapping(value="/findid", method=RequestMethod.POST) 
	public String postfindid (MemberVO memvo) throws Exception{
			
		String result = memservice.findid(memvo);
		System.out.println("���̵�" + result);
		if(result == null) {
			return null;
		}else {
			
			return result;
		}
	}
	
	//��й�ȣ ã��� select
	@RequestMapping(value="/finduser")
	public void finduUser (MemberVO memvo) throws Exception{
		
	}
	
	// ��й�ȣ ã�� 
	@RequestMapping(value="/findpw", method=RequestMethod.GET)
	public void getSendMail() {
		logger.info("��й�ȣ ã�� ������");
		
	}
	
	
	//�ӽ� ��й�ȣ ����
	@RequestMapping(value="/findpw" , method=RequestMethod.POST)
	public void newPassword(MemberVO memvo, HttpSession session , HttpServletRequest request , HttpServletResponse response )throws Exception{
		
		
		String userid = request.getParameter("userid");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html; charset=utf-8");
		if(memservice.idcheck(userid) == 0) {
			out.print("<script>alert('���̵� �ٽ� Ȯ���� �ּ���');</script>");
			out.flush();
			out.print("<script>window.location.href=window.location.href</script>");
			System.out.println("���̵� �����ϴ�");
		}else if(!memvo.getUserEmail().equals(memservice.finduser(memvo))){
			out.print("<script>alert('�̸����� ��ġ �ʽ��ϴ� �ٽ� Ȯ���� �ּ���');</script>");
			out.flush();
			out.print("<script>window.location.href=window.location.href</script>");
			System.out.println("��ġ���� �ʽ��ϴ�");
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
			email.setMessage("�ӽ� ��й�ȣ" + memvo.getUserPass());
			email.setSubject(memvo.getUserEmail() + "�� �ӽ� ��й�ȣ�� Ȯ���� �ּ���");

			emailservice.SendEmail(email);
			

			out.print("<script>window.location.href='/kpop/member/findpwcomple'</script>");
			out.flush();
		}
	}
	
	//�̸��Ϲ߼� ���� ������
	@RequestMapping(value="/findpwcomple" , method=RequestMethod.GET)
	public String findpwFine () throws Exception{
		logger.info("���Ϲ߼� ����");
		
		return "member/findpwcomple";
	}
	
	// ����������
	@RequestMapping(value="/mypage" , method=RequestMethod.GET)
	public void mypage() throws Exception{
		logger.info("����������");
	}
	

	// ȸ������ ���� ������ 
	@RequestMapping(value="/modify" , method=RequestMethod.GET)
	public String getModify() throws Exception{
		logger.info("ȸ������ ���� ������ �̵�");
		return "/member/modify";
	}
	
	// ȸ������ ����
	@RequestMapping(value="/modify" , method=RequestMethod.POST)
	public String postModify (MemberVO memvo, HttpSession session) throws Exception{
		
	 	memservice.memModify(memvo);
	    session.invalidate();
	    logger.info("����ó���Ϸ�");
	    return "redirect:/member/modifycomple";
	   
	}
	
	//ȸ������ ���� �Ϸ� �ȳ� 
	@RequestMapping (value="/modifycomple" , method=RequestMethod.GET)
	public void modifyFine () throws Exception{
		logger.info("����ó�� �Ϸ� �ȳ�");
	}
	
	//ȸ��Ż�� ������
	@RequestMapping (value="/delet", method=RequestMethod.GET)
	public String getDelet()throws Exception{
		logger.info("ȸ��Ż�� ������ �̵�");
		return "member/delet";
	}
	
	//ȸ��Ż��
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
		
	//ȸ��Ż��  �Ϸ� �ȳ� 
	@RequestMapping (value="/deletcomple" , method=RequestMethod.GET)
	public void deletFine () throws Exception{
		logger.info("ȸ��Ż�� �Ϸ� �ȳ�");
	}
		
		
}
