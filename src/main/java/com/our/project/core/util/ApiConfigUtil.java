package com.our.project.core.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.json.XML;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.our.project.service.ApiConfigService;

@Component("ApiConfigUtil")
public class ApiConfigUtil {
	
	@Autowired
	ApiConfigService apiConfigService;
	
	public void callApiByList(HashMap<String, Object> params) throws Exception {
		System.out.println("###################### callApiByList ######################");
		
		String returnType = FormatUtil.toString(params.get("returnType"));
		String tableNm = FormatUtil.toString(params.get("tableNm"));
		String apiUrl = params.get("url") + "?serviceKey=" + params.get("serviceKey");
		String urlParams = "";
		ArrayList<HashMap<String, Object>> tableList = (ArrayList<HashMap<String, Object>>) params.get("tableList");
		Boolean isCode = false;
		List<HashMap<String, Object>> valList = new ArrayList<HashMap<String, Object>>();

		try {
			if (tableList != null) {
				for (int i = 0; i < tableList.size(); i++) {
					valList = (List<HashMap<String, Object>>) tableList.get(i).get("codeVals");
					System.out.println("valList : " + valList);
					if (valList != null) {
						System.out.println("valList size : " + valList.size());
						isCode = true;
						for (int j = 0; j < valList.size(); j++) {
							String keyParams = "";
							HashMap<String, Object> keyMap = valList.get(j);
							Set<String> set = keyMap.keySet();
							Iterator<String> iterator = set.iterator();
							while (iterator.hasNext()) {
								String key = iterator.next();
								keyParams = "&" + key + "=" + keyMap.get(key);
							}
							StringBuffer response = getConnection(apiUrl + urlParams + keyParams);
							System.out.println("response : " + response);
							getXmlJson(returnType, tableNm, response);
						}
					}else {
						urlParams = urlParams + "&" + tableList.get(i).get("paramId") + "=" + tableList.get(i).get("paramValue");
					}
				}
				if(!isCode) {
					StringBuffer response = getConnection(apiUrl + urlParams);
					
					getXmlJson(returnType, tableNm, response);
				}
			}else {
				StringBuffer response = getConnection(apiUrl);
				
				getXmlJson(returnType, tableNm, response);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void callApiByView(HashMap<String, Object> params) throws Exception {
		System.out.println("###################### callApiByView ######################");
		
		String returnType = FormatUtil.toString(params.get("returnType"));
		String tableNm = FormatUtil.toString(params.get("tableNm"));
		String apiUrl = params.get("url") + "?serviceKey=" + params.get("serviceKey");
		String urlParams = "";
		ArrayList<HashMap<String, Object>> tableList = (ArrayList<HashMap<String, Object>>) params.get("tableList");
		Boolean isCode = false;
		List<HashMap<String, Object>> valList = new ArrayList<HashMap<String, Object>>();
		
		try {
			if (tableList != null) {
				for (int i = 0; i < tableList.size(); i++) {
					valList = (List<HashMap<String, Object>>) tableList.get(i).get("codeVals");
					System.out.println("valList : " + valList);
					if (valList != null) {
						isCode = true;
						for (int j = 0; j < valList.size(); j++) {
							String keyParams = "";
							HashMap<String, Object> keyMap = valList.get(j);
							Set<String> set = keyMap.keySet();
							Iterator<String> iterator = set.iterator();
							while (iterator.hasNext()) {
								String key = iterator.next();
								keyParams = "&" + key + "=" + keyMap.get(key);
								System.out.println("keyParams : " + keyParams);
							}
							StringBuffer response = getConnection(apiUrl + urlParams + keyParams);
							
							getXmlJson(returnType, tableNm, response);
						}
					}else {
						urlParams = urlParams + "&" + tableList.get(i).get("paramId") + "=" + tableList.get(i).get("paramValue");
					}
				}

				System.out.println("urlParams : " + urlParams);
				
				if(!isCode) {
					StringBuffer response = getConnection(apiUrl + urlParams);
					
					getXmlJson(returnType, tableNm, response);
				}
			}else {
				StringBuffer response = getConnection(apiUrl);
				
				getXmlJson(returnType, tableNm, response);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getXmlJson(String returnType, String tableNm, StringBuffer response) throws Exception {
		System.out.println("###################### getXmlJson ######################");
		org.json.JSONObject xmlJSONObj = XML.toJSONObject(response.toString());
		String xmlJSONObjString = xmlJSONObj.toString();
		JSONParser parser = new JSONParser();
		Object resObj = parser.parse(xmlJSONObjString);

		JSONObject responseObj = (JSONObject) resObj;

		JSONObject allObj = (JSONObject) responseObj.get("response");
        System.out.println("body"+allObj.get("body").toString());
		JSONObject headerObj = (JSONObject) allObj.get("header");
		if (headerObj.get("resultCode").equals("00")) {
			JSONObject bodyObj = (JSONObject) allObj.get("body");

			int totalCnt = Integer.parseInt(bodyObj.get("totalCount").toString());
        	System.out.println("totalCount : " + bodyObj.get("totalCount").toString());
			if (returnType.equals("list")) {
				if (totalCnt > 0) {
					JSONObject itemsObj = (JSONObject) bodyObj.get("items");
					System.out.println("items : " + itemsObj.get("item"));
					getArray(tableNm, itemsObj);
				}
			} else {
				if (totalCnt > 0) {
					JSONObject itemsObj = (JSONObject) bodyObj.get("items");
					getObject(tableNm, itemsObj);
				}
			}
		}
	}

	private void getObject(String tableNm, JSONObject itemsObj) throws Exception {
		System.out.println("###################### getObject ######################");

		JSONObject itemObj = (JSONObject) itemsObj.get("item");
		System.out.println("itemObj"+itemObj.toString());
		int cntTable = apiConfigService.checkTable(tableNm);
		String insertSql = "";
		String valuesSql = "";
		Set<String> colKey = itemObj.keySet();
		Iterator<String> colIter = colKey.iterator();

		if (tableNm != null && !tableNm.isEmpty()) {
			String sql = "create table  `" + tableNm + "` (";
			insertSql = insertSql + "insert into " + tableNm + " (";
			while (colIter.hasNext()) {
				String keyname = colIter.next();
				String keyvalue = itemObj.get(keyname).toString();
				sql = sql + "`" + keyname + "` VARCHAR(50) NULL DEFAULT NULL,";
				insertSql = insertSql + keyname + ',';
				valuesSql = valuesSql + "'" + keyvalue + "',";
			  	System.out.println("insertSql"+insertSql);
			  	System.out.println("valuesSql"+valuesSql);
			}
			sql = sql.substring(0, sql.length() - 1);
			insertSql = insertSql.substring(0, insertSql.length() - 1);
			valuesSql = valuesSql.substring(0, valuesSql.length() - 1);

			sql = sql + ") COLLATE='utf8_general_ci'\r\n" + "ENGINE=InnoDB";
			insertSql = insertSql + ") values (";
			valuesSql = valuesSql + ")";
			if (cntTable == 0) {
				if (sql != null) {
					apiConfigService.createDdl(sql);
					System.out.println("sql"+sql);
				}
			}
			apiConfigService.insertSql(insertSql + valuesSql);
		}
	}

	private void getArray(String tableNm, JSONObject itemsObj) throws Exception {
		System.out.println("###################### getArray ######################");
		
		 JSONArray arr = (JSONArray) itemsObj.get("item");		
		 String sql="";
		 
		 for(int i=0;i<arr.size();i++){
			 String insertDdlSql = "";
			 String insertSql = "";
			 JSONObject itemObj = (JSONObject)arr.get(i);			
			 JSONObject tableObj = (JSONObject)arr.get(0);
			
			 Set<String> colKey = tableObj.keySet();
			 Iterator<String> colIter = colKey.iterator();

			 System.out.println("colKey : " + colKey);
			 System.out.println("colIter : " + colIter);
			 
			 if(tableNm != null && !tableNm.isEmpty()) {
				 sql= "create table if not exists `" + tableNm + "` (";
				 while (colIter.hasNext()) {
					 String keyname = colIter.next();
					 sql = sql +"`"+keyname+"` VARCHAR(50) NULL DEFAULT NULL,";
				 }
				 sql = sql.substring(0, sql.length()-1);
				 sql = sql + ") COLLATE='utf8_general_ci'\r\n" +  "ENGINE=InnoDB";
			 System.out.println("getArray sql : " + sql);
			 }	

			 Set<String> key = itemObj.keySet();
			 Iterator<String> iter = key.iterator();
			 System.out.println("key : " + key);
			 System.out.println("iter : " + iter);
			 
			 insertDdlSql ="insert into "+tableNm+ " (";
			 
			 while (iter.hasNext()) {
				 String keyname = iter.next();
				 String keyvalue = itemObj.get(keyname).toString();
				 insertDdlSql =insertDdlSql+keyname+',';
				 insertSql =  insertSql+"'"+keyvalue+"',";	
			 }
			 
			 insertDdlSql = insertDdlSql.substring(0, insertDdlSql.length()-1);
			 insertSql = insertSql.substring(0, insertSql.length()-1);
			 insertDdlSql = insertDdlSql + ") values ("; 
			 insertSql = insertSql + ");";
		
			 if(sql !=null && !sql.isEmpty()) {
				 apiConfigService.createDdl(sql);
				 System.out.println("createDdl sql : " +sql);
			 }
			 apiConfigService.insertSql(insertDdlSql+insertSql);			
		 }
	}

	private StringBuffer getConnection(String apiUrl) throws MalformedURLException, IOException, ProtocolException, UnsupportedEncodingException {
		
		URL obj = new URL(apiUrl);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Content-Type", "application/json");
		con.setDoOutput(true);
		con.setConnectTimeout(5000);
		con.setReadTimeout(5000);

		int status = con.getResponseCode();
		BufferedReader in = new BufferedReader(new InputStreamReader((InputStream) con.getContent(), "UTF-8"));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}

		in.close();
		return response;
	}
}
