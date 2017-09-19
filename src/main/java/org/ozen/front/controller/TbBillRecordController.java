package org.ozen.front.controller;

import java.util.Map;

import org.ozen.front.entity.TbBillRecord;
import org.ozen.front.service.TbBillRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("bill/*")
public class TbBillRecordController extends BaseController<TbBillRecord>{

	@Autowired private TbBillRecordService billService;
	
	@Autowired TbBillRecordController(TbBillRecordService billService){
		setBaseService(billService);
	}
	
//	@RequestMapping(value = "/add" , method = RequestMethod.POST)
//	public @ResponseBody void insertBill(TbBillRecord tbRecord){
//		billService.insert(tbRecord);
//	}
}
