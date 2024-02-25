package com.snspj.service;

import java.util.List;
import java.util.Map;

import com.snspj.domain.BoardDTO;
import com.snspj.domain.FollowDTO;

public interface BoardService {
	public List<BoardDTO> getBbsList(Map<String, Object> params);
	public BoardDTO getBbsView(int bbsId);
}
