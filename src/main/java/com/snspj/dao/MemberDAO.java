package com.snspj.dao;

import java.util.Map;

import com.snspj.domain.MemberDTO;

public interface MemberDAO {
	public MemberDTO login(MemberDTO memberDto);
	public boolean idDpcnChk(Map<String, Object> param);
	public int join(MemberDTO memberDto);
}
