package com.zqw.controller;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传测试controller
 * @author zqw
 *2019年1月3日 下午4:19:34
 */
@Controller
@RestController
public class UploadController {
	
	@RequestMapping(value="/uploadfile",consumes=MediaType.MULTIPART_FORM_DATA_VALUE,method=RequestMethod.POST)
	public String fileUpload(@RequestPart(value="file") MultipartFile file) {
		System.out.println("c-uploadfile:"+System.currentTimeMillis());
		System.out.println(file.getOriginalFilename());
		try {
			file.transferTo(new File("d:/aa/"+file.getOriginalFilename()));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//处理文件
		return file.getOriginalFilename();
	}
	@RequestMapping("/ftt")
	public Object tt() {
		
		return "ftt-test";
	}
}
