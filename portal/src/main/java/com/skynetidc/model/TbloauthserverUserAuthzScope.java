package com.skynetidc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "tbloauthserver_user_authz_scopes")
public class TbloauthserverUserAuthzScope {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "user_authz_id", nullable = false)
	private Integer userAuthzId;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "scope_id", nullable = false)
	private Integer scopeId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserAuthzId() {
		return userAuthzId;
	}

	public void setUserAuthzId(Integer userAuthzId) {
		this.userAuthzId = userAuthzId;
	}

	public Integer getScopeId() {
		return scopeId;
	}

	public void setScopeId(Integer scopeId) {
		this.scopeId = scopeId;
	}

}
