package com.our.project.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.our.project.mapper.MyFitnessMapper;

@Service
public class MyFitnessService {
	
	@Autowired
	MyFitnessMapper myFitnessMapper;
	
	public HashMap<String, Object> selectMyFitness(HashMap<String, Object> params) throws Exception{
		return myFitnessMapper.selectMyFitness(params);
	}
	
	public List<HashMap<String, Object>> selectMyList(HashMap<String, Object> params) throws Exception{
		return myFitnessMapper.selectMyList(params);
	}
	
	public List<HashMap<String, Object>> selectUserList(HashMap<String, Object> params) throws Exception{
		return myFitnessMapper.selectUserList(params);
	}
}
