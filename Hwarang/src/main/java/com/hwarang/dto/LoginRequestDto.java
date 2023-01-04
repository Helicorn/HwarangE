package com.hwarang.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDto {
	private String username;
	private String password;
	public void setMsg(String string) {
		// TODO Auto-generated method stub
		
	}
}