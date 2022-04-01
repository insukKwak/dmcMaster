package com.our.project.service;

import java.util.List;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.our.project.mapper.BbsMapper;

@Service("BbsService")
public class BbsService {
	
	@Autowired
	BbsMapper bbsMapper;
	
	public List<HashMap<String, Object>> selectNoticeList(HashMap<String, Object> params) throws Exception{
		return bbsMapper.selectNoticeList(params);
	}
	
	public HashMap<String, Object> selectNotice(HashMap<String, Object> params) throws Exception{
		return bbsMapper.selectNotice(params);
	}
	
	public int insNotice(HashMap<String, Object> params) throws Exception{
		return bbsMapper.intNotice(params);
	}
	
	public int updNotice(HashMap<String, Object> params) throws Exception{
		return bbsMapper.updNotice(params);
	}
	
	public int delNotice(HashMap<String, Object> params) throws Exception{
		return bbsMapper.delNotice(params);
	}
}
