package com.snspj.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.snspj.dao.FollowDAO;
import com.snspj.domain.FollowDTO;

@Service
public class FollowServiceImpl implements FollowService{
	
	@Inject
	private FollowDAO followDao;

	@Override
	public List<FollowDTO> getFllwList(Map<String, Object> params) {
		List<FollowDTO> result = followDao.getFllwList(params);
		return result;
	}
	
	

}
