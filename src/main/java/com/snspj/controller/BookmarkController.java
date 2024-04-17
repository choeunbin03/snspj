package com.snspj.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.snspj.domain.BookmarkDTO;
import com.snspj.service.BookmarkService;

@Controller
@RequestMapping(value="/bookmark/*")
public class BookmarkController {
	
	@Inject
	private BookmarkService bookmarkService;
	
	@ResponseBody
	@RequestMapping(value="/bmkPlc", method=RequestMethod.POST)
	public void bmkPlc(Locale locale, Model model, @RequestBody String params, HttpSession session, HttpServletRequest request) throws Exception{
		String mbrId = (String)session.getAttribute("sessionId");
		Map<String, Object> bmkParam = new HashMap<>();	
		
		bmkParam.put("mbrId", mbrId);
		bmkParam.put("params", params);
		
		bookmarkService.bmkPlc(bmkParam);
	}
	
	@ResponseBody
	@RequestMapping(value="/bmkBbs", method=RequestMethod.POST)
	public void bmkBbs(Locale locale, Model model, HttpSession session, HttpServletRequest request) throws Exception{
		String mbrId = (String)session.getAttribute("sessionId");
		int bbsId = Integer.parseInt((String)request.getParameter("bbsId"));
		String funcType = (String)request.getParameter("funcType");
		
		Map<String, Object> params = new HashMap<>();			
		params.put("mbrId", mbrId);
		params.put("bbsId", bbsId);
		params.put("funcType", funcType);
		
		//bmk 되어있는지 체크
		if("add".equals(funcType)) {
			bookmarkService.addBmkBbs(params);
		}else {
			bookmarkService.removeBmkBbs(params);
		}

	}

}
