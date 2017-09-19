package org.ozen.front.service;

import java.util.List;
import java.util.Map;

import org.ozen.core.util.ReMessage;
import org.ozen.front.dao.BaseMapper;

public interface BaseService<T> {

	void setBaseMapper(BaseMapper<T> baseDao,Class<T> tClass);
	
	List<T> query(Map<String,Object> map);
	
	ReMessage insert(Map<String,Object> map);
	
	ReMessage delete(Map<String,Object> map);
	
	ReMessage update(Map<String,Object> map);
	
	T detail(Map<String,Object> map);
	
	T getEntity(Map<String,Object> map);
	
}
