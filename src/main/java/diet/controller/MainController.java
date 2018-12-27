package diet.controller;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import diet.service.Apitest;

@Controller
@RequestMapping(value = "/main")
public class MainController {	
	  @Inject private Apitest apitest;
	@RequestMapping(value = "")
	public String main(String code,HttpServletRequest request) throws ServletException, IOException, SignatureException, InvalidKeyException, NoSuchAlgorithmException {
		apitest.getapi();
		return "view/main";
	}
	

	
}
