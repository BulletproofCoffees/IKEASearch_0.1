package diet.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/main")
public class MainController {	
	
	@RequestMapping(value = "")
	public String main(String code,HttpServletRequest request) {
		return "view/main";
	}
	

	
}
