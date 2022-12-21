package com.Hwarang.backup;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAOImpl implements LoginDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public MemberVO getMember(String username) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mem_get",username);
	}
	
}
