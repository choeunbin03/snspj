package com.snspj.dao;

import java.util.Map;

public interface SptDAO {

	public int checkBbsSptYn(Map<String, Object> params);
	public void updateBbsSpt(int bbsId);
	public void insertSptTb(Map<String, Object> params);
}
