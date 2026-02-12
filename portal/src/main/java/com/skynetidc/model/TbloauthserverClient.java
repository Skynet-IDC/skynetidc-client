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
@Table(name = "tbloauthserver_clients")
public class TbloauthserverClient {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@Size(max = 80)
	@NotNull
	@Column(name = "identifier", nullable = false, length = 80)
	private String identifier;

	@Size(max = 255)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "secret", nullable = false)
	private String secret;

	@Size(max = 2000)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "redirect_uri", nullable = false, length = 2000)
	private String redirectUri;

	@Size(max = 80)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "grant_types", nullable = false, length = 80)
	private String grantTypes;

	@Size(max = 255)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "user_id", nullable = false)
	private String userId;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "service_id", nullable = false)
	private Integer serviceId;

	@Size(max = 255)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "name", nullable = false)
	private String name;

	@Size(max = 255)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "description", nullable = false)
	private String description;

	@Size(max = 255)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "logo_uri", nullable = false)
	private String logoUri;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "rsa_key_pair_id", nullable = false)
	private Integer rsaKeyPairId;

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

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getRedirectUri() {
		return redirectUri;
	}

	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}

	public String getGrantTypes() {
		return grantTypes;
	}

	public void setGrantTypes(String grantTypes) {
		this.grantTypes = grantTypes;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLogoUri() {
		return logoUri;
	}

	public void setLogoUri(String logoUri) {
		this.logoUri = logoUri;
	}

	public Integer getRsaKeyPairId() {
		return rsaKeyPairId;
	}

	public void setRsaKeyPairId(Integer rsaKeyPairId) {
		this.rsaKeyPairId = rsaKeyPairId;
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
