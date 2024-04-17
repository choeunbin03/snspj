package com.snspj.dao;

import java.util.List;
import java.util.Map;

import com.snspj.domain.AtchFileDTO;

public interface AtchFileDAO {
	
	public int getMaxAtchFileNo();
	public int getMaxAtchFileSeq(int atchFileNo);
	public void saveInfo(Map<String, Object> fileObj);
	public List<AtchFileDTO> getFileList(Map<String, Object> params);


}
