package com.snspj.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.snspj.domain.BoardDTO;
import com.snspj.domain.MemberDTO;

@Repository
public class SearchDAOImpl implements SearchDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static String namespace = "com.snspj.mappers.search";

	@Override
	public MemberDTO getMbrInfo(String keyWd) {
		MemberDTO result = sqlSession.selectOne(namespace + ".getMbrInfo", keyWd);
		return result;
	}

	@Override
	public List<BoardDTO> getMbrBbsList(String keyWd) {
		List<BoardDTO> result = sqlSession.selectList(namespace + ".getMbrBbsList", keyWd);
		return result;
	}

}
