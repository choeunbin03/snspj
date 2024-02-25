package com.snspj.dao;

import java.util.List;

import com.snspj.domain.BoardDTO;
import com.snspj.domain.MemberDTO;

public interface SearchDAO {
	
	public MemberDTO getMbrInfo(String keyWd);
	public List<BoardDTO> getMbrBbsList(String keyWd);

}
