package org.ozen.front.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.ozen.core.util.ReMessage;
import org.ozen.front.entity.TbUser;
import org.ozen.front.service.BaseService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;




@SessionAttributes("user")
public class BaseController<T> {

	Logger logger = Logger.getLogger(BaseController.class);

	private BaseService<T> baseService;

	public void setBaseService(BaseService<T> baseService) {
		this.baseService = baseService;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> add(@ModelAttribute("user") TbUser user,@RequestParam Map<String, Object> map) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		ReMessage reMessage = new ReMessage();
		try {
			map.put("userId", user.getUserId());
			reMessage=baseService.insert(map);
			modelMap.put("reMessage", reMessage);
		} catch (Exception e) {
			reMessage.setError(true);
			reMessage.setMessage("操作失败！");
			modelMap.put("reMessage", reMessage);
			e.printStackTrace();
		}
		return modelMap;
	}
}
