package com.our.project.mapper;

import com.our.project.core.annotation.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface ProductMapper {
	
	public List<HashMap<String, Object>> list(HashMap<String, Object> params) throws Exception;
	
	public HashMap<String, Object> select(HashMap<String, Object> params) throws Exception;
	
	public HashMap<String, Object> cnt(HashMap<String, Object> params) throws Exception;
	
	public int create(HashMap<String, Object> params) throws Exception;
	
	public int update(HashMap<String, Object> params) throws Exception;
	
	public int delete(HashMap<String, Object> params) throws Exception;
	
	public List<HashMap<String, Object>> depthList(HashMap<String, Object> params) throws Exception;
	
	public List<HashMap<String, Object>> custList(HashMap<String, Object> params) throws Exception;
	
	public HashMap<String, Object> custSelect(HashMap<String, Object> params) throws Exception;
	
	public HashMap<String, Object> custCnt(HashMap<String, Object> params) throws Exception;
	
	public int custCreate(HashMap<String, Object> params) throws Exception;
	
	public int custUpdate(HashMap<String, Object> params) throws Exception;
	
	public int custDelete(HashMap<String, Object> params) throws Exception;
	
	public List<HashMap<String, Object>> apprList(HashMap<String, Object> params) throws Exception;
	
	
	
}
