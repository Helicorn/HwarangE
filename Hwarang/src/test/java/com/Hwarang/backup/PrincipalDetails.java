package com.Hwarang.backup;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
public class PrincipalDetails implements UserDetails {
	
	private MemberVO Member;
	
	public PrincipalDetails(MemberVO Member) {
		this.Member = Member;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		Collection<GrantedAuthority> collect = new ArrayList<GrantedAuthority>();
		collect.add(()->{ return Member.getRole();});
		return collect;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return Member.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return Member.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
