package com.snspj.dao;

import java.util.List;
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
	public boolean checkBbsSptYn(Map<String, Object> params) {
		boolean result = false;
		int checkBbsSptYn = sqlSession.selectOne(namespace+".checkBbsSptYn", params);
		if(checkBbsSptYn == 1) {//좋아요 누름
			result = true;
		}
		return result;
	}

	@Override
	public void addBbsSpt(int bbsId) {
		sqlSession.update(namespace+".addBbsSpt", bbsId);
	}

	@Override
	public void addSpt(Map<String, Object> params) {
		sqlSession.insert(namespace+".addSpt", params);		
	}

	@Override
	public void removeBbsSpt(int bbsId) {
		sqlSession.update(namespace+".removeBbsSpt", bbsId);
	}

	@Override
	public void removeSpt(Map<String, Object> params) {
		sqlSession.delete(namespace+".removeSpt", params);
	}

	@Override
	public List<String> sptYnBbsList(Map<String, Object> params) {
		List<String> result = sqlSession.selectList(namespace+".sptYnBbsList", params);
		return result;
	}

	@Override
	public List<String> sptYnSrch(Map<String, Object> params) {
		List<String> result = sqlSession.selectList(namespace+".sptYnSrch", params);
		return result;
	}


}
