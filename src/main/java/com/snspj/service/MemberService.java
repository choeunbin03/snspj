package com.snspj.service;

import java.util.Map;

import com.snspj.domain.MemberDTO;

public interface MemberService {
	
	public MemberDTO login(MemberDTO memberDto);
	public boolean idDpcnChk(Map<String, Object> param);
	public int join(MemberDTO memberDto);
	
}
