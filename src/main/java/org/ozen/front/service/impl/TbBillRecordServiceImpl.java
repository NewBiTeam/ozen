package org.ozen.front.service.impl;

import java.util.Map;

import org.ozen.core.util.ReMessage;
import org.ozen.front.dao.TbBillRecordMapper;
import org.ozen.front.entity.TbBillRecord;
import org.ozen.front.service.TbBillRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class TbBillRecordServiceImpl extends BaseServiceImpl<TbBillRecord> implements TbBillRecordService {

	@Autowired
	private TbBillRecordMapper billDao;

	@Autowired 
	public TbBillRecordServiceImpl(TbBillRecordMapper billDao){
		setBaseMapper(billDao, TbBillRecord.class);
	}
	
	@Override
	public ReMessage insert(Map<String,Object> map){
		ReMessage reMessage = new ReMessage();
		TbBillRecord tbRecord = getEntity(map);
		billDao.add(tbRecord);
		reMessage.setMessage("²Ù×÷³É¹¦£¡");
		return reMessage;
		}

}
