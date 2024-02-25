package com.snspj.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.snspj.domain.MemberDTO;
import com.snspj.service.MemberService;

@Controller
public class MemberController {
	
	@Inject
	private MemberService memberService;
	
	@ResponseBody
	@RequestMapping(value="/member/login", method=RequestMethod.POST)
	public String login(Locale locale, Model model, MemberDTO memberDto, HttpSession session)throws Exception{
		MemberDTO user = memberService.login(memberDto);
		
		if(memberDto != null) {
			String loginMbrId = user.getMbrId();
			session.setAttribute("sessionId", loginMbrId);
			return "Y";
		}else {
			return "N";
		}
	}
	
	@RequestMapping(value="/member/join", method=RequestMethod.GET)
	public String goJoin(Locale locale, Model model) throws Exception {
		return "/member/join";
	}
	
	@RequestMapping(value="/popup/jusoPopup", method=RequestMethod.GET)
	public String goPopup(Locale locale, Model model) throws Exception {
		return "/popup/jusoPopup";
	}
	
	@ResponseBody
	@RequestMapping(value="/member/join/idDpcnChk", method=RequestMethod.POST)
	public String idDpcnChk(Locale locale, Model model, MemberDTO memberDto, HttpServletRequest request)throws Exception{
		String result = "";
		String mbrId =(String)request.getParameter("mbrId");
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("mbrId", mbrId);
		
		boolean chkVal = memberService.idDpcnChk(param);
		if(chkVal==true) {
			result = "ok";
		}else {
			result = "fail";
		}
		return result;
	}	

	@ResponseBody
	@RequestMapping(value="/member/join", method=RequestMethod.POST)
	public String postJoin(Locale locale, Model model, MemberDTO memberDto,
							@RequestParam("fileupload")MultipartFile fileupload, HttpServletRequest request) throws Exception {
		int result = -1;
		
		String webPath = "/resources/images/memberProfile/";
		
		String folderPath = request.getSession().getServletContext().getRealPath(webPath);
		//프로필 이미지와 게시물 첨부파일은 따로??
		//	프로필: tb_mbr에 atch_no 대신 atch_path로 저장?(왜냐면 프로필은 하나,,)
			//	https://yjdawn.tistory.com/151
		//	게시물: 따로
		
		
		result = memberService.join(memberDto);
		
		if( result == 1) {
			return "Y";
		}else {
			return "N";
		}
	}
	
	@RequestMapping(value="/popup/jusoPopup", method=RequestMethod.POST)
	public String goPopup2(Locale locale, Model model) throws Exception {
		return "/popup/jusoPopup";
	}
	
	@RequestMapping(value="/member/logout", method=RequestMethod.GET)
	public String logout(Locale locale, Model model, HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "/member/login";
	}

}
