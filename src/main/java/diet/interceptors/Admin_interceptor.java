package diet.interceptors;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Admin_interceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object o) throws Exception {
	//pre핸들 시작
		System.out.println("관리자 프리핸들");
		//로그인 확인
		if(Objects.isNull(req.getSession().getAttribute("loginAdmin"))) {
			System.out.println("관리자로그인 안되어있음.");			
			res.sendRedirect("/cally/admin/loginform");	            
			return false;
		} else {
			//로그인 되어있음
			return true;
		}
	}

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse res, Object o, ModelAndView modelAndView)
			throws Exception {
		System.out.println("관리자 포스트핸들");
		if (modelAndView.getModelMap().containsKey("status")) {
			String status = (String) modelAndView.getModelMap().get("status");
			if (status.equals("SUCCESS!")) {
				status = "Authentication " + status;
				modelAndView.addObject("status", status);
			}
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object o, Exception e)
			throws Exception {
		System.out.println("관리자애프터");
	}
}
