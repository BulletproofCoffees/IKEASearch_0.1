package diet.dao;

import java.util.HashMap;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Inject private SqlSession session;
	String mapper = "org.mapper.memberMapper.";	
	
	public void join(HashMap<Object, String> map) {
		 session.selectList(mapper + "join",map);
	}

	public  String login(HashMap<Object, String> map) {	
		return session.selectOne(mapper +"login", map);
		
	}

}
