package com.record;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SendOtpRequest(
		@NotBlank(message = "user name is required")
		@Size(max = 254, message = "user name must not exceed 50 characters")
		@Email(message = "email format is invalid")
		String userName
) {
	public SendOtpRequest {
		if (userName != null) {
			userName = userName.trim();
		}
	}
}
