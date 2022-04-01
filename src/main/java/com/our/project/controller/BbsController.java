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
import com.our.project.service.BbsService;

@Controller("BbsController")
@RequestMapping("/bbs")
public class BbsController {
	
	@Autowired
	BbsService bbsService;
	
	@RequestMapping("/notice/list")
	public String noticeList(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> params) throws Exception{
		model.addAttribute("noticeList", bbsService.selectNoticeList(params));
		return "bbs/notice/list";
	}
	
	@RequestMapping("/notice/view")
	public String noticeView(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> params) throws Exception{
		model.addAttribute("notice", bbsService.selectNotice(params));
		return "bbs/notice/form";
	}
	
	@RequestMapping("/notice/form")
	public String insForm() {
		return "bbs/notice/form";
	}
	
	@RequestMapping(value = "/notice/edit", method = RequestMethod.POST)
	public @ResponseBody ResponseMessage editNotice(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> params) throws Exception{
		HashMap<String, Object> result = new HashMap<String, Object>();
		System.out.println("params : " +params);
		try {
			int cnt = bbsService.updNotice(params);
			if(cnt == 0) {
				bbsService.insNotice(params);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseMessage("저장에 실패하였습니다.", null).setCode(ResponseCode.FAIL);
		}
		return new ResponseMessage("저장되었습니다.", null).setData(result);
	}
	
	@RequestMapping(value = "/notice/delete", method = RequestMethod.POST)
	public @ResponseBody ResponseMessage deleteNotice(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> params) throws Exception{
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		try {
			bbsService.delNotice(params);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseMessage("삭제에 실패하였습니다.", null).setCode(ResponseCode.FAIL);
		}
		return new ResponseMessage("삭제하였습니다", null).setData(result);
	}
}
