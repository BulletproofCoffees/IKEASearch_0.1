package diet.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.social.google.api.plus.Person;
import org.springframework.stereotype.Repository;
@Repository
public class MemberService {

	
	protected static void logindata(Person profile, HttpServletRequest request) {
		
		System.out.println("User Uid : " + profile.getId());
        System.out.println("User Name : " + profile.getDisplayName());
        System.out.println("User Email : " + profile.getAccountEmail());
        System.out.println("User Profile : " + profile.getImageUrl());
        //로그인 세션
        request.getSession().setAttribute("loginid", profile.getId());
        request.getSession().setAttribute("loginName", profile.getDisplayName());
        request.getSession().setAttribute("loginEmail", profile.getAccountEmail());
        
        // db 연결
        
		}
	
	//로그아웃
		public void loguot(HttpServletRequest request) {	
			//세션삭제
			HttpSession session = request.getSession();
			session.invalidate();        
		}
}
