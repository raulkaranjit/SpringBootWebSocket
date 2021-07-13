package com.rahul.websocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.rahul.websocket.model.Message;
import com.rahul.websocket.model.ResponseMessage;

@Controller
public class MessageController {

	@Autowired

	private SimpMessagingTemplate SimpMessagingTemplate;

	@MessageMapping("/hello")
	public void send(SimpMessageHeaderAccessor sha, @Payload String username) throws InterruptedException {
		System.out.println(username);
		String message = "Hello From " + sha.getUser().getName();
		System.out.println(message);
		
		SimpMessagingTemplate.convertAndSendToUser(username, "/queue/messages", message);
	}
}
