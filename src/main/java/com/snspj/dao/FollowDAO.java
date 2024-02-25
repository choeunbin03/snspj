package com.snspj.dao;

import java.util.List;
import java.util.Map;

import com.snspj.domain.FollowDTO;

public interface FollowDAO {

	public List<FollowDTO> getFllwList(Map<String, Object> params);
	
}
