package com.Hwarang.backup;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<MemberVO, Integer> {
	public MemberVO findByUsername(String username);
	
	
}
