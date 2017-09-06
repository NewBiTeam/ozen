package org.ozen.front.mood.controller;

import javax.servlet.http.HttpServletRequest;

import org.ozen.core.base.BaseController;
import org.ozen.front.mood.service.MoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MoodController extends BaseController {

	@Autowired
	private MoodService moodService;

	@RequestMapping("/mood")
	public ModelAndView moodList(Model model, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
//		ForPage forPage = new ForPage();
//		Page page = null;
//		String userId = "";
//		TbUser tbUser = (TbUser) request.getSession().getAttribute(Constants.SESSION_LOGIN_USER);
//		if (null != tbUser) {
//			userId = tbUser.getId();
//			String pageNow = request.getParameter("pageNow");
//			int totalCount = blogService.getCountByUserId(userId);
//			if (pageNow != null && pageNow != "") {// 防止出现空指针异常
//				page = new Page(totalCount, Integer.parseInt(pageNow));// 这样写的好处，判断完成外面可以继续调用
//			} else {
//				page = new Page(totalCount, 1);
//			}
//			forPage.setPage(page);
//			forPage.setUserId(userId);
//			List<TbBlog> blogList = blogService.getBlogByUserId(forPage);
//			model.addAttribute("page", page);
//			model.addAttribute("blogList", blogList);
//			mv.setViewName("mood/mood");
//		} else {
//			mv.setViewName("redirect:/");
//		}
		return mv;
	}

}
