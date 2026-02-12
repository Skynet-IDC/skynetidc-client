package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.Instant;

@Entity
@Table(name = "tblauthn_account_links")
public class TblauthnAccountLink {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@Size(max = 32)
	@NotNull
	@Column(name = "provider", nullable = false, length = 32)
	private String provider;

	@Size(max = 255)
	@Column(name = "remote_user_id")
	private String remoteUserId;

	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "client_id")
	private Integer clientId;

	@Column(name = "contact_id")
	private Integer contactId;

	@Lob
	@Column(name = "metadata")
	private String metadata;

	@Column(name = "created_at")
	private Instant createdAt;

	@Column(name = "updated_at")
	private Instant updatedAt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getRemoteUserId() {
		return remoteUserId;
	}

	public void setRemoteUserId(String remoteUserId) {
		this.remoteUserId = remoteUserId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	public String getMetadata() {
		return metadata;
	}

	public void setMetadata(String metadata) {
		this.metadata = metadata;
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
