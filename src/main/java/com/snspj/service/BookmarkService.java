package com.snspj.service;

import java.util.List;
import java.util.Map;

public interface BookmarkService {
	
	public void bmkPlc(Map<String, Object> bmkParam);
	public List<String> getCtgryNmList(Map<String, Object> param);
	public List<String> getBmkPlc(Map<String, Object> param);
	public List<String> bmkListByCtgry(Map<String, Object> param);
	public List<String> bmkTop();

	
	public void bmkBbs(Map<String, Object> bmkParam);
}
