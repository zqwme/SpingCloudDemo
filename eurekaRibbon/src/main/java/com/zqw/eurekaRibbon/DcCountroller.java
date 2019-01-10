package com.zqw.eurekaRibbon;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController()
@RequestMapping("/")
public class DcCountroller {
	
	
	private static final Logger log = LoggerFactory.getLogger(DcCountroller.class);

	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("consumer")
	public Object consumer() {
		Object object = restTemplate.getForObject("http://client-zqw/dcs", Object.class);
		System.out.println(object);
		return object;
	}
	
	@RequestMapping("dc")
	public Object dc() {
		ServiceInstance si = loadBalancerClient.choose("client-zqw");
		List<String> list = discoveryClient.getServices();
		
		if (null != list && list.size() > 0) {
			for (String str : list) {
				List<ServiceInstance> siList = discoveryClient.getInstances(str);
				for (ServiceInstance serviceInstance : siList) {
					log.info(serviceInstance.getServiceId());
				}
			}
			 
		}
		String url = "http://" + si.getHost() + ":" + si.getPort() + "/dcs";
		log.info(url);
		return restTemplate.getForObject(url, Object.class);
	}
	
	@RequestMapping("tt")
	public Object tt() {
		
		return "tt";
	}
	
	@RequestMapping("info")
	public Object info() {
		List<String> list = discoveryClient.getServices();
		List<ServiceInstance> siList = new ArrayList<ServiceInstance>();
		for (String str : list) {
			siList.addAll(discoveryClient.getInstances(str));
		}
		return siList;
	}
	@RequestMapping("dcs")
	public Object dcs() {
		
		return discoveryClient.getServices();
	}

}
