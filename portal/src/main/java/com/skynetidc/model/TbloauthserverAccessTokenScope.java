package com.skynetidc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "tbloauthserver_access_token_scopes")
public class TbloauthserverAccessTokenScope {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "access_token_id", nullable = false)
	private Integer accessTokenId;

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

	public Integer getAccessTokenId() {
		return accessTokenId;
	}

	public void setAccessTokenId(Integer accessTokenId) {
		this.accessTokenId = accessTokenId;
	}

	public Integer getScopeId() {
		return scopeId;
	}

	public void setScopeId(Integer scopeId) {
		this.scopeId = scopeId;
	}

}
