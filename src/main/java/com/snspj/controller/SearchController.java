package com.snspj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.snspj.domain.MemberDTO;
import com.snspj.service.SearchService;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value="/search/*")
public class SearchController {
	
	@Inject
	private SearchService srchService;
	
	@RequestMapping(value = "/srchArea", method = RequestMethod.GET)
	public String goSrchArea(Locale locale, Model model){
		return "/search/srchArea";
	}
	
	@RequestMapping(value = "/srchPrsn", method = RequestMethod.GET)
	public String srchPrsn(Locale locale, Model model, HttpServletRequest request) {
		
		String keyWd = (request.getParameter("keyWd")).substring(1);
		
		
		MemberDTO srchMbrInfo = srchService.getMbrInfo(keyWd);
		
		List bbsList = srchService.getMbrBbsList(keyWd);
		
		model.addAttribute("keyWd", keyWd);
		model.addAttribute("srchMbrInfo", srchMbrInfo);
		model.addAttribute("bbsList", bbsList);
		
		return "/search/srchPrsn";
	}
	
	@RequestMapping(value = "/srchPlc", method = RequestMethod.GET)
	public String srchPlc(Locale locale, Model model, HttpServletRequest request) {
		return "/search/srchPlc";
	}
	

}
