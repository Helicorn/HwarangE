package com.hwarang.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hwarang.repository.UserRepository;
import com.hwarang.vo.Users;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor 
// @CrossOrigin // CORS 허용
public class HomeController {
	private final UserRepository userRepository;


	// 모든 사람이 접근 가능
	@GetMapping("home")
	public String home() {
		return "<h1>home</h1>";
	}
	
	@RequestMapping("")
	public ModelAndView index() {
		   return new ModelAndView("/index");
	}

//	// 유저 혹은 매니저 혹은 어드민 접근
//	@GetMapping("user")
//	public String user(Authentication authentication) {
//		PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
//		System.out.println("principal : " + principal.getUser().getId());
//		System.out.println("principal : " + principal.getUser().getUsername());
//		System.out.println("principal : " + principal.getUser().getPassword());
//		
//		return "<h1>user</h1>";
//	}

	// 매니저 혹은 어드민이 접근 가능
	@GetMapping("manager/reports")
	public String reports() {
		return "<h1>reports</h1>";
	}

	// 어드민이 접근 가능
	@GetMapping("admin/users")
	public List<Users> users() {
		return userRepository.findAll();
	}
	
	
}
