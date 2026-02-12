package com.skynetidc.enums;

/**
 * @author hoadq
 */
public enum OrderStatus {

	ACTIVE("Active"), CANCELLED("Cancelled"), PENDING("Pending"), FRAUD("Fraud");

	private String code;

	OrderStatus(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
