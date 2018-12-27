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
	
	// 로그아웃,세션삭제
	public void loguot(HttpServletRequest request) {
		System.out.println("loguot");
		HttpSession session = request.getSession();
		session.removeAttribute("loginName");
	}	
	//세션 생성
	public void session(HttpServletRequest request,String dite) {
		request.getSession().setAttribute("loginName", dite);
	}

	
	
	
	// 로그인
	public String login(String code, String pw, String email, Model m, HttpServletRequest request) {		
		// 세션삭제
		loguot(request);
		String loginName = null;

		if (Objects.isNull(code)) {			
			map.put("email", email);
			map.put("pw", pw);
			loginName = memberDao.login(map);
		} else {
			// 구글 가입및 로그인
			Person profile = googleservice.googlelogin(code);
			loginName = profile.getDisplayName();				
			map.put("email", profile.getAccountEmail());	
			map.put("name",  loginName);		
			memberDao.Glogin(map);
		}

		if (Objects.isNull(loginName)) {
			// 정보 null
			String message = "아이디 혹은 패스워드가 틀립니다. 다시 시도해보세요.";
			m.addAttribute("idxmessage", message);
			return "index";			
		} else {
			// 세션
			session(request,loginName);
			return "view/main";
		}		
	}
	

//회원 가입
	public String join(String name, String email, String pw,HttpServletRequest request, Model m) {
		map.put("email", email);	
		String joinsearch = memberDao.emailsearch(map);
		
		if(Objects.isNull(joinsearch)) {
			map.put("name", name);		
			map.put("pw", pw);
			memberDao.join(map);//가입				
			session(request,email);		
			return "view/main";			
		}else {
			String message = "이미 가입되어 이메일 입니다. 다른 이메일 가입에주세요";
			m.addAttribute("idxmessage", message);			
			return "index";		
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
