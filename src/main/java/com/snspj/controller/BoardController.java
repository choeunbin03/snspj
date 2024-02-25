package com.snspj.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.snspj.domain.BoardDTO;
import com.snspj.domain.FollowDTO;
import com.snspj.service.BoardService;
import com.snspj.service.FollowService;

@Controller
@RequestMapping(value="/board/*")
public class BoardController {
	
	@Inject
	private BoardService boardService;
	/*@Inject
	private CmntService cmntService;*/
	@Inject
	private FollowService followService;

	@RequestMapping(value = "/board/bbsList", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpSession session) {
		
		String mbrId = (String)session.getAttribute("sessionId");
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("mbrId", mbrId);
		
		List bbsList = boardService.getBbsList(params);
		
		model.addAttribute("bbsList", bbsList);
		
		return "/board/bbsList";
	}
	
	@RequestMapping(value = "/bbsView", method = RequestMethod.GET)
	public String goBbsView(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String mbrId = (String)session.getAttribute("sessionId");
		int bbsId = Integer.parseInt((String)request.getParameter("bbsId"));
		
		BoardDTO bbsView = boardService.getBbsView(bbsId);
		model.addAttribute("bbsView", bbsView);
		
		return "/board/bbsView";
	}
}
	
