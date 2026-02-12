package com.skynetidc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "tbloauthserver_authcode_scopes")
public class TbloauthserverAuthcodeScope {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "authorization_code_id", nullable = false)
	private Integer authorizationCodeId;

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

	public Integer getAuthorizationCodeId() {
		return authorizationCodeId;
	}

	public void setAuthorizationCodeId(Integer authorizationCodeId) {
		this.authorizationCodeId = authorizationCodeId;
	}

	public Integer getScopeId() {
		return scopeId;
	}

	public void setScopeId(Integer scopeId) {
		this.scopeId = scopeId;
	}

}
