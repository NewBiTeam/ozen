package org.ozen.front.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ozen.core.base.BaseController;
import org.ozen.core.util.Constants;
import org.ozen.front.entity.TbUser;
import org.ozen.front.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class FrontLoginController extends BaseController {
	
//	@Autowired
//	private LoginService loginService;

	/**
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void doLogin(HttpServletRequest request, HttpServletResponse response) {
		String statusCode = SC_FAIL;
		TbUser user = new TbUser();
		String name = request.getParameter("username");
		String password = request.getParameter("password");
//		user.setLoginName(name);
//		user.setPassWord(Md5Utils.string2MD5(password));
//		TbUser use = loginService.login(user);
//		if (null != use) {
//			request.getSession().setAttribute(Constants.SESSION_LOGIN_USER, use);
//			logger.debug("用户登录成功：{}", user.getName());
//			statusCode = SC_OK;
//		}
		setJsonResult(statusCode, response);
	}

	/**
	 * @param request
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute(Constants.SESSION_LOGIN_USER);
		request.getSession().invalidate();
		return "redirect:/";
	}

}
