package com.our.project.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.our.project.core.annotation.Mapper;
import com.our.project.vo.ApiAttr;
import com.our.project.vo.ConfigApi;

@Mapper
public interface ConfigMapper {
	
	public List<ConfigApi> apiList() throws Exception; //�Խñ� �Ǽ� ��ȸ
	public void create(ConfigApi api);
	public void update(ConfigApi api);
	public void createAttr(ApiAttr attr);
	public void deleteAttr(String apiId);
	public void createDdl(String sql) throws Exception;
	public void insertSql(String insetSql);
	public List<HashMap<String, Object>> readTable(HashMap<String, Object> params);
	public int checkTable(String tableNm); 
	public int checkColumn(HashMap<String, Object> map); 
	public ConfigApi retrieve(String apiId) ;
	public List<HashMap<String,Object>> retrieveAttr(String apiId) ;
}
