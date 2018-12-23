package diet.service;

import java.util.HashMap;
import java.util.Objects;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.social.google.api.plus.Person;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import diet.dao.MemberDAO;

@Repository
public class MemberService {
	@Inject private GoogleService googleservice;
	@Inject private MemberDAO memberDao;	
	HashMap<Object, String> map = new HashMap<>();
	
	// 세션삭제
	private void session(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("loginName");
	}
	
	// 로그인
	public String login(String code, String pw, String email, Model m, HttpServletRequest request) {		
		session(request);// 세션삭제
		String loginName = null;

		if (Objects.isNull(code)) {			
			map.put("email", email);
			map.put("pw", pw);
			loginName = memberDao.login(map);
		} else {
			// 구글 가입및 로그인
			Person profile = googleservice.googlelogin(code);
			loginName = profile.getDisplayName();
		}

		if (Objects.isNull(loginName)) {
			// 정보 null
			String message = "아이디 혹은 패스워드가 틀립니다. 다시 시도해보세요.";
			m.addAttribute("idxmessage", message);
			return "index";			
		} else {
			// 세션
			request.getSession().setAttribute("loginName", loginName);
		}
		return "view/main";

	}
	// 로그아웃
	public void loguot(HttpServletRequest request) {
	     session(request);// 세션삭제
	}

//회원 가입
	public void join(String name, String email, String pw, HttpServletRequest request) {
		map.put("name", name);
		map.put("email", email);
		map.put("pw", pw);	
		memberDao.join(map);
		//프로시져를 만들자!!
	}

}
