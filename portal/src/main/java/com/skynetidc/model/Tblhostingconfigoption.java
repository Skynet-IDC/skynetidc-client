package com.skynetidc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tblhostingconfigoptions")
public class Tblhostingconfigoption {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Column(name = "relid", nullable = false)
	private Integer relid;

	@NotNull
	@Column(name = "configid", nullable = false)
	private Integer configid;

	@NotNull
	@Column(name = "optionid", nullable = false)
	private Integer optionid;

	@NotNull
	@Column(name = "qty", nullable = false)
	private Integer qty;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRelid() {
		return relid;
	}

	public void setRelid(Integer relid) {
		this.relid = relid;
	}

	public Integer getConfigid() {
		return configid;
	}

	public void setConfigid(Integer configid) {
		this.configid = configid;
	}

	public Integer getOptionid() {
		return optionid;
	}

	public void setOptionid(Integer optionid) {
		this.optionid = optionid;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

}
