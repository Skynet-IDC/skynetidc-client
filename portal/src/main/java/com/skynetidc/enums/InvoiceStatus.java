package com.skynetidc.enums;

/**
 * @author hoadq
 */
public enum InvoiceStatus {

	PAID("Paid"), UNPAID("Unpaid"), CANCELLED("Cancelled"), REFUNDED("Refunded");

	private String code;

	InvoiceStatus(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
