package com.desarrollo.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloWorld {
	public helloWorld() {
		
	}
	
	@GetMapping("/hello")
	public String helloWorld() {
		return "Hola mundo";
	}
}
