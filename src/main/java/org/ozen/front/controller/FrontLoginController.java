package org.ozen.front.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ozen.core.base.BaseController;
import org.ozen.core.util.Constants;
import org.ozen.core.util.Md5Utils;
import org.ozen.front.entity.TbUser;
import org.ozen.front.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class FrontLoginController extends BaseController {
	
	@Autowired
	private LoginService loginService;

	/**
	 * @param request
	 * @return
	 */
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public void doLogin(HttpServletRequest request, HttpServletResponse response) {
//		String statusCode = SC_FAIL;
//		TbUser user1 = new TbUser();
//		String name = request.getParameter("username");
//		String password = request.getParameter("password");
//		
//				user1.setUsername(name);
//		 		user1.setPassword(Md5Utils.string2MD5(password));
//		 		TbUser user = loginService.selectLogin(user1);
//		 		if (null != user) {
//		 			request.getSession().setAttribute(Constants.SESSION_LOGIN_USER, user);
//		 			logger.debug("用户名{}", user.getUsername());
//		 			statusCode = SC_OK;
//		 		}
//		setJsonResult(statusCode, response);
//	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody TbUser login(TbUser tbUser,HttpSession session){
		tbUser.setPassword(Md5Utils.string2MD5(tbUser.getPassword()));
		TbUser user = loginService.selectLogin(tbUser);
		if(user != null){
			session.setAttribute("user", user);
		}
		return user;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody void login(TbUser tbUser){
		loginService.add(tbUser);
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
