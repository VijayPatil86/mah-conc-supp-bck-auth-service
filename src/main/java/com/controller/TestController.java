package com.controller;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/auth")
@RestController
public class TestController {
	@GetMapping(path = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, String> test() {
		return Map.of("message", "Hello from Auth TestController");
	}
}
