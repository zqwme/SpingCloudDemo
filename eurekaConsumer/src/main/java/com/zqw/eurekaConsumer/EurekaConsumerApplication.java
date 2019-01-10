package com.zqw.eurekaConsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author zqw
 *2018年12月29日 下午5:13:22
 */
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaConsumerApplication {
	
	private static final Logger log = LoggerFactory.getLogger(EurekaConsumerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EurekaConsumerApplication.class, args);
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

