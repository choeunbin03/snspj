package com.snspj.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/kakao/*")
@RequiredArgsConstructor
public class KaKaoController {
//	restapi = c2d51170d1c01e3bdea69fc37be7c3d1
//	javascript = d8b839059cce4c79377c08d03ea18c5f
//	clientSecret = aoo09hHMVKqxh5sZuyxO90c5GyU10bFm

	private static final Logger logger = LoggerFactory.getLogger(KaKaoController.class);
	
	@Value("#{kakaoApi['restapi']}")
	private String restapi;
	@Value("#{kakaoApi['javascript']}")
	private String javascript;
	@Value("#{kakaoApi['clientSecret']}")
	private String clientSecret;

	@GetMapping("/searchByAddr")	
	public ModelAndView searchByAddr(Model model, @RequestParam String keyWd) throws Exception {
		Mono<String> mono = WebClient.builder().baseUrl("https://dapi.kakao.com")
		.build().get()
		.uri(builder -> builder.path("/v2/local/search/keyword.json")
			.queryParam("query", keyWd)
			.build()
		)
		.header("Authorization", "KakaoAK " + restapi)
		.exchangeToMono(response -> {
			return response.bodyToMono(String.class);
		});
	
		
		String object = mono.block();
		JSONParser jsonParser = new JSONParser(); 
		JSONObject jsonObject = (JSONObject)jsonParser.parse(object);
		
		JSONArray documents = (JSONArray)jsonObject.get("documents");//JSONArray cannot be cast to org.json.simple.JSONObject 오류: document가 array 형식으로 되어있어서
		
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		JSONArray jsonResult = new JSONArray();
		
		for(Object docObject : documents) {
			Map<String, Object> srchResult = new HashMap<>();
			JSONObject jsonObjectPlc = (JSONObject)docObject;
			
			String place_name= (String)jsonObjectPlc.get("place_name");
			String phone= (String)jsonObjectPlc.get("phone");			
			String address_name= (String)jsonObjectPlc.get("address_name");
			String road_address_name= (String)jsonObjectPlc.get("road_address_name");
			String x= (String)jsonObjectPlc.get("x");
			String y= (String)jsonObjectPlc.get("y");
			
			srchResult.put("place_name", place_name);
			srchResult.put("phone", phone);
			srchResult.put("address_name", address_name);
			srchResult.put("road_address_name", road_address_name);
			srchResult.put("x", x);
			srchResult.put("y", y);
			
			resultList.add(srchResult);
			jsonResult.add(srchResult);
			
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("keyWd", keyWd);
		mav.addObject("resultList", resultList);
		mav.addObject("jsonResult", jsonResult.toJSONString());
		mav.setViewName("/search/srchPlc");
		return mav; 
	}
	

}
