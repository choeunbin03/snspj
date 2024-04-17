package com.snspj.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class BookmarkDAOImpl implements BookmarkDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static String namespace = "com.snspj.mappers.bookmark";

	@Override
	public void bmkPlc(Map<String, Object> bmkParam) {
		sqlSession.insert(namespace+".bmkPlc", bmkParam);
	}

	@Override
	public List<String> getCtgryNmList(Map<String, Object> param) {
		List<String> result = sqlSession.selectList(namespace+".getCtgryNmList", param);
		return result;
	}

	@Override
	public List<String> getBmkPlc(Map<String, Object> param) {
		List<String> result = sqlSession.selectList(namespace+".getBmkPlc", param);
		return result;
	}

	@Override
	public List<String> bmkListByCtgry(Map<String, Object> param) {
		List<String> result = sqlSession.selectList(namespace+".bmkListByCtgry", param);
		return result;
	}

	@Override
	public List<String> bmkTop() {
		List<String> result = sqlSession.selectList(namespace+".bmkTop");
		return result;
	}

	@Override
	public void addBmkBbs(Map<String, Object> params) {
		sqlSession.insert(namespace+".addBmkBbs", params);
	}
	
	@Override
	public void removeBmkBbs(Map<String, Object> params) {
		sqlSession.delete(namespace+".removeBmkBbs", params);
	}

	@Override
	public List<String> bmkYnBbsList(Map<String, Object> params) {
		List<String> result = sqlSession.selectList(namespace+".bmkYnBbsList", params);
		return result;
	}

	@Override
	public List<String> bmkYnSrch(Map<String, Object> params) {
		List<String> result = sqlSession.selectList(namespace+".bmkYnSrch", params);
		return result;
	}

	
}
