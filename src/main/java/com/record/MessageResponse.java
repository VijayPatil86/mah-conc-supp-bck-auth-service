package com.record;

public record MessageResponse(String message) {
	public static final String SEND_OTP_MESSAGE_GENERIC =
			"If your email is registered with us, you will receive an OTP shortly. Please check your email.";
	public static MessageResponse sendOtpMessageGeneric() {
		return new MessageResponse(SEND_OTP_MESSAGE_GENERIC);
	}
}
