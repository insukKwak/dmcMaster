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

@Controller("ProductController")
@RequestMapping("/prdt")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping("/cost/list")
	public String list(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> params) throws Exception{
		model.addAttribute("prdtCostList", productService.list(params));
		return "prdt/cost/list";
	}
	
	@RequestMapping("/cost/form")
	public String form(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> params) throws Exception {
		model.addAttribute("depthlist", productService.depthList(params));
		return "prdt/cost/form";
	}
	
	@RequestMapping("/cost/view")
	public String view(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> params) throws Exception{
		model.addAttribute("depthlist", productService.depthList(params));
		model.addAttribute("cost", productService.select(params));
		return "prdt/cost/form";
	}
	
	@RequestMapping(value = {"/cost/save"}, method= RequestMethod.POST)
	public String save(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> params) throws Exception{
		HashMap<String, Object> result = new HashMap<String, Object>();
		System.out.println("params : " +params);
		if(params.get("del").equals("Y")){
			productService.delete(params);
		}else {
			try {
				int cnt = productService.update(params);
				if(cnt == 0) {
					productService.create(params);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return "redirect:list";
			}
		}
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "/cost/delete", method = RequestMethod.POST)
	public @ResponseBody ResponseMessage delete(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> params) throws Exception{
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		try {
			productService.delete(params);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseMessage("삭제에 실패하였습니다.", null).setCode(ResponseCode.FAIL);
		}
		return new ResponseMessage("삭제하였습니다", null).setData(result);
	}
	
	@RequestMapping("/cust/list")
	public String custList(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> params) throws Exception{
		model.addAttribute("prdtCustList", productService.custList(params));
		return "prdt/cust/list";
	}
	
	@RequestMapping("/cust/form")
	public String custForm(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> params) throws Exception {
		model.addAttribute("depthlist", productService.depthList(params));
		return "prdt/cust/form";
	}
	
	@RequestMapping("/cust/view")
	public String custView(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> params) throws Exception{
		model.addAttribute("depthlist", productService.depthList(params));
		model.addAttribute("cu st", productService.custSelect(params));
		return "prdt/cust/form";
	}
	
	@RequestMapping(value = {"/cust/save"}, method= RequestMethod.POST)
	public String custSave(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> params) throws Exception{
		HashMap<String, Object> result = new HashMap<String, Object>();
		System.out.println("params : " +params);
		if(params.get("del").equals("Y")){
			productService.custDelete(params);
		}else {
			try {
				int cnt = productService.custUpdate(params);
				if(cnt == 0) {
					productService.custCreate(params);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return "redirect:list";
			}
		}
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "/cust/delete", method = RequestMethod.POST)
	public @ResponseBody ResponseMessage custDelete(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> params) throws Exception{
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		try {
			productService.custDelete(params);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseMessage("삭제에 실패하였습니다.", null).setCode(ResponseCode.FAIL);
		}
		return new ResponseMessage("삭제하였습니다", null).setData(result);
	}
	
	@RequestMapping("/appr/list")
	public String apprList(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> params) throws Exception{
		model.addAttribute("apprList", productService.apprList(params));
		return "prdt/appr/list";
	}
	
}
