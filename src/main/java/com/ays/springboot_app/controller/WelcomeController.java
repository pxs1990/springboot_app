package com.ays.springboot_app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@GetMapping(value="welcome")
	public String getWelcomeComeMessage() {
		return "Hi Guest, Welcome to JackApp API";
	}
}
