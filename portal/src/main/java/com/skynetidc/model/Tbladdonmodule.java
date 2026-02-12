package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tbladdonmodules")
public class Tbladdonmodule {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Lob
	@Column(name = "module", nullable = false)
	private String module;

	@NotNull
	@Lob
	@Column(name = "setting", nullable = false)
	private String setting;

	@NotNull
	@Lob
	@Column(name = "value", nullable = false)
	private String value;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
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

}
