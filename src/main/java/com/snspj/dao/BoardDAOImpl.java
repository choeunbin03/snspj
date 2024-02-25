package com.snspj.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.snspj.domain.BoardDTO;
import com.snspj.domain.FollowDTO;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static String namespace = "com.snspj.mappers.board";

	@Override
	public List<BoardDTO> getBbsList(Map<String, Object> params) {
		List<BoardDTO> bbsList = sqlSession.selectList(namespace + ".getBbsList", params);
		return bbsList;
	}

	@Override
	public BoardDTO getBbsView(int bbsId) {
		BoardDTO bbsView = sqlSession.selectOne(namespace + ".getBbsView", bbsId);
		return bbsView;
	}

}
