package com.Hwarang.backup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginDAO loginDAO;

	@Override
	public MemberVO getMember(String username) {
		// TODO Auto-generated method stub
		return loginDAO.getMember(username);
	}
	
}
