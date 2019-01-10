package com.zqw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zqw.eurekaFeign.UploadService;

/**
 * 
 * @author zqw
 *2019年1月3日 下午4:19:34
 */
@Controller
@RestController
public class UploadController {
	@Autowired
	private UploadService uploadService;
	
	@RequestMapping(value="/uploadfile",consumes=MediaType.MULTIPART_FORM_DATA_VALUE,method=RequestMethod.POST)
	public String fileUpload(@RequestPart(value="file") MultipartFile file) {
		//处理文件
		System.out.println("s-uploadfile:"+System.currentTimeMillis());
		return uploadService.handleFileUpload(file);
//		return file.getName();
	}
}
