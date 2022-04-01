package com.our.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {

		
		return "home";
	}
	
	@RequestMapping(value="/sample/board")
	public String sampleBoard(Model model) {
		return "/sample/board";
	}
	
	@RequestMapping(value="/sample/blank")
	public String sampleBlank(Model model) {
		return "/sample/blank";
	}
}
