package com.Hwarang.backup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PrincipalDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		MemberVO userEntity = userRepository.findByUsername(username);
		if(userEntity == null) {
			 throw new UsernameNotFoundException(username);
		}else {
			return new PrincipalDetails(userEntity);
		}
	}
}
