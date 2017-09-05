package org.ozen.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONObject;

public class BaseController {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	/**成功*/
	public static final String SC_OK = "success";
	/**失败*/
	public static final String SC_FAIL = "fail";
	/**
	 * 输出字符串到前台
	 * @param json
	 * @param response
	 */
	public void setJsonResult(String json, HttpServletResponse response){
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 返回对象到前台
	 * @param statusCode
	 * @param result
	 * @param response
	 */
	public void setJsonResult(String statusCode, Object result, HttpServletResponse response){
		response.setContentType("text/html;charset=UTF-8");
		try {
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("statusCode", statusCode);
			resultMap.put("result", result);
			response.getWriter().write(JSONObject.fromObject(resultMap).toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
