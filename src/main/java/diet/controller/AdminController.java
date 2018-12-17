package diet.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import diet.vo.Mvo;

@Controller
@RequestMapping(value="/admin")
public class AdminController {	
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login( Mvo m, HttpServletRequest request,  HttpServletResponse response) {		
		//세션
		request.getSession().setAttribute("loginUser", m);
		Mvo loginUser = (Mvo) request.getSession().getAttribute("loginUser");		
		String email  = loginUser.getEmail().toString();	
		System.out.println("email "+email);
	
		return "view/test";
		}
	
	
}
