package com.skynetidc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "tbloauthserver_access_tokens")
public class TbloauthserverAccessToken {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@Size(max = 80)
	@NotNull
	@Column(name = "access_token", nullable = false, length = 80)
	private String accessToken;

	@Size(max = 80)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "client_id", nullable = false, length = 80)
	private String clientId;

	@Size(max = 255)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "user_id", nullable = false)
	private String userId;

	@Size(max = 2000)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "redirect_uri", nullable = false, length = 2000)
	private String redirectUri;

	@NotNull
	@ColumnDefault("'0000-00-00 00:00:00'")
	@Column(name = "expires", nullable = false)
	private Instant expires;

	@NotNull
	@ColumnDefault("'0000-00-00 00:00:00'")
	@Column(name = "created_at", nullable = false)
	private Instant createdAt;

	@NotNull
	@ColumnDefault("'0000-00-00 00:00:00'")
	@Column(name = "updated_at", nullable = false)
	private Instant updatedAt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRedirectUri() {
		return redirectUri;
	}

	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}

	public Instant getExpires() {
		return expires;
	}

	public void setExpires(Instant expires) {
		this.expires = expires;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Instant updatedAt) {
		this.updatedAt = updatedAt;
	}

}
