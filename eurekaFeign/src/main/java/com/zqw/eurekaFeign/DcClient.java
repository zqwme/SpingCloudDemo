package com.zqw.eurekaFeign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 获取服务绑定类
 * @author zqw
 *2019年1月3日 上午10:55:49
 */
@FeignClient("client-zqw")//提供服务名称
public interface DcClient {
	
	@RequestMapping("/dcs")
	public Object dcs();
	
	@RequestMapping("/info")
	public Object clientInfo();
}
