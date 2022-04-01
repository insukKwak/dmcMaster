package com.our.project.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.our.project.mapper.MemberMapper;

@Service("memberService")
public class MemberService {
	@Autowired
	MemberMapper memberMapper;
	
	public List<HashMap<String, Object>> selectLogin(HashMap<String, Object> params) throws Exception{
		return memberMapper.selectLogin(params);
	}
	
	public List<HashMap<String, Object>> login(HashMap<String, Object> params) throws Exception{
		return memberMapper.login(params);
	}
	
	public List<HashMap<String, Object>> teamSelect(HashMap<String, Object> params) throws Exception{
		return memberMapper.teamSelect(params);
	}
}
