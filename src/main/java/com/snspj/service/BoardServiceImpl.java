package com.snspj.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.snspj.dao.BoardDAO;
import com.snspj.domain.BoardDTO;
import com.snspj.domain.FollowDTO;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Inject
	private BoardDAO boardDao;

	@Override
	public List<BoardDTO> getBbsList(Map<String, Object> params) {
		List<BoardDTO> bbsList = boardDao.getBbsList(params);
		return bbsList;
	}

	@Override
	public BoardDTO getBbsView(int bbsId) {
		BoardDTO bbsView = boardDao.getBbsView(bbsId);
		return bbsView;
	}

	
}
