package com.our.project.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.our.project.mapper.AttachFileMapper;

@Service("AttachFileService")
public class AttachFileService {

	@Autowired
	AttachFileMapper attachFileMapper;
	
	public List<HashMap<String, Object>> selectExampleList(HashMap<String, Object> params) throws Exception{
		return attachFileMapper.selectExampleList(params);
	}
	
	public int insert(HashMap<String, Object> params) throws Exception{
		return attachFileMapper.insert(params);
	}
	
	public int delete(HashMap<String, Object> params) throws Exception{
		return attachFileMapper.delete(params);
	}
	
	public List<HashMap<String, Object>> selectList(HashMap<String, Object> params) throws Exception{
		return attachFileMapper.selectList(params);
	}
}
