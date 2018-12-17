package diet.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {	
	@RequestMapping("/googletest")
	public String admin() {
		return "view/googletest";
		}
	@RequestMapping("/googlelogin")
	public String googlelogin() {
		
		return "view/googlelogin";
		}
	@RequestMapping("/test")
	public String test(HttpServletRequest request) {
		Cookie[] getCookie = request.getCookies();
		if(getCookie != null){
		for(int i=0; i<getCookie.length; i++){
		Cookie c = getCookie[i];
		String name = c.getName(); // 쿠키 이름 가져오기
		String value = c.getValue(); // 쿠키 값 가져오기
		System.out.println("쿠키 :"+name+" = "+value);
		}
		}
		return "view/test";
		}
	
	@RequestMapping(value="/login" , method=RequestMethod.POST)
	public String login(String email, HttpServletRequest request,  HttpServletResponse response) {
		
		//쿠키생성		
		Cookie setCookie = new Cookie("email",email);
		setCookie.setMaxAge(60*60*24); // 기간 하루
		response.addCookie(setCookie);
	
		return "view/test";
		}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		
		//쿠키삭제
		Cookie kc = new Cookie("email", null) ;
	    kc.setMaxAge(0) ;
	    response.addCookie(kc) ;

	


	
		return "index";
		}
	
}
