package com.our.project.mapper;

import java.util.HashMap;
import java.util.List;

import com.our.project.core.annotation.Mapper;

@Mapper
public interface ApiConfigMapper {

	public List<HashMap<String, Object>> selectApiList(HashMap<String, Object> params) throws Exception;
	public HashMap<String, Object> selectApi(HashMap<String, Object> params) throws Exception;
	public List<HashMap<String, Object>> selectAttrList(HashMap<String, Object> params) throws Exception;
	public int insertApi(HashMap<String, Object> params) throws Exception;
	public int insertAttr(HashMap<String, Object> params) throws Exception;
	public int updateApi(HashMap<String, Object> params) throws Exception;
	public int updateAttr(HashMap<String, Object> params) throws Exception;
	public int deleteApi(HashMap<String, Object> params) throws Exception;
	public int deleteAttr(HashMap<String, Object> params) throws Exception;
	public List<HashMap<String, Object>> readTable(HashMap<String, Object> params) throws Exception;
	public int checkTable(String tableNm) throws Exception;
	public void createDdl(String sql) throws Exception;
	public void insertSql(String insertSql) throws Exception;
	//public int createDdl(String sql) throws Exception;	
	//public int insertSql(String insertSql) throws Exception;
}
