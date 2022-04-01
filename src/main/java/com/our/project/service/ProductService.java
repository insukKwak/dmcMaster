package com.our.project.service;

import java.util.List;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.our.project.mapper.ProductMapper;

@Service("ProductService")
public class ProductService {
	
	@Autowired
	ProductMapper productMapper;
	
	public List<HashMap<String, Object>> list(HashMap<String, Object> params) throws Exception{
		return productMapper.list(params);
	}
	
	public HashMap<String, Object> select(HashMap<String, Object> params) throws Exception{
		return productMapper.select(params);
	}
	
	public  HashMap<String, Object>  cnt(HashMap<String, Object> params) throws Exception{
		return productMapper.cnt(params);
	}
	
	public int create(HashMap<String, Object> params) throws Exception{
		return productMapper.create(params);
	}
	
	public int update(HashMap<String, Object> params) throws Exception{
		return productMapper.update(params);
	}
	
	public int delete(HashMap<String, Object> params) throws Exception{
		return productMapper.delete(params);
	}
	
	public List<HashMap<String, Object>> depthList(HashMap<String, Object> params) throws Exception{
		return productMapper.depthList(params);
	}
	
	public List<HashMap<String, Object>> custList(HashMap<String, Object> params) throws Exception{
		return productMapper.list(params);
	}
	
	public HashMap<String, Object> custSelect(HashMap<String, Object> params) throws Exception{
		return productMapper.select(params);
	}
	
	public  HashMap<String, Object> custCnt(HashMap<String, Object> params) throws Exception{
		return productMapper.cnt(params);
	}
	
	public int custCreate(HashMap<String, Object> params) throws Exception{
		return productMapper.create(params);
	}
	
	public int custUpdate(HashMap<String, Object> params) throws Exception{
		return productMapper.update(params);
	}
	
	public int custDelete(HashMap<String, Object> params) throws Exception{
		return productMapper.delete(params);
	}
	
	public List<HashMap<String, Object>> apprList(HashMap<String, Object> params) throws Exception{
		return productMapper.apprList(params);
	}
}
