package com.our.project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.our.project.mapper.ConfigMapper;
import com.our.project.vo.ApiAttr;
import com.our.project.vo.ConfigApi;

@Service("configService")
public class ConfigService {

	
	  @Autowired ConfigMapper configMapper;
	 

	

	public List<ConfigApi> apiList() throws Exception {
		 return configMapper.apiList();	
	}
	
	public void create(ConfigApi api) {
		configMapper.create(api);
	}
	
	public void update(ConfigApi api) {
		configMapper.update(api);
	}
	
	public void createAttr(ApiAttr attr) {
		configMapper.createAttr(attr);
	}
	
	public void deleteAttr(String apiId) {
		configMapper.deleteAttr(apiId);
	}
	
	public void createDdl(String sql) throws Exception {
		 configMapper.createDdl(sql);
	}
	public void insertSql(String insertSql) {
		configMapper.insertSql(insertSql);
	}

	public List<HashMap<String, Object>> readTable(HashMap<String, Object> params) {
		return configMapper.readTable(params);
	}
	public int checkTable(String tableNm) {
		return  configMapper.checkTable(tableNm);
	}
	
	public int checkColumn(HashMap<String, Object> map) {
		return  configMapper.checkColumn(map);
	}

	public ConfigApi retrieve(String apiId) {
		// TODO Auto-generated method stub
		return configMapper.retrieve(apiId);
	}
	
	public List<HashMap<String,Object>> retrieveAttr(String apiId) {
		// TODO Auto-generated method stub
		return configMapper.retrieveAttr(apiId);
	}
	
}
