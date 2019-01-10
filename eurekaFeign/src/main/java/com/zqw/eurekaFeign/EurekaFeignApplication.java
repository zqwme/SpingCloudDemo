package com.zqw.eurekaFeign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author zqw
 *2019年1月3日 上午10:52:19
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan("com.zqw.*")
public class EurekaFeignApplication {
	
	private static final Logger log = LoggerFactory.getLogger(EurekaFeignApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EurekaFeignApplication.class, args);
	}
	
	/**
	 * 初始化RestTemplate，用来真正发起REST请
	 * @return
	 */
	@Bean
	public RestTemplate restTemplate() {
		log.info("create Bean************************");
		return new RestTemplate();
	}

}

