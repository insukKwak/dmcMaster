package com.our.project.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.our.project.mapper.ApiConfigMapper;

@Service("ApiConfigService")
public class ApiConfigService {

	@Autowired
	ApiConfigMapper apiConfigMapper;
	
	public List<HashMap<String, Object>> selectApiList(HashMap<String, Object> params) throws Exception{
		return apiConfigMapper.selectApiList(params);
	}
	
	public HashMap<String, Object> selectApi(HashMap<String, Object> params) throws Exception{
		return apiConfigMapper.selectApi(params);
	}
	
	public List<HashMap<String, Object>> selectAttrList(HashMap<String, Object> params) throws Exception{
		return apiConfigMapper.selectAttrList(params);
	}
	
	public int insertApi(HashMap<String, Object> params) throws Exception{
		return apiConfigMapper.insertApi(params);
	}
	
	public int insertAttr(HashMap<String, Object> params) throws Exception{
		return apiConfigMapper.insertAttr(params);
	}
	
	public int updateApi(HashMap<String, Object> params) throws Exception{
		return apiConfigMapper.updateApi(params);
	} 
	
	public int updateAttr(HashMap<String, Object> params) throws Exception{
		return apiConfigMapper.updateAttr(params);
	}
	
	public int deleteApi(HashMap<String, Object> params) throws Exception{
		return apiConfigMapper.deleteApi(params);
	}
	
	public int deleteAttr(HashMap<String, Object> params) throws Exception{
		return apiConfigMapper.deleteAttr(params);
	}
	
	public List<HashMap<String, Object>> readTable(HashMap<String, Object> params) throws Exception{
		return apiConfigMapper.readTable(params);
	}
	
	public int checkTable(String tableNm) throws Exception{
		return apiConfigMapper.checkTable(tableNm);
	}
	
	public void createDdl(String sql) throws Exception{
		apiConfigMapper.createDdl(sql);
	}	
	
	public void insertSql(String insertSql) throws Exception{
		apiConfigMapper.insertSql(insertSql);
	}
	
	/*
	 * public int createDdl(String sql) throws Exception{ return
	 * apiConfigMapper.createDdl(sql); }
	 */	
	

	/*
	 * public int insertSql(String insertSql) throws Exception{ return
	 * apiConfigMapper.insertSql(insertSql); }
	 */
}
