package com.dsk.loan.proxy;

import java.math.BigDecimal;

public class LimitVO {
	private String limitId;
	private BigDecimal amount;
	private boolean limitAvailable;
	public String getLimitId() {
		return limitId;
	}
	public void setLimitId(String limitId) {
		this.limitId = limitId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public boolean isLimitAvailable() {
		return limitAvailable;
	}
	public void setLimitAvailable(boolean limitAvailable) {
		this.limitAvailable = limitAvailable;
	}
	
}
