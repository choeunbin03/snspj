package com.snspj.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.snspj.domain.AtchFileDTO;

public interface AtchFileService {
	
	public int getMaxAtchFileNo();
	public int getMaxAtchFileSeq(int atchFileNo);
	public List<Map<String, Object>> submitFiles(List<MultipartFile> multipartFileList) throws IOException;
	public void saveInfo(Map<String, Object> params);
	public List<List<AtchFileDTO>> getFileList(Map<String, Object> params);

}
