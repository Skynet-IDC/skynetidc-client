package com.skynetidc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tbladminperms")
public class Tbladminperm {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Column(name = "roleid", nullable = false)
	private Integer roleid;

	@NotNull
	@Column(name = "permid", nullable = false)
	private Integer permid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public Integer getPermid() {
		return permid;
	}

	public void setPermid(Integer permid) {
		this.permid = permid;
	}

}
