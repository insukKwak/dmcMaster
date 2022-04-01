package com.our.project.core.model;

import java.util.HashMap;

import com.our.project.core.util.FormatUtil;

/**
 *
 * @author Administrator
 *
 */
public class ResponseMessage {

	/**
	 *
	 */
	public static enum TARGET {SELF, NEW, OPENER, OPENER_CLOSE, POPUP, CLOSE, BACK};

	/**
	 *
	 */
	public static enum METHOD {GET_REPLACE, GET, POST};


	/**
	 *
	 */
	private String message;

	/**
	 * 
	 */
	private String message__NOTXSS;
	
	/**
	 * 
	 */
	private ResponseCode code;

	/**
	 *
	 */
	private String href;

	/**
	 *
	 */
	private TARGET target;

	/**
	 *
	 */
	private METHOD method;
	
	/**
	 * 
	 */
	private HashMap<String, Object> data;


	/**
	 * 
	 */
	public ResponseMessage() {
		this(null, null, null, null);
	}

	
	public ResponseMessage(String message) {
		this(message, null, null, null);
	}
	
	
	/**
	 *
	 * @param message
	 * @param href
	 */
	public ResponseMessage(String message, String href) {
		this(message, href, null, null);
	}

	/**
	 *
	 * @param message
	 * @param href
	 * @param target
	 */
	public ResponseMessage(String message, String href, TARGET target) {
		this(message, href, target, null);
	}

	/**
	 *
	 * @param message
	 * @param href
	 * @param target
	 * @param method
	 */
	public ResponseMessage(String message, String href, TARGET target, METHOD method) {
		this.setMessage(message);
		this.setCode(null);
		this.setHref(href);
		this.setTarget(target);
		this.setMethod(method);
	}

	/**
	 *
	 * @return
	 */
	public String getMessage() {
		return message;
	}

	/**
	 *
	 * @return
	 */
	public String getMessage__NOTXSS() {
		return message__NOTXSS;
	}

	/**
	 *
	 * @param message
	 */
	public ResponseMessage setMessage(String message) {
		this.message = FormatUtil.encodeXSS(message);
		this.message__NOTXSS = message;
		return this;
	}

	/**
	 *
	 * @param message
	 */
	public ResponseMessage setMessage(ResponseCodeText rct) {
		for (ResponseCodeText theCode : ResponseCodeText.values()) {
			if (theCode.toString().equals(this.code.toString())) {
				this.message = FormatUtil.encodeXSS(rct.getValue());
				this.message__NOTXSS = rct.getValue();
			}
		}
		
		return this;
	}

	/**
	 *
	 * @return
	 */
	public ResponseCode getCode() {
		return code;
	}

	/**
	 *
	 * @return
	 */
	public int getCodeValue() {
		return code.getValue();
	}
	
	/**
	 * 
	 * @param code
	 * @return
	 */
	public ResponseMessage setCode(int code) {
		for (ResponseCode theCode : ResponseCode.values()) {
			if (theCode.getValue() == code) {
				return setCode(code);
			}
		}
		
		return setCode(null);
	}
	
	/**
	 * 
	 * @param code
	 * @return
	 */
	public ResponseMessage setCode(ResponseCode code) {
		this.code = (code == null ? ResponseCode.SUCCESS : code);

		if (this.message == null || "".equals(this.message)) {
			for (ResponseCodeText theCodeText : ResponseCodeText.values()) {
				if (theCodeText.toString().equals(this.code.toString())) {
					setMessage(theCodeText);
				}
			}
		}
		
		return this;
	}

	/**
	 *
	 * @return
	 */
	public String getHref() {
		return href;
	}

	/**
	 *
	 * @param href
	 */
	public ResponseMessage setHref(String href) {
		this.href = (href == null || "".equals(href) ? "/" : FormatUtil.encodeXSS(href));
		return this;
	}

	/**
	 *
	 * @return
	 */
	public TARGET getTarget() {
		return target;
	}

	/**
	 *
	 * @param target
	 */
	public ResponseMessage setTarget(TARGET target) {
		this.target = (target == null ? TARGET.SELF : target);
		return this;
	}

	/**
	 *
	 * @return
	 */
	public METHOD getMethod() {
		return method;
	}

	/**
	 *
	 * @param method
	 */
	public ResponseMessage setMethod(METHOD method) {
		this.method = (method == null ? METHOD.GET_REPLACE : method);
		return this;
	}
	
	/**
	 * 
	 * @return
	 */
	public HashMap<String, Object> getData() {
		return this.data;
	}
	
	/**
	 * 
	 * @param data
	 */
	public ResponseMessage setData(HashMap<String, Object> data) {
		this.data = data;
		return this;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		int dataSize = 0;
		if(data != null) dataSize = data.size();
		return "ResponseMessage [message=" + message + ", message__NOTXSS=" + message__NOTXSS + ", code=" + code
				+ ", href=" + href + ", target=" + target + ", method=" + method + ", data(key count)=" + dataSize + "]";
	}
}
