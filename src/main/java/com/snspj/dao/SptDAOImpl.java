package com.snspj.dao;

import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class SptDAOImpl implements SptDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static String namespace = "com.snspj.mappers.spt";


	@Override
	public int checkBbsSptYn(Map<String, Object> params) {
		int result = sqlSession.selectOne(namespace+".checkBbsSptYn", params);
		return result;
	}

	@Override
	public void updateBbsSpt(int bbsId) {
		sqlSession.update(namespace+".updateBbsSpt", bbsId);
	}

	@Override
	public void insertSptTb(Map<String, Object> params) {
		sqlSession.insert(namespace+".insertSptTb", params);
		
	}


}
