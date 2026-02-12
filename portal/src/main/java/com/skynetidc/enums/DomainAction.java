package com.skynetidc.enums;

public enum DomainAction {

	REGISTER("register"), TRANSFER("transfer");

	private String action;

	DomainAction(String action) {
		this.action = action;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

}
