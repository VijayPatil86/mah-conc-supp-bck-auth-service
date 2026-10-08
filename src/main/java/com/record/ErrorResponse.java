package com.record;

import java.util.Map;

public record ErrorResponse(String error, Map<String, String> fields) {}
