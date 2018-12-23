package diet.interceptors;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Main_interceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object o) throws Exception {
		// 로그인 확인
		if (Objects.isNull(req.getSession().getAttribute("loginEmail"))) {
			System.out.println("login No");
			res.sendRedirect("/diet");
			return false;
		} else {
			System.out.println("로그인 되어있음 : "+req.getSession().getAttribute("loginEmail"));
			// 로그인 되어있음
			return true;
		}
	}

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse res, Object o, ModelAndView modelAndView)
			throws Exception {
		System.out.println("postHandle!!!!");
	}

	@Override
	public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object o, Exception e)
			throws Exception {
		System.out.println("afterCompletion!!!!");
	}
}
