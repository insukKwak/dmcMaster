package com.our.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("ChartController")
@RequestMapping("/chart")
public class ChartController {

	@RequestMapping("/example/chart")
	public String exampleChart(Model model) throws Exception{
		return "chart_example/chart";
	}
}
