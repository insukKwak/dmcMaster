package com.our.project.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.our.project.core.model.ResponseCode;
import com.our.project.core.model.ResponseMessage;
import com.our.project.service.ProductService;
import com.our.project.service.ProposalService;

@Controller("ProposalController")
@RequestMapping("/prps")
public class ProposalController {
	
	@Autowired
	ProposalService proposalService;
	
	@RequestMapping("/reg/list")
	public String list(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> params) throws Exception{
		model.addAttribute("defList", proposalService.list(params));
		return "prps/def/list";
	}
	
	@RequestMapping("/def/list")
	public String defList(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> params) throws Exception{
		
		model.addAttribute("defList", proposalService.defList(params)); 
		return "prps/def/defList";
	}
	
	@RequestMapping("/def/form")
	public String form(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> params) throws Exception {
		//322122547488(1학기),322122547489(2학기)
		model.addAttribute("program", proposalService.program(params));
		model.addAttribute("content", proposalService.content(params));
		model.addAttribute("contCnt", proposalService.contCnt(params));
		return "prps/def/form";
	}
	
	@RequestMapping("/def/view")
	public String view(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> params) throws Exception{
		model.addAttribute("def", proposalService.select(params));
		model.addAttribute("program", proposalService.program(params));
		model.addAttribute("content", proposalService.content(params));
		model.addAttribute("contCnt", proposalService.contCnt(params));
		model.addAttribute("costList", proposalService.costList(params));
		return "prps/def/defForm";
	}
	
	@RequestMapping("/def/pop")
	public String pop(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> params) throws Exception{
		model.addAttribute("def", proposalService.select(params));
		model.addAttribute("program", proposalService.program(params));
		model.addAttribute("content", proposalService.content(params));
		model.addAttribute("contCnt", proposalService.contCnt(params));
		model.addAttribute("costList", proposalService.costList(params));
		return "prps/def/popForm";
	}
	
	
	@RequestMapping(value = {"/def/save"}, method= RequestMethod.POST)
	public String save(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> params) throws Exception{
		HashMap<String, Object> result = new HashMap<String, Object>();
		System.out.println("params : " +params);
		if(params.get("del").equals("Y")){
			proposalService.delete(params);
		}else {
			try {
				int cnt = proposalService.update(params);
				if(cnt == 0) {
					proposalService.create(params);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return "redirect:list";
			}
		}
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "/def/delete", method = RequestMethod.POST)
	public @ResponseBody ResponseMessage delete(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> params) throws Exception{
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		try {
			proposalService.delete(params);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseMessage("삭제에 실패하였습니다.", null).setCode(ResponseCode.FAIL);
		}
		return new ResponseMessage("삭제하였습니다", null).setData(result);
	}
	
}
