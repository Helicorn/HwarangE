package com.hwarang.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hwarang.service.ChatService;
import com.hwarang.vo.ChatMessage;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ChatController {
	@Autowired
	ChatService chatService;
	
	@RequestMapping("/")
	public String index() {
		return "/index";
	}
	
	@RequestMapping("/chatlist")
	public String chatlist() {
		return "/test/chatlist";
	}
	
	@RequestMapping("/chat")
	public String showRoom(int roomId, String nickname, Model model, HttpServletRequest request) {
		roomId = Integer.parseInt(request.getParameter("roomId"));
		model.addAttribute("roomId",roomId);
		model.addAttribute("nickname",nickname);
		return "/test/chat";
	}
	
	@RequestMapping("/test/doAddMessage")
	@ResponseBody
	public Map doAddMessage(int roomId, String writer, String body) {
		Map rs = new HashMap<>();
		
		chatService.addMessage(roomId, writer, body);
		
		rs.put("resultCode", "S-1");
		rs.put("msg", "채팅메시지가 추가됨.");
		
		return rs;
	}
	@RequestMapping("/test/doClearAllMessages")
	@ResponseBody
	public Map doClearAllMessages() {
		chatService.clearAllMessages();
		
		Map rs = new HashMap<>();
		
		rs.put("resultCode", "S-1");
		rs.put("msg", "모든 메시지 삭제.");
		
		return rs;
	}

	
	@RequestMapping("/test/getMessagesFrom")
	@ResponseBody
	public Map getMessages(int roomId, int from) {
		List<ChatMessage> messages = chatService.getMessagesFrom(roomId, from);
		
		Map rs = new HashMap<>();
		
		rs.put("resultCode", "S-1");
		rs.put("msg", "새 메시지 가져옴.");
		rs.put("messages", messages);
	
		return rs;
	}
}
