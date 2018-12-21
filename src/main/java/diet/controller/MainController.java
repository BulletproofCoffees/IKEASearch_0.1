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
public class MainController {	
	  @Inject private GoogleService googleservice; 
	  @Inject private MemberService memberservice;
	  
	@RequestMapping(value="/", method = { RequestMethod.GET, RequestMethod.POST })
	public String gjoin( Model model, HttpServletRequest request ) {        
		googleservice.joniurl(model,request); //구글 로그인 url
		return "index";				
	}
	
	@RequestMapping(value = "/login", method ={RequestMethod.GET})
	public String login(String code,HttpServletRequest request) {
		googleservice.googlelogin(code,request);    
		return "view/main";
	}
	@RequestMapping(value = "/logout", method ={RequestMethod.GET})
	public String loguot(HttpServletRequest request) {
		memberservice.loguot(request);
		return "index";
	}	
	
}
