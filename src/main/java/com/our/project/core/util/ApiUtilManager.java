package com.our.project.core.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.our.project.service.ConfigService;
import com.our.project.vo.ApiAttr;

import org.json.XML;

@Component("apiUtilManager")
public class ApiUtilManager {
	@Autowired
	ConfigService configService;
	
	public  void callApi(HashMap<String, Object> apiObj){
		try {
		String serviceKey = apiObj.get("serviceKey").toString();
		String url = apiObj.get("url").toString();
		String type = apiObj.get("type").toString();
		String tableNm = apiObj.get("tableNm").toString();
		String apiUrl = url+"?serviceKey="+serviceKey;
		String urlParams =""; 
		 
		ArrayList<ApiAttr> list = (ArrayList<ApiAttr>) apiObj.get("params");
		Boolean isCode = false;
		List<HashMap<String, Object>> valList = new ArrayList<HashMap<String, Object>>();
			if(list != null) {
				for (int i = 0; i < list.size(); i++) {
					
					valList = list.get(i).getCodeVals();
					if(valList != null) {
						isCode = true;
						/*ÏΩîÎìúÍ∞? Í∞??àòÎßåÌÅº api ?ò∏Ï∂? valList[{schlId=0000001}, {schlId=0000002}, {schlId=0000003}]*/
						
						for(int j=0; j< valList.size() ; j++) {
							String keyParams="";
							Map<String, Object> map = valList.get(j);
							Set set = map.keySet();
							Iterator iterator = set.iterator();
							while(iterator.hasNext()){
			
							  String key = (String)iterator.next();
			
							  //System.out.println("Î∞©Î≤ï1) key : " + key +" / value : " + map.get(key));
							  
							    keyParams = "&"+key+"="+map.get(key);
			
							}
								//System.out.println("apiUrl"+ apiUrl + urlParams +keyParams);
							    /*api?ò∏Ï∂?*/
							   StringBuffer response = getConnection( apiUrl + urlParams +keyParams);
							     
						       getXmlJson(tableNm, response);
						}
					}else {
			            urlParams = urlParams + "&"+list.get(i).getParamId()+"="+list.get(i).getParamValue();
			            
					}
					
		        }
				
				//System.out.println("urlParams"+urlParams);
				if(!isCode) {
					StringBuffer response = getConnection(apiUrl+urlParams);
				     
			        getXmlJson( tableNm, response); 
				}
	            
				
			}else {
				System.out.println("apiUrl"+apiUrl);
				StringBuffer response = getConnection(apiUrl);
			     
		        getXmlJson(tableNm, response); 
			}
			
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	}
	


	
	
	private void getXmlJson(String tableNm, StringBuffer response)
			throws Exception {
		org.json.JSONObject xmlJSONObj = XML.toJSONObject(response.toString());
         String xmlJSONObjString = xmlJSONObj.toString();
         JSONParser parser = new JSONParser();
         Object resObj = parser.parse(xmlJSONObjString);
         
         JSONObject responseObj =  (JSONObject)resObj;
         
         JSONObject allObj =  (JSONObject)responseObj.get("response");
         //System.out.println("body"+allObj.get("body").toString());
         JSONObject headerObj =  (JSONObject)allObj.get("header");
         if(headerObj.get("resultCode").equals("00")) {
        	 JSONObject bodyObj =  (JSONObject)allObj.get("body");
        	 
    		 int totalCnt = Integer.parseInt(bodyObj.get("totalCount").toString()); 
    		 
    		 if(totalCnt>1) {
    			 
        		 JSONObject itemsObj =  (JSONObject)bodyObj.get("items");
        		 getArray(tableNm, itemsObj);
    		 }else if(totalCnt == 1) {
    			 JSONObject itemsObj =  (JSONObject)bodyObj.get("items");
    			 getObject(tableNm, itemsObj);
    		 }
        	 
         }
	}
	
	


	private void getObject(String tableNm, JSONObject itemsObj) throws Exception {
		//System.out.println("returnType view");
		
		JSONObject itemObj =  (JSONObject)itemsObj.get("item");
		//System.out.println("itemObj"+itemObj.toString());
		/*?Öå?ù¥Î∏? Ï°¥Ïû¨ Ï≤¥ÌÅ¨*/
		int cntTable = configService.checkTable(tableNm);
		String insertSql = "";
		String valuesSql = "";
		Set<String> colKey = itemObj.keySet();
		Iterator<String> colIter = colKey.iterator();
		
			if(tableNm != null && !tableNm.isEmpty()) {
				
				String sql= "create table  `" + tableNm + "` (";
				insertSql =insertSql+ "insert into "+tableNm+ " (";
				while (colIter.hasNext()) {
					String keyname = colIter.next();
					String keyvalue = itemObj.get(keyname).toString();
				    sql = sql +"`"+keyname+"` VARCHAR(50) NULL DEFAULT NULL,";
				  		//System.out.println("ddl"+keyname);
				  	insertSql =insertSql+keyname+',';
				  	valuesSql =valuesSql+"'"+keyvalue+"',";
				  	//System.out.println("insertSql"+insertSql);
				  	//System.out.println("valuesSql"+valuesSql);
					}
				sql = sql.substring(0, sql.length()-1);
				insertSql = insertSql.substring(0, insertSql.length()-1);
				valuesSql = valuesSql.substring(0, valuesSql.length()-1);
				
				sql = sql + ") COLLATE='utf8_general_ci'\r\n" + 
						"ENGINE=InnoDB";
				insertSql = insertSql + ") values ("; 
				valuesSql =valuesSql+")";
				if(cntTable==0) {
					if(sql !=null) {
						configService.createDdl(sql);
						//System.out.println("sql"+sql);
					}
				}
				configService.insertSql(insertSql+valuesSql);
			}
		
		
	}

	private void getArray(String tableNm, JSONObject itemsObj) throws Exception {
			
			 JSONArray arr = (JSONArray)itemsObj.get("item");
			
			 String sql="";
			 String colSql = "";
			 for(int i=0;i<arr.size();i++){
				 String insertDdlSql = "";
				 String insertSql = "";
				JSONObject itemObj = (JSONObject)arr.get(i);
				
				JSONObject tableObj = (JSONObject)arr.get(0);
				
				Set<String> colKey = tableObj.keySet();
				Iterator<String> colIter = colKey.iterator();
				HashMap<String, Object> colmap = new HashMap<>();
				
				
				if(tableNm != null && !tableNm.isEmpty() ) {
					
					sql= "create table if not exists `" + tableNm + "` (";
					
					while (colIter.hasNext()) {
						
						String keyname = colIter.next();
					    sql = sql +""+keyname+" VARCHAR(50) NULL DEFAULT NULL,";
						}
					
					sql = sql.substring(0, sql.length()-1);
					sql = sql + ") COLLATE='utf8_general_ci'\r\n" + 
							"ENGINE=InnoDB";
				}
				
				if(sql !=null && !sql.isEmpty()) {
					configService.createDdl(sql);
					//System.out.println("sql"+sql);
				}
				
				Set<String> key = itemObj.keySet();
				
				colSql = "alter table " + tableNm + " add "; 
				
				
				Iterator<String> iter = key.iterator();
				insertDdlSql ="insert into "+tableNm+ " (";
				while (iter.hasNext()) {
					String keyname = iter.next();
					String keyvalue = itemObj.get(keyname).toString();
					insertDdlSql =insertDdlSql+keyname+',';
					insertSql =  insertSql+"'"+keyvalue+"',";
					/*alter Í∏∞Îä•Îß? ?ì∞Í≥? ?ã∂?ùÑ?ïå 
						colSql = colSql + "`"+keyname+"` VARCHAR(50)"; 
						colmap.put("tableNm", tableNm);
					    colmap.put("colNm", keyname);
					    int cntTable = configService.checkTable(tableNm);
					    int cntCol = configService.checkColumn(colmap);
						if(cntTable !=0 && cntCol == 0 ) {
							configService.createDdl(colSql);
							System.out.println("colNm"+cntCol+"colSql"+colSql);
							}
						colSql = "alter table " + tableNm + " add ";
						colmap.clear();
					*/
					
				}
				insertDdlSql = insertDdlSql.substring(0, insertDdlSql.length()-1);
				insertSql = insertSql.substring(0, insertSql.length()-1);
				insertDdlSql = insertDdlSql + ") values ("; 
				insertSql = insertSql + ");";
				
				configService.insertSql(insertDdlSql+insertSql);
				
			 }
			
				
				
			
			 
		 
	}

	private StringBuffer getConnection(String apiUrl)
			throws MalformedURLException, IOException, ProtocolException, UnsupportedEncodingException {
		
		 URL obj = new URL(apiUrl);
	     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	     // optional default is GET
	     con.setRequestMethod("GET");
	     con.setRequestProperty("Content-Type", "application/json");
	    
	     
	     con.setDoOutput(true);
	     con.setConnectTimeout(5000);
	     con.setReadTimeout(5000);
	     
	     int status = con.getResponseCode();
	     //System.out.println("status"+status);
	     //BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	     BufferedReader in = new BufferedReader(new InputStreamReader((InputStream) con.getContent(),"UTF-8"));
	     
	    
	     
	     String inputLine;
	     StringBuffer response = new StringBuffer();
	     while ((inputLine = in.readLine()) != null) {
	    	
	     	response.append(inputLine);
	     }
	     in.close();
		return response;
	}
	
	
}
