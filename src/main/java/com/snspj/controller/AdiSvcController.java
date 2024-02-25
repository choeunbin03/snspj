package com.snspj.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.snspj.service.BookmarkService;

@Controller
public class AdiSvcController {
	
	@Inject
	private BookmarkService bookmarkService;
	
	@RequestMapping(value="/adiSvc/adiSvcMain", method=RequestMethod.GET)
	public String adiSvcMain(Locale locale, Model model, HttpSession session) {
		//저장 top기능
		List<String> bmkTop = bookmarkService.bmkTop();
		int bmkTopShowCnt = 3;
		
		List<Map<String, Object>> bmkTopList = new ArrayList<Map<String, Object>>();
		JSONParser jsonParser = new JSONParser(); 
		
		try {
			for(int i = 0; i < bmkTopShowCnt; i++) {
				Map<String, Object> bmkResult = new HashMap<>();
				String tmp = bmkTop.get(i);				
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
				
				bmkTopList.add(bmkResult);
			}
				
		} catch (ParseException e) {
				e.printStackTrace();
		}	
		
		model.addAttribute("bmkTopList", bmkTopList);
		
		return "/adiSvc/adiSvcMain";
	}
	
	@RequestMapping(value="/adiSvc/bmkTop", method=RequestMethod.GET)
	public String bmkTop(Locale locale, Model model) {
		List<String> bmkTopJsonString = bookmarkService.bmkTop();
		
		List<Map<String, Object>> bmkTopList = new ArrayList<Map<String, Object>>();
		JSONParser jsonParser = new JSONParser(); 
		
		int i = 0;
		try {
			for(Object object: bmkTopJsonString) {
				Map<String, Object> bmkResult = new HashMap<>();
				String tmp = bmkTopJsonString.get(i);				
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
				
				bmkTopList.add(bmkResult);
				i++;
			}
		}catch(ParseException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("bmkTopList", bmkTopList);
		model.addAttribute("bmkTopJsonString", bmkTopJsonString);
		
		return "/adiSvc/bmkTop";
	}
}
