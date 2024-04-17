package com.snspj.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.snspj.domain.MemberDTO;
import com.snspj.service.BookmarkService;
import com.snspj.service.SearchService;
import com.snspj.service.SptService;
import com.snspj.util.FileUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value="/search/*")
public class SearchController {
	
	@Inject
	private SearchService srchService;
	@Inject
	private SptService sptService;
	@Inject
	private BookmarkService bookmarkService;
	
	@RequestMapping(value = "/srchArea", method = RequestMethod.GET)
	public String goSrchArea(Locale locale, Model model){
		return "/search/srchArea";
	}
	
	@RequestMapping(value = "/srchPrsn", method = RequestMethod.GET)
	public ModelAndView srchPrsn(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		String keyWd = (request.getParameter("keyWd")).substring(1);
		String mbrId = (String)session.getAttribute("sessionId");	
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("keyWd", keyWd);
		params.put("mbrId", mbrId);
		
		ModelAndView mv = new ModelAndView();
		
		//검색 상대 프로필 정보
		MemberDTO srchMbrInfo = srchService.getMbrInfo(keyWd);
		//팔로우 여부 체크
		
		
		//검색 상대의 게시글 리스트
		List bbsList = srchService.getMbrBbsList(keyWd);
		//좋아요 여부 체크
		List sptYn = sptService.sptYnSrch(params);
		//북마크 여부 체크
		List bmkYn = bookmarkService.bmkYnSrch(params);

		mv.setViewName("/search/srchPrsn");
		mv.addObject("keyWd", keyWd);
		mv.addObject("srchMbrInfo", srchMbrInfo);
		mv.addObject("bbsList", bbsList);
		mv.addObject("sptYn", sptYn);
		mv.addObject("bmkYn", bmkYn);
		
		return mv;
	}
	
	@RequestMapping(value = "/display", method = RequestMethod.GET)
	public ResponseEntity<byte[]> display(@RequestParam("path") String profilePath) throws IOException {
		
		ResponseEntity<byte[]> result = null;
		String path = "D:\\PJ\\JSP_SNS_PJ\\upload\\memberProfile\\";
		
		if(profilePath == "") {
			profilePath = "default_profile_img.png";
		}
		
		File file = new File(path+profilePath);
		HttpHeaders header = new HttpHeaders();
		Path filePath = null;
		try{
			filePath = Paths.get(path+profilePath);
			header.add("Content-type", Files.probeContentType(filePath));
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file),header,HttpStatus.OK);
		}catch(IOException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return result;
	}
	
	@RequestMapping(value = "/srchPlc", method = RequestMethod.GET)
	public String srchPlc(Locale locale, Model model, HttpServletRequest request) {
		return "/search/srchPlc";
	}
	

}
