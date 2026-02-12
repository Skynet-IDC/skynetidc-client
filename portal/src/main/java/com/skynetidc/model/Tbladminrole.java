package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tbladminroles")
public class Tbladminrole {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Lob
	@Column(name = "name", nullable = false)
	private String name;

	@NotNull
	@Lob
	@Column(name = "widgets", nullable = false)
	private String widgets;

	@NotNull
	@Lob
	@Column(name = "reports", nullable = false)
	private String reports;

	@NotNull
	@Column(name = "systememails", nullable = false)
	private Integer systememails;

	@NotNull
	@Column(name = "accountemails", nullable = false)
	private Integer accountemails;

	@NotNull
	@Column(name = "supportemails", nullable = false)
	private Integer supportemails;

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

	public String getWidgets() {
		return widgets;
	}

	public void setWidgets(String widgets) {
		this.widgets = widgets;
	}

	public String getReports() {
		return reports;
	}

	public void setReports(String reports) {
		this.reports = reports;
	}

	public Integer getSystememails() {
		return systememails;
	}

	public void setSystememails(Integer systememails) {
		this.systememails = systememails;
	}

	public Integer getAccountemails() {
		return accountemails;
	}

	public void setAccountemails(Integer accountemails) {
		this.accountemails = accountemails;
	}

	public Integer getSupportemails() {
		return supportemails;
	}

	public void setSupportemails(Integer supportemails) {
		this.supportemails = supportemails;
	}

}
