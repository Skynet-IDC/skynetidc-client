package com.skynetidc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.Instant;

@Entity
@Table(name = "tblservicedata")
public class Tblservicedatum {

	@Id
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "service_id")
	private Integer serviceId;

	@Column(name = "addon_id")
	private Integer addonId;

	@NotNull
	@Column(name = "client_id", nullable = false)
	private Integer clientId;

	@Size(max = 32)
	@Column(name = "actor", length = 32)
	private String actor;

	@Size(max = 32)
	@NotNull
	@Column(name = "scope", nullable = false, length = 32)
	private String scope;

	@Size(max = 64)
	@NotNull
	@Column(name = "name", nullable = false, length = 64)
	private String name;

	@Size(max = 64)
	@Column(name = "value", length = 64)
	private String value;

	@Column(name = "expires_at")
	private Instant expiresAt;

	@Column(name = "created_at")
	private Instant createdAt;

	@Column(name = "updated_at")
	private Instant updatedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public Integer getAddonId() {
		return addonId;
	}

	public void setAddonId(Integer addonId) {
		this.addonId = addonId;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Instant getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(Instant expiresAt) {
		this.expiresAt = expiresAt;
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
