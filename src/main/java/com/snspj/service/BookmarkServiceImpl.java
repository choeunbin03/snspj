package com.snspj.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.snspj.dao.BookmarkDAO;

@Service
public class BookmarkServiceImpl implements BookmarkService{
	
	@Inject
	private BookmarkDAO bookmarkDao;

	@Override
	public void bmkPlc(Map<String, Object> bmkParam) {
		bookmarkDao.bmkPlc(bmkParam);
	}

	@Override
	public List<String> getCtgryNmList(Map<String, Object> param) {
		List<String> result = bookmarkDao.getCtgryNmList(param);
		return result;
	}

	@Override
	public List<String> getBmkPlc(Map<String, Object> param) {
		List<String> result = bookmarkDao.getBmkPlc(param);
		return result;
	}

	@Override
	public List<String> bmkListByCtgry(Map<String, Object> param) {
		List<String> result = bookmarkDao.bmkListByCtgry(param);
		return result;
	}

	@Override
	public List<String> bmkTop() {
		List<String> result = bookmarkDao.bmkTop();
		return result;
	}

	@Override
	public void addBmkBbs(Map<String, Object> params) {
		bookmarkDao.addBmkBbs(params);
	}

	@Override
	public void removeBmkBbs(Map<String, Object> params) {
		bookmarkDao.removeBmkBbs(params);
	}
	
	@Override
	public List<String> bmkYnBbsList(Map<String, Object> params) {
		List<String> result = bookmarkDao.bmkYnBbsList(params);	
		return result;
	}

	@Override
	public List<String> bmkYnSrch(Map<String, Object> params) {
		List<String> result = bookmarkDao.bmkYnSrch(params);	
		return result;
	}

	
}
