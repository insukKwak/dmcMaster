package com.our.project.service;

import java.util.List;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.our.project.mapper.ProductMapper;
import com.our.project.mapper.ProposalMapper;

@Service("ProposalService")
public class ProposalService {
	
	@Autowired
	ProposalMapper proposalMapper;
	
	public List<HashMap<String, Object>> list(HashMap<String, Object> params) throws Exception{
		return proposalMapper.list(params);
	}
	
	public List<HashMap<String, Object>> defList(HashMap<String, Object> params) throws Exception{
		return proposalMapper.defList(params);
	}
	
	public List<HashMap<String, Object>> costList(HashMap<String, Object> params) throws Exception{
		return proposalMapper.costList(params);
	}
	
	public HashMap<String, Object> select(HashMap<String, Object> params) throws Exception{
		return proposalMapper.select(params);
	}
	
	public HashMap<String, Object> program(HashMap<String, Object> params) throws Exception{
		return proposalMapper.program(params);
	}
	
	public List<HashMap<String, Object>> content(HashMap<String, Object> params) throws Exception{
		return proposalMapper.content(params);
	}
	
	public  HashMap<String, Object>  contCnt(HashMap<String, Object> params) throws Exception{
		return proposalMapper.contCnt(params);
	}
	
	public  HashMap<String, Object>  cnt(HashMap<String, Object> params) throws Exception{
		return proposalMapper.cnt(params);
	}
	
	public int create(HashMap<String, Object> params) throws Exception{
		return proposalMapper.create(params);
	}
	
	public int update(HashMap<String, Object> params) throws Exception{
		return proposalMapper.update(params);
	}
	
	public int delete(HashMap<String, Object> params) throws Exception{
		return proposalMapper.delete(params);
	}
	
}
