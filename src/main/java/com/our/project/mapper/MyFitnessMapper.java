package com.our.project.mapper;

import java.util.HashMap;
import java.util.List;

import com.our.project.core.annotation.Mapper;

@Mapper
public interface MyFitnessMapper {
	
	public HashMap<String, Object> selectMyFitness(HashMap<String, Object> params) throws Exception;
	
	public List<HashMap<String, Object>> selectMyList(HashMap<String, Object> params) throws Exception;
	
	public List<HashMap<String, Object>> selectUserList(HashMap<String, Object> params) throws Exception;
}
