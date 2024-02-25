package com.snspj.dao;

import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.snspj.domain.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static String namespace = "com.snspj.mappers.member";

	@Override
	public MemberDTO login(MemberDTO memberDto){
		MemberDTO result = sqlSession.selectOne(namespace+".login", memberDto);
		return result;
	}

	@Override
	public boolean idDpcnChk(Map<String, Object> param){
		boolean result = true;
		int val = sqlSession.selectOne(namespace+".idDpcnChk", param);
		if(val == 1) {//이미 아이디가 존재함.
			result = false;
		}
		return result;
	}

	@Override
	public int join(MemberDTO memberDto){
		int result = sqlSession.insert(namespace+".join", memberDto);
		return result;
	}
	
}
