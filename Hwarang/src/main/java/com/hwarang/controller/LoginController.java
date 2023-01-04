package com.hwarang.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hwarang.config.auth.PrincipalDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import com.hwarang.dto.LoginRequestDto;
import com.hwarang.repository.UserRepository;
import com.hwarang.vo.Users;

import lombok.RequiredArgsConstructor;

@Controller	
@RequestMapping("/")
@RequiredArgsConstructor 
// @CrossOrigin // CORS 허용
public class LoginController {
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;


	@GetMapping("loginpage")
	public ModelAndView login(LoginRequestDto LRD, HttpServletResponse response, HttpServletRequest request) {	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		LRD.setUsername(username);
		LRD.setPassword(password);

        return new ModelAndView("/member/login");
	
	}
	@RequestMapping("/login")
	public String login_ok(@RequestParam String username, @RequestParam String password, HttpServletResponse response, HttpServletRequest request, Authentication authentication,
			@AuthenticationPrincipal PrincipalDetails userDetails) {	
		PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
		System.out.println("authentication:"+principalDetails.getUsername()); 
		System.out.println("userDetails:"+userDetails.getUsername());
		
		Cookie[] cookie = request.getCookies();
		System.out.println("cookie"+cookie);
		System.out.println("username"+username);
		System.out.println("password"+password);
		//response.addCookie(cookie);
		String username1 = request.getParameter("username");
		String password1 = request.getParameter("password");
		LoginRequestDto LRD = new LoginRequestDto();
		LRD.setUsername(username1);
		LRD.setPassword(password1);
		
		  return "/index";
		
	}
	
	@RequestMapping("/loginok")
	public String loginok(HttpServletResponse response, HttpServletRequest request) {	

		return "/index";
	} 
	
	
	
	
//	 @GetMapping("/login")
//	  public String login(@RequestParam(value = "fail", required = false) String flag, Model model) {
//	    model.addAttribute("failed", flag != null);
//
//	    return "user/signIn";
//	  }
//
//	  @PostMapping("/login")
//	  public String login(@Validated LoginRequestDto loginRequestDto, HttpServletResponse response, HttpServletRequest request) {
//	    //ResponseEntity<TokenDto> tokenDtoResponseEntity = authService.signIn(loginRequestDto);
//	    Cookie cookie = new Cookie(
//	        "access_token",
//	        tokenDtoResponseEntity.getBody().getAccess_token()
//	    );
//
//	    cookie.setPath("/");
//	    cookie.setMaxAge(Integer.MAX_VALUE);
//
//	    response.addCookie(cookie);
//	    return "redirect:/member/loginOk";
//	  }
//	
	
	

	  @GetMapping("/user/hello")
	    @ResponseBody
	    public LoginRequestDto hello(HttpServletRequest request) {
		  LoginRequestDto loginDto = new LoginRequestDto();
		//  loginDto.setCode(loginDto.SUCCESS.getCode());
		  loginDto.setMsg("Hello, " + request.getSession().getAttribute("username").toString());
	        return loginDto;
	    }
	
	
	
	
	@GetMapping("join")
	public ModelAndView join() {	
		

        return new ModelAndView("/member/join2");
	
	}
	

	@PostMapping("joinok")
	public String join(Users user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles("ROLE_USER");
		userRepository.save(user);
		return "/member/login";
	}

}
