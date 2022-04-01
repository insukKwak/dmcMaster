package com.our.project.mapper;

import com.our.project.core.annotation.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface BbsMapper {
	
	public List<HashMap<String, Object>> selectNoticeList(HashMap<String, Object> params) throws Exception;
	
	public HashMap<String, Object> selectNotice(HashMap<String, Object> params) throws Exception;
	
	public int intNotice(HashMap<String, Object> params) throws Exception;
	
	public int updNotice(HashMap<String, Object> params) throws Exception;
	
	public int delNotice(HashMap<String, Object> params) throws Exception;
	
}
