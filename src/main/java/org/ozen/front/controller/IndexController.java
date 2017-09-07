package org.ozen.front.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.ozen.core.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

//	@Autowired
//	private BlogService blogService;

	/**
	 * 
	 * @param model
	 * @param pageNow
	 *            当前页数
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView index(Model model , HttpServletRequest request) {
		Page page = null;
		String pageNow = request.getParameter("pageNow");
//		int totalCount = blogService.getCount();
//		if (pageNow != null && pageNow != "") {// 防止出现空指针异常
//			page = new Page(totalCount, Integer.parseInt(pageNow));// 这样写的好处，判断完成外面可以继续调用
//		}else{
//			page = new Page(totalCount, 1);
//		}
//		List<TbBlog> recomBlogList = blogService.getRecomBlog(page);
//		model.addAttribute("page", page);
//		model.addAttribute("recomBlogList", recomBlogList);
		return new ModelAndView("/index");
	}

}
