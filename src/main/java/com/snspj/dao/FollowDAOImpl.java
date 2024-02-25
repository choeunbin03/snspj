package com.snspj.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.snspj.domain.FollowDTO;

@Repository
public class FollowDAOImpl implements FollowDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static String namespace = "com.snspj.mappers.follow";

	@Override
	public List<FollowDTO> getFllwList(Map<String, Object> params) {
		List<FollowDTO> fllwList = sqlSession.selectList(namespace + ".getFllwList", params);
		return fllwList;
	}

}
