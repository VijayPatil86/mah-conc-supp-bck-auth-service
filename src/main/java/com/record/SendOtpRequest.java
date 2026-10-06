package com.record;

import jakarta.validation.constraints.NotBlank;

public record SendOtpRequest(
		@NotBlank String userName
) {}
