package com.our.project.core.model;

public enum ResponseCode {

	SUCCESS(200),
	FAIL(500),
	FAIL_AUTH(501),
	FAIL_AUTH_LOGIN(502),
	FAIL_BAD_PARAM(511),
	FAIL_550(550);

	private int code;

	private ResponseCode(int code) {
		this.code = code;
	}

	public int getValue() {
		return code;
	}
}
