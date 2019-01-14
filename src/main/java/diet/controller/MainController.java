package diet.controller;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import diet.service.IkeaService;


@Controller
@RequestMapping(value = "/main")
public class MainController {	
	  @Inject private IkeaService ikea_service;
	@RequestMapping(value = "")
	public String main(ServletRequest request) throws IOException {
		request.setAttribute("ikea", ikea_service.ikeaapi(request));	   
		return "view/main";
	}
	

	
}
