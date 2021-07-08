package com.apps.org.controller.impl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apps.org.controller.HelloController;

@RestController	
@RequestMapping("/api/v1")
public class HelloControllerImpl implements HelloController {

	@RequestMapping("/hello")
	public String index() {
		return "Greetings from Spring Boot!";
	}
}
