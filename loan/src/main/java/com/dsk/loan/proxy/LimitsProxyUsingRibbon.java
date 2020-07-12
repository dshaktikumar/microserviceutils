package com.dsk.loan.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("zuul-gateway-server")
@RibbonClient("limits-system")
public interface LimitsProxyUsingRibbon {
	@GetMapping("/limit-system/limits/limits/{limitId}" )
	public LimitVO limits(@PathVariable String limitId);
}
