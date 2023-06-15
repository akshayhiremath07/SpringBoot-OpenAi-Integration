package com.getitdone.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ChatBotConfig {
	
	@Value("${openai.api.key}")
	private String openApikey;
	
	@Bean
	public RestTemplate getTemplate() {
	    RestTemplate restTemplate = new RestTemplate();
	    restTemplate.getInterceptors().add((request, body, execution) -> {
	        request.getHeaders().add("Authorization", "Bearer " + "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");
	        return execution.execute(request, body);
	    });
	    return restTemplate;
	}
}
