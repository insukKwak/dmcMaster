package com.our.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("ExcelController")
@RequestMapping("/excel")
public class ExcelController {
	
	@RequestMapping("/example/download")
	public String excelDown(Model model) throws Exception{
		return "excel_example/download";
	}
	
	@RequestMapping("/example/upload")
	public String excelUpload(Model model) throws Exception{
		return "excel_example/upload";
	}
}
