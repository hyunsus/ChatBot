package com.hyunsu.chatbot;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	

	@CrossOrigin("*")
	@PostMapping(value = "/chat")
	public Map message(Locale locale, Model model) {
		logger.info("¸Þ¼¼Áö ºÒ·¯¿À±â");
		
		Map map = new HashMap();
		Map submap = new HashMap();
		
		map.put("id", "chatbot");
		map.put("text", "¾È³ç ³ª´Â Ãªº¿ÀÌ¾ß!");
		map.put("createdAt", "new Data()");
		
		submap.put("id", "user");
		map.put("user", submap);
		
		System.out.println(map);
		
		return map;
	}
	
}
