package com.hyunsu.chatbot.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyunsu.chatbot.service.ChatService;

@RestController
public class ChatController {

	@Autowired
	ChatService chatService;

	@CrossOrigin("*")
	@PostMapping(value = "/chat/open")
	public Map open(@RequestBody Map<String, Object> data) {

		System.out.println(data);
		Integer num = (int) data.get("num");
		if (num == 1)
			System.out.println("서울지점");
		else
			System.out.println("경기지점");
		return chatService.open();
	}

	@CrossOrigin("*")
	@PostMapping(value = "/chat/message")
	public Map message(@RequestBody Map<String, Object> data, HttpServletRequest req) throws IOException {
		// Utils.stream(chatService.tts(data), res.getOutputStream());
		return chatService.message(data, req);
	}
}