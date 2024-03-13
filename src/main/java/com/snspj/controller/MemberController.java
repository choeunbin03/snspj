package com.snspj.controller;

import java.io.File;
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
		
		
		//파일 저장 위치는 프로젝트 외부에 폴더 생성하여 거기에 저장. 또한 경로는 절대경로!
		//String webPath = "resources\\upload\\memberProfile\\";
		//String folderPath = "D:\\PJ\\JSP_SNS_PJ\\workspace\\snspj\\src\\main\\webapp\\resources\\upload\\memberProfile\\";
		
		String folderPath = "D:\\PJ\\JSP_SNS_PJ\\upload\\memberProfile\\";
		
		//프로필 이미지와 게시물 첨부파일은 따로
		//프로필 이미지 이름: 회원가입 아이디
		
		try {
			if(!fileupload.isEmpty()) {
				String orgFileNm = fileupload.getOriginalFilename();
				String uploadFileName = memberDto.getMbrId() + orgFileNm.substring(orgFileNm.indexOf('.'));
				
				File saveFile = new File(folderPath, uploadFileName);
				fileupload.transferTo(saveFile);
				memberDto.setMbrProflPath(uploadFileName);
			}
			
		}catch(Exception e) {
			memberDto.setMbrProflPath(null);
		}
		
		result = memberService.join(memberDto);//주소란 정보가 하나라도 null이면 그냥 null값 저장.
		
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
