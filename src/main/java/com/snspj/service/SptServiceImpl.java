package com.snspj.service;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.snspj.dao.SptDAO;

@Service
public class SptServiceImpl implements SptService{
	
	@Inject
	private SptDAO sptDao;

	@Override
	public int checkBbsSptYn(Map<String, Object> params) {
		int result = sptDao.checkBbsSptYn(params);
		return result;
	}

	@Override
	public void updateBbsSpt(int bbsId) {
		sptDao.updateBbsSpt(bbsId);		
	}

	@Override
	public void insertSptTb(Map<String, Object> params) {
		sptDao.insertSptTb(params);	
		
	}
	

}
