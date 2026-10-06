package com.controller;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.record.SendOtpRequest;

import jakarta.validation.Valid;

@RequestMapping(path = "/auth")
@RestController
public class AuthController {
	@PostMapping(
			path = "/send-otp",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, String> sendOtp(@Valid @RequestBody SendOtpRequest request) {
		return Map.of("message", "Hello " + request.userName() + " from Auth TestController");
	}
}
