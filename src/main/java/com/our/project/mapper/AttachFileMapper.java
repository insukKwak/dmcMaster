package com.our.project.mapper;

import java.util.HashMap;
import java.util.List;

import com.our.project.core.annotation.Mapper;

@Mapper
public interface AttachFileMapper {
	
	public List<HashMap<String, Object>> selectExampleList(HashMap<String, Object> params) throws Exception;
	
	public int delete(HashMap<String, Object> params) throws Exception;
	
	public int insert(HashMap<String, Object> params) throws Exception;
	
	public List<HashMap<String, Object>> selectList(HashMap<String, Object> params) throws Exception;
	
}
