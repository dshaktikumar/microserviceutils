package com.dsk.limits.limits;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/limits")
public class LimitsController {
	@GetMapping("/checklimits/{limitId}" )
	public String getLimitCheck(@PathVariable String limitId) {
		return "Y";
	}
	@GetMapping("/limits/{limitId}" )
	public LimitVO limits(@PathVariable String limitId) {
		LimitVO vo = new LimitVO();
		vo.setAmount(new BigDecimal(2.0));
		vo.setLimitId(limitId);
		vo.setLimitAvailable(true);
		return vo;
	}
}
