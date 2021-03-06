package com.our.project.core.model;


public enum ResponseCodeText {

	SUCCESS("μ²λ¦¬? ?±κ³΅ν???΅??€."),
	FAIL("μ²λ¦¬? ?€?¨????΅??€."),
	FAIL_AUTH("κΆν?΄ ??΅??€."),
	FAIL_AUTH_LOGIN("λ‘κ·Έ?Έ ? ?΄?© κ°??₯?©??€."),
	FAIL_BAD_PARAM("?μ²?? λ³΄κ? ?¬λ°λ₯΄μ§? ??΅??€."),
	FAIL_550("μ²λ¦¬? ?€?¨????΅??€.");

	private String code;

	private ResponseCodeText(String code) {
		this.code = code;
	}

	public String getValue() {
		return code;
	}
}
