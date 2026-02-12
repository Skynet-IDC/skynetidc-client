package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

@Entity
@Table(name = "tblmodulelog")
public class Tblmodulelog {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Column(name = "date", nullable = false)
	private Instant date;

	@NotNull
	@Lob
	@Column(name = "module", nullable = false)
	private String module;

	@NotNull
	@Lob
	@Column(name = "action", nullable = false)
	private String action;

	@NotNull
	@Lob
	@Column(name = "request", nullable = false)
	private String request;

	@NotNull
	@Lob
	@Column(name = "response", nullable = false)
	private String response;

	@NotNull
	@Lob
	@Column(name = "arrdata", nullable = false)
	private String arrdata;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getArrdata() {
		return arrdata;
	}

	public void setArrdata(String arrdata) {
		this.arrdata = arrdata;
	}

}
