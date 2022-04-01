package com.our.project.core.model;


public enum ResponseCodeText {

	SUCCESS("ì²˜ë¦¬?— ?„±ê³µí•˜???Šµ?‹ˆ?‹¤."),
	FAIL("ì²˜ë¦¬?— ?‹¤?Œ¨?•˜???Šµ?‹ˆ?‹¤."),
	FAIL_AUTH("ê¶Œí•œ?´ ?—†?Šµ?‹ˆ?‹¤."),
	FAIL_AUTH_LOGIN("ë¡œê·¸?¸ ?›„ ?´?š© ê°??Š¥?•©?‹ˆ?‹¤."),
	FAIL_BAD_PARAM("?š”ì²?? •ë³´ê? ?˜¬ë°”ë¥´ì§? ?•Š?Šµ?‹ˆ?‹¤."),
	FAIL_550("ì²˜ë¦¬?— ?‹¤?Œ¨?•˜???Šµ?‹ˆ?‹¤.");

	private String code;

	private ResponseCodeText(String code) {
		this.code = code;
	}

	public String getValue() {
		return code;
	}
}
