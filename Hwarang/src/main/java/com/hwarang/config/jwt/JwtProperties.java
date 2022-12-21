package com.hwarang.config.jwt;

public interface JwtProperties {
	
	String SECRET = "화랑"; // 우리 서버 비밀값
	int EXPIRATION_TIME = 864000000; // 10일 (1/1000초)
	String TOKEN_PREFIX = "Bearer ";
	String HEADER_STRING = "Authorization";

}
