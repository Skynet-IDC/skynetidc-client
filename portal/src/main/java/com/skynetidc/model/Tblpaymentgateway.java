package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tblpaymentgateways")
public class Tblpaymentgateway {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Lob
	@Column(name = "gateway", nullable = false)
	private String gateway;

	@NotNull
	@Lob
	@Column(name = "setting", nullable = false)
	private String setting;

	@NotNull
	@Lob
	@Column(name = "value", nullable = false)
	private String value;

	@NotNull
	@Column(name = "`order`", nullable = false)
	private Integer order;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGateway() {
		return gateway;
	}

	public void setGateway(String gateway) {
		this.gateway = gateway;
	}

	public String getSetting() {
		return setting;
	}

	public void setSetting(String setting) {
		this.setting = setting;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

}
