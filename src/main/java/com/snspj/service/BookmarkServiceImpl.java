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
	
}
