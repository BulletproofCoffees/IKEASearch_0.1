package diet.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import diet.service.GoogleService;
import diet.service.MemberService;

@Controller
public class MemberController {
	  @Inject private GoogleService googleservice; 
	  @Inject private MemberService memberservice;
	 
	  //홈
	@RequestMapping(value="/", method = { RequestMethod.GET, RequestMethod.POST })
	public String gjoin( Model model, HttpServletRequest request ) {   
		//구글 url
		googleservice.googlelogin(request); 
		return "index";				
	}
	
	//로그인
	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(String code, Model m,HttpServletRequest request,String pw,String email) {
		System.out.println("/login");			
		return memberservice.login(code,pw,email,m,request);
	}
	
	//회원 가입
	@RequestMapping(value = "/join", method = {RequestMethod.POST})
	public String join(String name,String email, String pw,HttpServletRequest request,Model m) {
		System.out.println("/join");		
		return memberservice.join(name,email,pw,request,m);
	}
	
	
	//로그아웃
	@RequestMapping(value = "/logout", method = { RequestMethod.GET, RequestMethod.POST } )
	public String loguot(HttpServletRequest request) {		
		memberservice.loguot(request); //세션삭제
		return "index";
	}

	
	//구글 회원 탈퇴
	@RequestMapping(value = "/googlesecession", method = { RequestMethod.GET, RequestMethod.POST })
	public String googlesecession(String code) {
		System.out.println("/googlesecession");
		googleservice.googlesecession(code); //탈퇴
		return "index";
	}
	
	
	
	
}
