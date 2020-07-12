package com.dsk.loan.loan;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dsk.loan.proxy.LimitVO;
//import com.dsk.loan.proxy.LimitsProxyUsingRibbon;

@RestController
@RequestMapping("/loans")
public class LoanController {

	@Autowired 
	private LoadBalancerClient loadBalancer;
//	@Autowired
//	private LimitsProxyUsingRibbon ribbon;
	/**
	 * Manual load balancer using Ribbon
	 */
	@PostMapping("/process")
	public void processLoan() {
		ServiceInstance instance = loadBalancer.choose("limit-system");
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("limitId", "dsk");
		String host = instance.getHost();
		int port = instance.getPort();
		ResponseEntity<String> responseEntity = new RestTemplate().getForEntity(
				String.format("http://%s:%s/limits/checklimits/{limitId}", host, port), String.class,
				uriVariables);
		System.out.println(responseEntity.getBody());
	}
	/**
	 * Ribbon client with Proxy
	 * @param limitId
	 * @return
	 */
	@GetMapping("/checklimits/{limitId}")
	public LimitVO limits(@PathVariable String limitId) {
		ServiceInstance instance = loadBalancer.choose("limit-system");
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("limitId", limitId);
		String host = instance.getHost();
		int port = instance.getPort();
		ResponseEntity<LimitVO> responseEntity = new RestTemplate().getForEntity(
				String.format("http://%s:%s/limits/limits/{limitId}", host, port), LimitVO.class,
				uriVariables);
		return responseEntity.getBody();
	}

}