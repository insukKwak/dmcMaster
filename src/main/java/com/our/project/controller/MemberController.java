package com.our.project.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.our.project.core.security.Encrypt;
import com.our.project.core.util.FormatUtil;
import com.our.project.core.model.ResponseCode;
import com.our.project.core.model.ResponseMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.our.project.service.MemberService;


@Controller("MemberController")
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberService memberService;	
	
	@RequestMapping({"/login"})
	public String home(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> params) throws Exception {
		
		return "member/sign_in";
	}
	
	@RequestMapping(value ="/loginProc")
	@ResponseBody
	public ResponseMessage login(HttpServletRequest request, Model model, @RequestParam HashMap<String, Object> params, HttpServletRequest param) throws Exception{
		
		/*
		 * String user_Id = FormatUtil.toString(params.get("id")); MemberVo user =
		 * memberService.selectLogin(user_Id);
		 */
		
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		String userId = FormatUtil.toString(params.get("id"));
		String userPwd = FormatUtil.toString(params.get("password"));
		String userPwdSha256 = Encrypt.encodeSHA256(FormatUtil.toString(params.get("password")));
		String userPwdMD5 = Encrypt.encodeMD5(FormatUtil.toString(params.get("password")));
		String refer = FormatUtil.toString(params.get("refer"));
		boolean isLogined = false;

		if ("".equals(userId)) {
			return new ResponseMessage("아이디를 입력하여 주세요", refer).setCode(ResponseCode.FAIL_BAD_PARAM);
		}

		if ("".equals(userPwd)) {
			return new ResponseMessage("비밀번호를 입력하여 주세요.", refer).setCode(ResponseCode.FAIL_BAD_PARAM);
		}

		HashMap<String, Object> searchMap = new HashMap<String, Object>();
		searchMap.put("user_id", userId);
		searchMap.put("passwordSha256", userPwdSha256);
		searchMap.put("passwordMD5", userPwdMD5);
		searchMap.put("password", userPwd);
		
		List<HashMap<String, Object>> userList = memberService.selectLogin(searchMap);
		HashMap<String, Object> user = new HashMap<String, Object>();
		if (userList != null && userList.size() > 0 ) {
			user = userList.get(0);
		}
				
		if ( user == null || "".equals(FormatUtil.toString(user.get("USER_ID"))) ){
			return new ResponseMessage("아이디를 확인 해주세요.", refer).setCode(ResponseCode.FAIL_AUTH);
		
		}else if ( isLogined == false && !(userPwdSha256.equals(user.get("USER_PW")) || userPwd.equals(user.get("USER_PW"))) ){
			
			return new ResponseMessage("비밀번호를 확인 해주세요.", refer).setCode(ResponseCode.FAIL_AUTH);
		} else if ( user != null && userPwd.equals(user.get("USER_PW"))){
			
			
		
			user.remove("USER_PW");
			user.remove("ACCESS_IP");
			
			request.getSession().setAttribute("USER", user);
			
			result.put("USER_ID", user.get("USER_ID"));
			result.put("USER_NM", user.get("USER_NM"));
			result.put("USER_DEPT", user.get("USER_DT"));
			result.put("USER_TYPE", user.get("USER_TYPE"));
			result.put("USER_LV", user.get("USER_LV"));
		
		}else {
			return new ResponseMessage("아이디 또는 비밀번호를 확인하여 주세요.", refer).setCode(ResponseCode.FAIL);
		}		
		System.out.println("result : " +result);
		
		return new ResponseMessage("로그인 되었습니다.", refer).setData(result);		
	}
	
	@RequestMapping(value ="/loginCms")
	@ResponseBody
	public ResponseMessage loginCms(HttpServletRequest request, Model model, @RequestParam HashMap<String, Object> params, HttpServletRequest param) throws Exception{
		
		/*
		 * String user_Id = FormatUtil.toString(params.get("id")); MemberVo user =
		 * memberService.selectLogin(user_Id);
		 */
		
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		String userName = FormatUtil.toString(params.get("id"));
		String userPwd = FormatUtil.toString(params.get("password"));
		String userPwdSha512 = getSHA512(userPwd);
		String refer = FormatUtil.toString(params.get("refer"));
		boolean isLogined = false;
		

		if ("".equals(userName)) {
			return new ResponseMessage("아이디를 입력하여 주세요", refer).setCode(ResponseCode.FAIL_BAD_PARAM);
		}

		if ("".equals(userPwd)) {
			return new ResponseMessage("비밀번호를 입력하여 주세요.", refer).setCode(ResponseCode.FAIL_BAD_PARAM);
		}

		HashMap<String, Object> searchMap = new HashMap<String, Object>();
		searchMap.put("USERNAME", userName);
		searchMap.put("PASSWORD", userPwdSha512);
		
		List<HashMap<String, Object>> userList = memberService.login(searchMap);
		HashMap<String, Object> user = new HashMap<String, Object>();
		if (userList != null && userList.size() > 0 ) {
			user = userList.get(0);
		}
				
		if ( user == null || "".equals(FormatUtil.toString(user.get("USERNAME"))) ){
			return new ResponseMessage("아이디를 확인 해주세요.", refer).setCode(ResponseCode.FAIL_AUTH);
		
		}else if ( isLogined == false && !(userPwdSha512.equals(user.get("PASSWORD")) ) ){
			model.addAttribute("HTMLMessage",new ResponseMessage("비밀번호를 확인하여 주세요.", refer).setCode(ResponseCode.FAIL_AUTH));
			return new ResponseMessage("비밀번호를 확인 해주세요.", refer).setCode(ResponseCode.FAIL_AUTH);
		} else if ( user != null && userPwdSha512.equals(user.get("PASSWORD"))){
		
			user.remove("PASSWORD");
			user.remove("ACCESS_IP");
			
			List<HashMap<String, Object>> teamList = memberService.teamSelect(searchMap);
			HashMap<String, Object> team = new HashMap<String, Object>();
			if (teamList != null && teamList.size() > 0 ) {
				team = teamList.get(0);
			}
			
			HttpSession session = request.getSession(true);
			request.getSession().setAttribute("USER", user);
			request.getSession().setAttribute("TEAM", team);
			session.setAttribute("USER_ID", user.get("USERNAME"));
			session.setAttribute("USER_NM", user.get("REALNAME"));
			session.setAttribute("TEAM_NM", team.get("TEAMNAME"));
			session.setMaxInactiveInterval(30*60);
			session.getCreationTime();
			session.getLastAccessedTime();
			result.put("USER_ID", user.get("USERNAME"));
			result.put("USER_NM", user.get("REALNAME"));
			//result.put("USER_TYPE", user.get("USER_TYPE"));
		
		}else {
			model.addAttribute("HTMLMessage",new ResponseMessage("아이디 또는 비밀번호를 확인하여 주세요.", refer).setCode(ResponseCode.FAIL));
			
			return new ResponseMessage("아이디 또는 비밀번호를 확인하여 주세요.", refer).setCode(ResponseCode.FAIL);
		}		
		System.out.println("result : " +result);
		
		model.addAttribute("HTMLMessage", new ResponseMessage("로그인 되었습니다.", refer).setData(result));
		return new ResponseMessage("로그인 되었습니다.", refer).setData(result);		
	}

	@RequestMapping({"/logout"})
	public String logout(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> params) throws Exception {
		
		try{
			//로그아웃
			HashMap<String, Object> logMap = new HashMap<String, Object>(params);
			HttpSession session = request.getSession(false);
	

			String sessionId = session.getId();
			logMap.put("SESSION_ID", sessionId);
			logMap.clear();
			logMap = null;					
		}catch(Exception e){
			e.printStackTrace();
		}
		
		request.getSession().removeAttribute("USER");
		request.getSession().invalidate();
		
		System.out.println("logout");
		model.addAttribute("HTMLMessage", new ResponseMessage("로그아웃 되었습니다.", params.get("refer") + ""));

		return "redirect:/member/login";
	}
	
	
	public static String getSHA512(String input){

		String toReturn = null;

		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-512");
			digest.reset();
			digest.update(input.getBytes("utf8"));
			toReturn = String.format("%0128x", new BigInteger(1, digest.digest()));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return toReturn;
		
	}


}
