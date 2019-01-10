package com.zqw.eurekaClient;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/")
public class DcCountroller {
	
	private static final Logger log = LoggerFactory.getLogger(DcCountroller.class);

	@Autowired
	private DiscoveryClient discoveryClient;
	
	@RequestMapping("tt")
	public Object tt() {
		
		return "tt";
	}
	
	@RequestMapping("info")
	public Object info() {
		log.info("client-zqw:10005-->info");
		List<String> list = discoveryClient.getServices();
		List<ServiceInstance> siList = new ArrayList<ServiceInstance>();
		for (String str : list) {
			siList.addAll(discoveryClient.getInstances(str));
		}
		return siList;
	}
	@RequestMapping("dcs")
	public Object dcs() {
		try {
			Thread.sleep(5*1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.info("client-zqw:10005-->dcs");
		return discoveryClient.getServices();
	}

}
