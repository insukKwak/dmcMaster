package com.our.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

import com.our.project.service.MyFitnessService;

@Controller("MyFitnessController")
@RequestMapping("/myFitness")
public class MyFitnessController {

	@Autowired
	MyFitnessService myFitnessService;
	
	@RequestMapping("/list")
	public String userList(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> params) throws Exception{
		
		model.addAttribute("userList", myFitnessService.selectUserList(params));
		return "fitness/list";
	} 
	
	@RequestMapping("/view")
	public String myFitness(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> params) throws Exception{
		
		model.addAttribute("myFitness", myFitnessService.selectMyFitness(params));
		return "fitness/form";
	}
}
