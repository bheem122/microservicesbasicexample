package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@RestController
public class ControllerTwo {
	
	private final WebClient webClient;
	
	
	@Autowired
	public ControllerTwo(WebClient.Builder webClientBuilder) {
		this.webClient=webClientBuilder.baseUrl("http://localhost:8080").build();
	}
	
	@GetMapping("/consume")
    public Mono<String> consumeService() {
        return webClient.get()
                        .uri("/msg")
                        .retrieve()
                        .bodyToMono(String.class);
	}

	@GetMapping("/msg2")
	public String msg2()
	{
		return "this is from service 2";
	}

}
