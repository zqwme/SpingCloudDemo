package com.zqw.eurekaFeign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;

/**
 * 
 * @author zqw
 *2019年1月3日 上午11:31:35
 */
//@FeignClient(value="client-feign-fileUpload",configuration=UploadService.MultipartSupportConfig.class)
@FeignClient("client-feign-fileUpload")
//@Component
public interface UploadService {
	
	@RequestMapping(value="/uploadfile",consumes=MediaType.MULTIPART_FORM_DATA_VALUE,method=RequestMethod.POST)
	public String handleFileUpload(@RequestPart(value="file") MultipartFile file);
	
	@RequestMapping("/ftt")
	public String tt();
	
	@Configuration
	class MultipartSupportConfig {
		@Bean
        public Encoder feignFormEncoder() {
			
            return new SpringFormEncoder();
        }
		
	}
}
