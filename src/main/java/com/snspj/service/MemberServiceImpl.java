package com.snspj.service;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.snspj.dao.MemberDAO;
import com.snspj.domain.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Inject
	private MemberDAO memberDao;

	@Override
	public MemberDTO login(MemberDTO memberDto) {
		MemberDTO result = memberDao.login(memberDto);
		return result;
	}

	@Override
	public boolean idDpcnChk(Map<String, Object> param) {
		boolean result = memberDao.idDpcnChk(param);
		return result;
	}

	@Override
	public int join(MemberDTO memberDto) {
		int result = memberDao.join(memberDto);
		return result;
	}

}
