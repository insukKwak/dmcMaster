package com.our.project.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.our.project.core.model.ResponseCode;
import com.our.project.core.model.ResponseMessage;
import com.our.project.core.util.ApiConfigUtil;
import com.our.project.service.ApiConfigService;

@Controller("ApiConfigController")
@RequestMapping("/api")
public class ApiConfigController {

	@Autowired
	ApiConfigService apiConfigService;
	
	@Autowired
	ApiConfigUtil apiConfigUtil;
	
	@RequestMapping("/config/list")
	public String selectApiList(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> params) throws Exception{
		
		model.addAttribute("apiList", apiConfigService.selectApiList(params));
		
		return "apiconfig/list";
	} 
	
	@RequestMapping("/config/apiView")
	public String apiView(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> params) throws Exception{
		
		model.addAttribute("apiView", apiConfigService.selectApi(params));
		model.addAttribute("attrList", apiConfigService.selectAttrList(params));
		
		return "apiconfig/form";
	}
	
	@RequestMapping("/config/insForm")
	public String insForm(){		
		return "apiconfig/form";
	}

	@RequestMapping("/config/apiCheck")
	public @ResponseBody HashMap<String, Object> apiCheck(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> params) throws Exception{
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("data", apiConfigService.selectApi(params));
		
		return result;
	}
	
	@RequestMapping(value = {"/config/edit"}, method= RequestMethod.POST)  
	public @ResponseBody ResponseMessage edit(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> params) throws Exception{
			System.out.println("edit params : " + params);
			String[] ids = request.getParameterValues("paramId");
			String[] vals = request.getParameterValues("paramValue");

		try {
			System.out.println("###################### update API ######################");
			int cnt =  apiConfigService.updateApi(params);
			 
			if(cnt > 0) {
				
				List<HashMap<String, Object>> tableList = new ArrayList<HashMap<String,Object>>();
								
				if(ids != null && vals !=null) {					
					
					if(apiConfigService.selectAttrList(params).size() > 0) {
						apiConfigService.deleteAttr(params);
					}					
					
					for(int i=0; i<ids.length; i++) {	

						HashMap<String, Object> attrObj = new HashMap<String, Object>();				
						attrObj.put("apiId", params.get("apiId"));
						attrObj.put("paramId", ids[i]);
						attrObj.put("paramValue", vals[i]);
						apiConfigService.insertAttr(attrObj);
						
						//String val = vals[i];
						if(vals[i].contains("_")) {
							String content[] = vals[i].split("_");
							String contTable = content[0];
							String contId = content[1];
							List<HashMap<String, Object>> valList = new ArrayList<HashMap<String,Object>>();
							HashMap<String, Object> contParams = new HashMap<String, Object>();
							contParams.put("contId", contId);
							contParams.put("contTable", contTable);
							System.out.println("contId : " + contId);
							System.out.println("contTable : " + contTable);
							valList = apiConfigService.readTable(contParams);
							attrObj.put("codeVals", valList);
							System.out.println("codeVals : " + attrObj.get("codeVals"));
							System.out.println("valList : " + valList);
						}
						tableList.add(attrObj);
					}
					params.put("tableList", tableList);
				}
				
				if(params.get("returnType").equals("list")) {
					apiConfigUtil.callApiByList(params);
				}else{
					apiConfigUtil.callApiByView(params);
				}

			}else if(cnt == 0) {
				System.out.println("###################### insert API ######################");
				int cntApi = apiConfigService.insertApi(params);
				
				if(cntApi > 0) {
					
					List<HashMap<String, Object>> tableList = new ArrayList<HashMap<String,Object>>();
					
					if(ids != null && vals !=null) {
						HashMap<String, Object> attrObj = new HashMap<String, Object>();
						attrObj.put("apiId", params.get("apiId"));
						
						for(int i=0;  i<ids.length; i++) {
							attrObj.put("paramId", ids[i]);
							attrObj.put("paramValue", vals[i]);
							apiConfigService.insertAttr(attrObj);
							
							if(vals[i].contains("_")) {
								String content[] = vals[i].split("_");
								String contTable = content[0];
								String contId = content[1];
								List<HashMap<String, Object>> valList = new ArrayList<HashMap<String,Object>>();
								HashMap<String, Object> contParams = new HashMap<String, Object>();
								contParams.put("contId", contId);
								contParams.put("contTable", contTable);
								System.out.println("contId : " + contId);
								System.out.println("contTable : " + contTable);
								System.out.println("contParams : " + contParams);
								valList = apiConfigService.readTable(contParams);
								attrObj.put("codeVals", valList);
								System.out.println("codeVals : " + attrObj.get("codeVals"));
								System.out.println("valList : " + valList);
							}
							tableList.add(attrObj);							
						}
						params.put("tableList", tableList);
					}
					if(params.get("returnType").equals("list")) {
						apiConfigUtil.callApiByList(params);
					}else{
						apiConfigUtil.callApiByView(params);
					}					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseMessage("저장에 실패하였습니다.", null).setCode(ResponseCode.FAIL);
		}
		return new ResponseMessage("저장하였습니다.", null).setData(params);
	}
	
	@RequestMapping(value = {"/config/delete"}, method = RequestMethod.POST)
	public @ResponseBody ResponseMessage deleteApi(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> params) throws Exception{
		
		try {
			int cnt = apiConfigService.deleteApi(params);
			
			if(cnt > 0 ) {
				apiConfigService.deleteAttr(params);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseMessage("삭제에 실패하였습니다.",null).setCode(ResponseCode.FAIL);
		}
		return new ResponseMessage("삭제되었습니다.", null).setData(params);
	}
}
