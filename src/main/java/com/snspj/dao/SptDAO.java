package com.snspj.dao;

import java.util.Map;

public interface SptDAO {

	public boolean checkBbsSptYn(Map<String, Object> params);
	public void updateBbsSpt(int bbsId);
	public void insertSptTb(Map<String, Object> params);
}
