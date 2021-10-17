package com.hyunsu.chatbot.service;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.hyunsu.chatbot.dao.ChatDao;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ChatService {

	private ChatDao chatDao = new ChatDao();

	@SuppressWarnings("unchecked")
	public Map<String, Object> open() {
		String json = chatDao.open();
		ObjectMapper mapper = new ObjectMapper();
	
		Map<String, Object> res = new HashMap<String, Object>();
		try {
			Map<String, Object> map = mapper.readValue(json, Map.class);		
			Map<String, Object> return_object = (Map<String, Object>) map.get("return_object");
			Map<String, Object> result = (Map<String, Object>) return_object.get("result");
			
			String text = (String) result.get("system_text");
			String uuid = (String) return_object.get("uuid");
			
			Map<String, Object> submap = new HashMap<String, Object>();
			submap.put("id", "user");
			
			res.put("id", "chatbot");
			res.put("uuid",uuid);
			res.put("text",text);
			res.put("createdAt", new Date());
			res.put("user", submap);
			
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> message(Map<String, Object> data, HttpServletRequest servletReq) {	
		Map<String, Object> question = (Map<String, Object>) data.get("question");
		
		Map<String, String> req = new HashMap<String, String>();
		req.put("text", (String) question.get("text"));
		req.put("uuid", (String) data.get("uuid"));
		
		String folderName = servletReq.getSession().getServletContext().getRealPath("/") + "resources" + File.separator + "tts";
		
		String json = chatDao.message(req);
		ObjectMapper mapper = new ObjectMapper();
		
		Map<String, Object> res = new HashMap<String, Object>();
		try {
			Map<String, Object> map = mapper.readValue(json, Map.class);		
			Map<String, Object> return_object = (Map<String, Object>) map.get("return_object");
			Map<String, Object> result = (Map<String, Object>) return_object.get("result");
			
			String text = (String) result.get("system_text");
			String uuid = (String) return_object.get("uuid");
			
			Map<String, Object> submap = new HashMap<String, Object>();
			submap.put("id", "user");
			
			res.put("id", "chatbot");
			res.put("uuid",uuid);
			res.put("text", removeTags(text));
			res.put("createdAt", new Date());
			res.put("user", submap);
			res.put("ttsUrl", chatDao.tts(folderName,text));
			
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return res;
	}
	// html escape
	private String removeTags(String text) {
		return text.replace("<br>", "");
	}

}