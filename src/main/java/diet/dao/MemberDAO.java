package diet.dao;

import java.util.HashMap;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Inject private SqlSession session;
	String mapper = "org.mapper.memberMapper.";	
	
	
    //회원 email 검색
	public String emailsearch(HashMap<Object, String> map) {		
		return session.selectOne(mapper + "joinsearch",map);
	}
	
	//가입
	public void join(HashMap<Object, String> map) {
		 session.selectList(mapper + "join",map);
	}
    //로그인
	public  String login(HashMap<Object, String> map) {	
		return session.selectOne(mapper +"login", map);
		
	}

	//구글 가입
	public void Glogin(HashMap<Object, String> map) {
		/*session.insert(mapper + "g_login",map);*/
		
	}

}
