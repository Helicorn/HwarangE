package com.Hwarang.backup;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor 
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class SecurityConfig {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
			.antMatchers("/").permitAll()
			.and()
		.formLogin()
			.loginPage("/login")
			.loginProcessingUrl("/login_ok")
			.defaultSuccessUrl("/index")
			.failureUrl("/login_failed")
			.permitAll()
			.and()
		.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/index");
		
		return http.build();
	}
	
	@Bean
	public BCryptPasswordEncoder encodePwd() {
		return new BCryptPasswordEncoder();
	}
}
