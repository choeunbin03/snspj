package com.snspj.service;

import java.util.Map;

public interface SptService {

	public int checkBbsSptYn(Map<String, Object> params);
	public void updateBbsSpt(int bbsId);
	public void insertSptTb(Map<String, Object> params);
}
