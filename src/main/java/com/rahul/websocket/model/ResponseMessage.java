package com.rahul.websocket.model;

public class ResponseMessage {

	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public ResponseMessage(String content) {

		this.content = content;
	}

	public ResponseMessage() {

	}

}
