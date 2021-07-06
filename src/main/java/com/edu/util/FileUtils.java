package com.edu.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.edu.product.controller.ProductController;

@Component("fileUtils")
public class FileUtils {

	private static final String filePath = "D:\\zordy/img";
	
	public List<Map<String, Object>> parseInsertFileInfo(int productNo, 
			MultipartHttpServletRequest multipartHttpServletRequest) 
					throws Exception{
		
		Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
		MultipartFile multipartFile = null;
		String originalFileName = null;
		String originalFileExtension = null;
		String storedFileName = null;
		
		List<Map<String, Object>> fileList = new ArrayList<Map<String,Object>>();
		Map<String, Object> fileInfoMap = null;
		
		File file = new File(filePath);
		
		if(file.exists() == false) {
			file.mkdirs();
		}
		
		while(iterator.hasNext()) {
			multipartFile = multipartHttpServletRequest.getFile(iterator.next());
			
			if(multipartFile.isEmpty() == false) {
				originalFileName = multipartFile.getOriginalFilename();
				originalFileExtension = originalFileName.
						substring(originalFileName.lastIndexOf("."));
				storedFileName = CommonUtils.getRandomString() 
						+ originalFileExtension;
				
				file = new File(filePath, storedFileName);
				multipartFile.transferTo(file);
				
				fileInfoMap = new HashMap<String, Object>();
				fileInfoMap.put("productNo", productNo);
				fileInfoMap.put("originalFileName", originalFileName);
				fileInfoMap.put("storedFileName", storedFileName);
				fileInfoMap.put("fileSize", multipartFile.getSize());
				
				fileList.add(fileInfoMap);
			}
			
		}
		
		return fileList;
	} // 메서드 종료
	
	public void parseUpdateFileInfo(Map<String, Object> tempFileMap) {
		String storedFileName = (String)tempFileMap.get("STORED_FILE_NAME");
		
		File file = new File(filePath + "/" + storedFileName);
		
		if(file.exists()) {
			file.delete();
		}else {
			System.out.println("파일이 존재하지 않습니다.");
		}
		
	}
	
}
