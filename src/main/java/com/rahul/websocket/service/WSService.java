package com.rahul.websocket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.rahul.websocket.model.ResponseMessage;

@Service
public class WSService {

	private final SimpMessagingTemplate messagingTemplate;

	@Autowired
	public WSService(SimpMessagingTemplate messagingTemplate) {
		this.messagingTemplate = messagingTemplate;
	}

	public void notifyFrontend(final String message) {
		ResponseMessage response = new ResponseMessage(message);

		messagingTemplate.convertAndSend("/topic/messages", response);
	}
}
