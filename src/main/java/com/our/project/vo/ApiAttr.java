package com.our.project.vo;

import java.util.HashMap;
import java.util.List;

public class ApiAttr {
	private String apiId;
	private String paramId;
	private String paramValue;
	private List<HashMap<String, Object>> codeVals;
	public String getParamId() {
		return paramId;
	}
	public void setParamId(String paramId) {
		this.paramId = paramId;
	}
	public String getParamValue() {
		return paramValue;
	}
	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}
	public String getApiId() {
		return apiId;
	}
	public void setApiId(String apiId) {
		this.apiId = apiId;
	}
	public List<HashMap<String, Object>> getCodeVals() {
		return codeVals;
	}
	public void setCodeVals(List<HashMap<String, Object>> codeVals) {
		this.codeVals = codeVals;
	}
	
}
