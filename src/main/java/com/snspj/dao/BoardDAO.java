package com.snspj.dao;

import java.util.List;
import java.util.Map;

import com.snspj.domain.BoardDTO;
import com.snspj.domain.FollowDTO;

public interface BoardDAO {

	public List<BoardDTO> getBbsList(Map<String, Object> params);
	public BoardDTO getBbsView(int bbsId);

}
