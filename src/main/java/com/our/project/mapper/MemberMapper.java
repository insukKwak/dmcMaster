package com.our.project.mapper;

import java.util.HashMap;
import java.util.List;

import com.our.project.core.annotation.Mapper;

@Mapper
public interface MemberMapper {
	 
	 public List<HashMap<String, Object>> selectLogin(HashMap<String, Object> params) throws Exception;
	 public List<HashMap<String, Object>> login(HashMap<String, Object> params) throws Exception;
	 public List<HashMap<String, Object>> teamSelect(HashMap<String, Object> params) throws Exception;
}
