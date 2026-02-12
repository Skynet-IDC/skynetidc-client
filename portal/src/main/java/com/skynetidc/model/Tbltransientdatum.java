package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tbltransientdata")
public class Tbltransientdatum {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@Size(max = 1024)
	@NotNull
	@Column(name = "name", nullable = false, length = 1024)
	private String name;

	@NotNull
	@Lob
	@Column(name = "data", nullable = false)
	private String data;

	@NotNull
	@Column(name = "expires", nullable = false)
	private Integer expires;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Integer getExpires() {
		return expires;
	}

	public void setExpires(Integer expires) {
		this.expires = expires;
	}

}
