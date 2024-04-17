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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.snspj.domain.AtchFileDTO;
import com.snspj.domain.BoardDTO;
import com.snspj.domain.FollowDTO;
import com.snspj.service.AtchFileService;
import com.snspj.service.BoardService;
import com.snspj.service.BookmarkService;
import com.snspj.service.FollowService;
import com.snspj.service.SptService;

@Controller
@RequestMapping(value="/board/*")
public class BoardController {
	
	@Inject
	private BoardService boardService;
	/*@Inject
	private CmntService cmntService;*/
	@Inject
	private FollowService followService;
	@Inject
	private SptService sptService;
	@Inject
	private BookmarkService bookmarkService;
	@Inject
	private AtchFileService atchFileService;

	@RequestMapping(value = "/bbsList", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpSession session) {
		
		String mbrId = (String)session.getAttribute("sessionId");		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("mbrId", mbrId);
		
		//게시글 리스트 가져오기
		List bbsList = boardService.getBbsList(params);
		
		//첨부파일 목록 가져오기.
		List<List<AtchFileDTO>> fileList = atchFileService.getFileList(params);
		
		//좋아요 여부 체크
		List sptYn = sptService.sptYnBbsList(params);

		//북마크 여부 체크
		List bmkYn = bookmarkService.bmkYnBbsList(params);
		
		model.addAttribute("bbsList", bbsList);
		model.addAttribute("fileList", fileList);
		model.addAttribute("sptYn", sptYn);
		model.addAttribute("bmkYn", bmkYn);
		
		return "/board/bbsList";
	}
	
	@RequestMapping(value = "/bbsView", method = RequestMethod.GET)
	public String goBbsView(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String mbrId = (String)session.getAttribute("sessionId");
		int bbsId = Integer.parseInt((String)request.getParameter("bbsId"));
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("mbrId", mbrId);
		
		//상세페이지 정보 가져오기
		BoardDTO bbsView = boardService.getBbsView(bbsId);
		
		//좋아요 여부 체크
		List sptYn = sptService.sptYnBbsList(params);
		//나중에 수정. 왜냐면 db쿼리가 돌아가는 게 너무 비효율. 얘는 따로 작성해야함.

		//북마크 여부 체크
		List bmkYn = bookmarkService.bmkYnBbsList(params);
		
		model.addAttribute("bbsView", bbsView);
		model.addAttribute("sptYn", sptYn);
		model.addAttribute("bmkYn", bmkYn);
		
		return "/board/bbsView";
	}
	
	@ResponseBody
	@RequestMapping(value = "/updateBbsSpt", method = RequestMethod.POST)
	public String updateBbsSpt(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String mbrId = (String)session.getAttribute("sessionId");
		int bbsId = Integer.parseInt((String)request.getParameter("bbsId"));
		String funcType = (String)request.getParameter("funcType");
		boolean bbsSptYn = false;
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("bbsId", bbsId);
		params.put("mbrId", mbrId);
		params.put("funcType", funcType);
			
		if("add".equals(funcType)) {
			sptService.addBbsSpt(bbsId);
			sptService.addSpt(params);
		}else {
			sptService.removeBbsSpt(bbsId);
			sptService.removeSpt(params);
		}
		
		return "OK";
	}
	
	@RequestMapping(value = "/regiBbs", method = RequestMethod.GET)
	public String goRegiBbs(Locale locael, Model model) {
		return "/board/bbsRegi";
	}
	
	@ResponseBody
	@RequestMapping(value = "/regiBbs", method = RequestMethod.POST)
	public String regiBbs(Locale locael, Model model,  BoardDTO boardDto, HttpSession session,
			@RequestPart(value = "fileupload",required = false) List<MultipartFile> fileList) throws Exception {
		String mbrId = (String)session.getAttribute("sessionId");
		int atchFileNo = 0;
			
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("mbrId", mbrId);
//		params.put("boardDto", boardDto);
		
		if(fileList != null) {
			//첨부파일 대표번호 max + 1 가져오기.
			atchFileNo = atchFileService.getMaxAtchFileNo() + 1;
			params.put("atchFileNo", atchFileNo);
			
			//첨부파일 s3에 업로드
			List<Map<String, Object>> filesInfo = atchFileService.submitFiles(fileList);
			params.put("filesInfo", filesInfo);
			
			//첨부파일들은 atchfile에 정보 저장.
			atchFileService.saveInfo(params);
		}
		
		//bbs tb insert(service에서 maxBbsId값 체크해서.)
		params.put("boardDto", boardDto);
		boardDto.setAtchFileNo(atchFileNo);
		boardService.regiBbs(boardDto);
		
		
		
		return "Y";
	}
}
	

