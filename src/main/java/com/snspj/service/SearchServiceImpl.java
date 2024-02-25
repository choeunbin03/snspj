package com.snspj.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.snspj.dao.SearchDAO;
import com.snspj.domain.BoardDTO;
import com.snspj.domain.MemberDTO;

@Service
public class SearchServiceImpl implements SearchService{
	
	@Inject
	private SearchDAO srchDao;

	@Override
	public MemberDTO getMbrInfo(String keyWd) {
		MemberDTO result = srchDao.getMbrInfo(keyWd);
		return result;
	}

	@Override
	public List<BoardDTO> getMbrBbsList(String keyWd) {
		List<BoardDTO> result = srchDao.getMbrBbsList(keyWd);
		return result;
	}

}
