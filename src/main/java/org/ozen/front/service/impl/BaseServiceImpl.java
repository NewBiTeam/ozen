package org.ozen.front.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.ozen.core.util.MapToEntity;
import org.ozen.core.util.ReMessage;
import org.ozen.front.dao.BaseMapper;
import org.ozen.front.service.BaseService;

public class BaseServiceImpl<T> implements BaseService<T>{

	Logger logger = Logger.getLogger(BaseServiceImpl.class);
	
	private BaseMapper<T> baseDao;
	
	private T t;
	
	private Class<T> tClass;
	
	public void setBaseMapper(BaseMapper<T> baseDao,Class<T> tClass){
		this.baseDao = baseDao;
		this.tClass = tClass;
	}

	public List<T> query(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	public ReMessage insert(Map<String, Object> map) {
		ReMessage reMessage = new ReMessage();
		MapToEntity<T> mapToEntity = new MapToEntity<T>(tClass,map);
		t = (T) mapToEntity.getEntity();
		if(t != null){
			try {
				this.baseDao.add(t);
				reMessage.setMessage("新增成功");
			} catch (Exception e) {
				reMessage.isError = true;
				e.printStackTrace();
			}
		}else{
			reMessage.isError = true;
		}
		return reMessage;
	}

	public ReMessage delete(Map<String, Object> map) {
		
		return null;
	}

	public ReMessage update(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	public T detail(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getEntity(Map<String, Object> map) {
		MapToEntity<T> mapToEntity = new MapToEntity<T>(tClass,map);
		t = (T) mapToEntity.getEntity();
		return t;
	}

}
