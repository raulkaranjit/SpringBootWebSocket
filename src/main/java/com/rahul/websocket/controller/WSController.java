package com.rahul.websocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.websocket.model.Message;
import com.rahul.websocket.service.WSService;

@RestController
public class WSController {

	@Autowired
	private WSService service;
	
	@PostMapping("/send-message")
	public void sendMessage(@RequestBody final Message message) {
		service.notifyFrontend(message.getMessageContent());
	}
}
