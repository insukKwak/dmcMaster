package com.our.project.mapper;

import com.our.project.core.annotation.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface ProposalMapper {
	
	public List<HashMap<String, Object>> list(HashMap<String, Object> params) throws Exception;
	
	public List<HashMap<String, Object>> defList(HashMap<String, Object> params) throws Exception;
	
	public List<HashMap<String, Object>> costList(HashMap<String, Object> params) throws Exception;
	
	public HashMap<String, Object> select(HashMap<String, Object> params) throws Exception;
	
	public HashMap<String, Object> program(HashMap<String, Object> params) throws Exception;
	
	public List<HashMap<String, Object>> content(HashMap<String, Object> params) throws Exception;
	
	public HashMap<String, Object> contCnt(HashMap<String, Object> params) throws Exception;
	
	public HashMap<String, Object> cnt(HashMap<String, Object> params) throws Exception;
	
	public int create(HashMap<String, Object> params) throws Exception;
	
	public int update(HashMap<String, Object> params) throws Exception;
	
	public int delete(HashMap<String, Object> params) throws Exception;
	
	public int costCreate(HashMap<String, Object> params) throws Exception;
	
	public int costUpdate(HashMap<String, Object> params) throws Exception;
	
	public int costDelete(HashMap<String, Object> params) throws Exception;
	
	
	
}
