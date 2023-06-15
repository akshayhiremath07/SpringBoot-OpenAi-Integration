package com.getitdone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.getitdone.dto.ChatGptRequest;
import com.getitdone.dto.ChatGptResponse;



@RestController
@RequestMapping("/bot")
public class ChatBotController {
	@Value("${openai.model}")
	private String model;
	@Autowired
	private RestTemplate template;
	@Value("${openai.url}")
	private String apiUrl;
    @GetMapping("/chat")
	public String chat(@RequestParam("prompt") String prompt) {
		ChatGptRequest request=new ChatGptRequest(model,prompt);
		ChatGptResponse chatGptResponse = template.postForObject(apiUrl, request, ChatGptResponse.class);
		return chatGptResponse.getChoices().get(0).getMessage().getContent();
	}
	
}
