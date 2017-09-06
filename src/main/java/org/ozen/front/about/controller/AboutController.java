package org.ozen.front.about.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AboutController {

	@RequestMapping("/about")
	public ModelAndView index(Model model){
		return new ModelAndView("about/about");
	}
}
