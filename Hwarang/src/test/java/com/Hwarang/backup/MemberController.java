package com.Hwarang.backup;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping("/join")
	public String join() {
		
		return "member/join";
	}
	
	@RequestMapping("/join_ok")
	public String join_ok(HttpServletRequest request, MemberVO mem) throws UnsupportedEncodingException {
		String rawPassword = mem.getPassword();
		String newPassword = bcryptPasswordEncoder.encode(rawPassword);
		mem.setPassword(newPassword);
		userRepository.save(mem);
		return "/index";
	}
	
	@RequestMapping("/login")
	public String login(HttpSession session, HttpServletRequest request) {
		
		String username = (String)session.getAttribute("username");
		request.setAttribute("username", username);
		
		return "member/login";
	}
	
	@RequestMapping("/login_ok")
	public String login_ok(HttpServletRequest request, Authentication auth, HttpServletResponse response,
			@AuthenticationPrincipal PrincipalDetails userDetails) throws IOException {
		//String login_id = request.getParameter("login_id");
		//String login_password = request.getParameter("login_password");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		PrincipalDetails principal = (PrincipalDetails)auth.getPrincipal();
		
		MemberVO bm = loginService.getMember(principal.getUsername());
		
		request.getSession().setAttribute("username", bm.getUsername());
		request.getSession().setAttribute("role", bm.getRole());
		request.getSession().setAttribute("state", bm.getState());
		
		if(principal.getUsername() != null) {
			out.println("<script>");
			out.println("alert('로그인을 환영합니다.');");
			out.println("location='/index';");
			out.println("</script>");
		}
		
		return null;
	}
	
	@RequestMapping("/login_failed")
	public String login_failed(Model model) {
		model.addAttribute("loginErrorMsg","아이디나 비밀번호를 확인하세요.");
		return "member/login_failed";
	}
}
