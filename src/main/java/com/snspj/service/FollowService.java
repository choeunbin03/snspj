package com.snspj.service;

import java.util.List;
import java.util.Map;

import com.snspj.domain.FollowDTO;

public interface FollowService {

	public List<FollowDTO> getFllwList(Map<String, Object> params);
	
}
