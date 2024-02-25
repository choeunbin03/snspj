package com.snspj.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.snspj.service.BookmarkService;

@Controller
public class MapController {
	
	@Inject
	private BookmarkService bookmarkService;
	
	@RequestMapping(value = "/map/mapView", method = RequestMethod.GET)
	public String mapView(Locale locale, Model model, HttpSession session) {	
		//카테고리 이름 list 가져오기.
		String mbrId = (String)session.getAttribute("sessionId");
		Map<String, Object> param = new HashMap<>();
		param.put("mbrId", mbrId);
		
		List<String> ctgryNmList = bookmarkService.getCtgryNmList(param);
		
		List<String> bmkPlc = bookmarkService.getBmkPlc(param);
		
		model.addAttribute("ctgryNmList", ctgryNmList);
		model.addAttribute("bmkPlc", bmkPlc);
		return "/map/mapView";
	}
	
	@RequestMapping(value = "/map/bmkListByCtgry", method = RequestMethod.GET)
	public String BmkListByCtgry(Locale locale, Model model, HttpSession session, HttpServletRequest request) {	
		//카테고리 이름 list 가져오기.
		String mbrId = (String)session.getAttribute("sessionId");
		String ctgryNm =(String)request.getParameter("ctgryNm");
		Map<String, Object> param = new HashMap<>();
		param.put("mbrId", mbrId);
		param.put("ctgryNm", ctgryNm);
		
		//사용자가 북마크 한 장소 리스트 전체 가져오기
		List<String> bmkPlc = bookmarkService.getBmkPlc(param);
		
		//사용자가 북마크 한 장소 중 선택한 카테고리에 해당되는 장소 목록 가져오기
		List<String> bmkListByCtgry = bookmarkService.bmkListByCtgry(param);
		
		List<Map<String, Object>> bmkList = new ArrayList<Map<String, Object>>();
		JSONParser jsonParser = new JSONParser(); 
		//JSONArray documents = (JSONArray)jsonParser.parse(bmkListByCtgry);
		
		try {
			for(int i = 0; i < bmkListByCtgry.size(); i++) {
				Map<String, Object> bmkResult = new HashMap<>();
				String tmp = bmkListByCtgry.get(i);				
				JSONObject jsonObject = (JSONObject)jsonParser.parse(tmp);
				
				String place_name= (String)jsonObject.get("place_name");
				String phone= (String)jsonObject.get("phone");			
				String address_name= (String)jsonObject.get("address_name");
				String road_address_name= (String)jsonObject.get("road_address_name");
				String x= (String)jsonObject.get("x");
				String y= (String)jsonObject.get("y");
				
				bmkResult.put("place_name", place_name);
				bmkResult.put("phone", phone);
				bmkResult.put("address_name", address_name);
				bmkResult.put("road_address_name", road_address_name);
				bmkResult.put("x", x);
				bmkResult.put("y", y);
				
				bmkList.add(bmkResult);
			}
				
		} catch (ParseException e) {
				e.printStackTrace();
		}		
		
		model.addAttribute("bmkList", bmkList);
		model.addAttribute("bmkPlc", bmkPlc);
		return "/map/mapViewBmkList";
	}
}
