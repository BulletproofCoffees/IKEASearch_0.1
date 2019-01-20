package diet.controller;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import diet.service.IkeaService;


@Controller
@RequestMapping(value = "/main")
public class MainController {	
	  @Inject private IkeaService ikea_service;
	@RequestMapping(value = "")
	public String main(ServletRequest request) throws IOException {
		ikea_service.ikeaapi(request);
		
		return "view/main";
	}
	

	
}
