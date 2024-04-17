package com.snspj.dao;

import java.util.List;
import java.util.Map;

public interface SptDAO {

	public boolean checkBbsSptYn(Map<String, Object> params);
	public void addBbsSpt(int bbsId);
	public void addSpt(Map<String, Object> params);
	public void removeBbsSpt(int bbsId);
	public void removeSpt(Map<String, Object> params);
	public List<String> sptYnBbsList(Map<String, Object> params);
	public List<String> sptYnSrch(Map<String, Object> params);
}
