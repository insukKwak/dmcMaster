package com.our.project.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.our.project.core.util.ApiUtilManager;
import com.our.project.service.ConfigService;
import com.our.project.vo.ApiAttr;
import com.our.project.vo.ConfigApi;



@Controller("configControllser")
@RequestMapping("/config/*")
public class ConfigController {

	@Autowired
	private ConfigService configService;
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	ApiUtilManager apiUtilManager;

	@RequestMapping("/api/list")
	public String list(ModelMap model) throws Exception {
		List<ConfigApi> list = configService.apiList();
		model.addAttribute("list",list);
		
		return "/api/list";
		
	}
	
	@RequestMapping("/api/board")
	public String board(ModelMap model) throws Exception {
		List<ConfigApi> list = configService.apiList();
		model.addAttribute("list",list);
		
		return "/api/board";
		
	}
	
	@RequestMapping("/api/form")
	public String form(){
		return "/api/form";
	}
	
	@RequestMapping("/api/view")
	public String view(HttpServletRequest req,ModelMap model) throws JsonParseException, JsonMappingException, IOException{
		String apiId=req.getParameter("id");
		ConfigApi api = configService.retrieve(apiId);
		List<HashMap<String,Object>> obj = configService.retrieveAttr(apiId);
		int attrCnt = obj.size();
		model.addAttribute("api",api);
		model.addAttribute("attr",obj);
		model.addAttribute("attrCnt",attrCnt);
		return "/api/form";
	}
	
	
	
	@RequestMapping("/api/save")
	public String save(@ModelAttribute ConfigApi api,@ModelAttribute ApiAttr attr, HttpServletRequest request) throws Exception {
		
		configService.create(api);
		
		String[] ids = request.getParameterValues("paramId");
		String[] vals = request.getParameterValues("paramValue");
		
		
		String url = api.getUrl();
		HashMap<String,Object> apiObj = new HashMap<String,Object>();
		apiObj.put("apiId", api.getApiId());
		apiObj.put("name", api.getName());
		apiObj.put("type", api.getType());
		apiObj.put("url", api.getUrl());
		apiObj.put("serviceKey", api.getServiceKey());
		apiObj.put("tableNm", api.getTableNm());
		
		List<ApiAttr> list = new ArrayList<ApiAttr>();
		
		if(ids != null && vals != null) {
			for(int i=0 ; i < ids.length ; i++) {
				
				ApiAttr attrObj = new ApiAttr();
				String val = vals[i];
				attrObj.setApiId(api.getApiId());
				attrObj.setParamId(ids[i]);
				if(val.contains("_")) {
					String content[] = val.split("_");
					String contTable = content[0];
					String contId = content[1];
					List<HashMap<String, Object>> valList = new ArrayList<HashMap<String, Object>>();
					HashMap<String, Object> contParams = new HashMap<String, Object>();
					contParams.put("contId", contId);
					contParams.put("contTable", contTable);
					valList=configService.readTable(contParams);
					attrObj.setCodeVals(valList);
					System.out.println("valList"+valList);
				}
				attrObj.setParamValue(val);
				System.out.println(ids[i]+"dddd"+vals[i]);
				list.add(attrObj);
				
				configService.createAttr(attrObj);
			}
			
			apiObj.put("params", list);
		}
		
		apiUtilManager.callApi(apiObj);
		return "redirect:/config/api/list";
	}
	
	@RequestMapping("/api/update")
	public String update(@ModelAttribute ConfigApi api,@ModelAttribute ApiAttr attr, HttpServletRequest request) throws Exception {
		
		configService.update(api);
		configService.deleteAttr(api.getApiId());
		String[] ids = request.getParameterValues("paramId");
		String[] vals = request.getParameterValues("paramValue");
		
		
		String url = api.getUrl();
		HashMap<String,Object> apiObj = new HashMap<String,Object>();
		apiObj.put("apiId", api.getApiId());
		apiObj.put("name", api.getName());
		apiObj.put("type", api.getType());
		apiObj.put("url", api.getUrl());
		apiObj.put("serviceKey", api.getServiceKey());
		apiObj.put("tableNm", api.getTableNm());
		
		List<ApiAttr> list = new ArrayList<ApiAttr>();
		
		if(ids != null && vals != null) {
			for(int i=0 ; i < ids.length ; i++) {
				System.out.println("ids"+ids[i]);
				ApiAttr attrObj = new ApiAttr();
				String val = vals[i];
				attrObj.setApiId(api.getApiId());
				attrObj.setParamId(ids[i]);
				if(val.contains("_")) {
					String content[] = val.split("_");
					String contTable = content[0];
					String contId = content[1];
					List<HashMap<String, Object>> valList = new ArrayList<HashMap<String, Object>>();
					HashMap<String, Object> contParams = new HashMap<String, Object>();
					contParams.put("contId", contId);
					contParams.put("contTable", contTable);
					valList=configService.readTable(contParams);
					attrObj.setCodeVals(valList);
					
				}
				attrObj.setParamValue(val);
				System.out.println(ids[i]+"dddd"+vals[i]);
				list.add(attrObj);
				
				configService.createAttr(attrObj);
			}
			
			apiObj.put("params", list);
		}
		
			apiUtilManager.callApi(apiObj);
			
		
		
		return "redirect:/config/api/list";
	}

}
