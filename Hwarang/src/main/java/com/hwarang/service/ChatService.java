package com.hwarang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hwarang.dao.ChatDAO;

@Service
public class ChatService {
	@Autowired
	ChatDAO chatDAO;

	public void addMessage(int roomId, String writer, String body) {
		chatDAO.addMessage(roomId, writer, body);
	}

	public List getMessages() {
		return chatDAO.getMessages();
	}

	public List getMessagesFrom(int roomId, int from) {
		return chatDAO.getMessagesFrom(roomId, from);
	}

	public void clearAllMessages() {
		chatDAO.clearAllMessages();
	}
	
}
