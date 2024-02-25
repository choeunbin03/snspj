package com.snspj.service;

import java.util.List;

import com.snspj.domain.BoardDTO;
import com.snspj.domain.MemberDTO;

public interface SearchService {
	
	public MemberDTO getMbrInfo(String keyWd);
	public List<BoardDTO> getMbrBbsList(String keyWd);

}
