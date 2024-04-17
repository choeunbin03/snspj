package com.snspj.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.snspj.dao.SptDAO;

@Service
public class SptServiceImpl implements SptService{
	
	@Inject
	private SptDAO sptDao;

	@Override
	public boolean checkBbsSptYn(Map<String, Object> params) {
		boolean result = sptDao.checkBbsSptYn(params);
		return result;
	}

	@Override
	public void addBbsSpt(int bbsId) {
		sptDao.addBbsSpt(bbsId);		
	}

	@Override
	public void addSpt(Map<String, Object> params) {
		sptDao.addSpt(params);	
		
	}

	@Override
	public void removeBbsSpt(int bbsId) {
		sptDao.removeBbsSpt(bbsId);
	}

	@Override
	public void removeSpt(Map<String, Object> params) {
		sptDao.removeSpt(params);	
	}

	@Override
	public List<String> sptYnBbsList(Map<String, Object> params) {
		List<String> result = sptDao.sptYnBbsList(params);	
		return result;
	}

	@Override
	public List<String> sptYnSrch(Map<String, Object> params) {
		List<String> result = sptDao.sptYnSrch(params);	
		return result;
	}

	

}
