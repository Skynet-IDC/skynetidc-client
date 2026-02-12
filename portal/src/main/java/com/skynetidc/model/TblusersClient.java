package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "tblusers_clients")
public class TblusersClient {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "auth_user_id", nullable = false)
	private Integer authUserId;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "client_id", nullable = false)
	private Integer clientId;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "invite_id", nullable = false)
	private Integer inviteId;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "owner", nullable = false)
	private Byte owner;

	@Lob
	@Column(name = "permissions")
	private String permissions;

	@Column(name = "last_login")
	private Instant lastLogin;

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

	public Integer getAuthUserId() {
		return authUserId;
	}

	public void setAuthUserId(Integer authUserId) {
		this.authUserId = authUserId;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public Integer getInviteId() {
		return inviteId;
	}

	public void setInviteId(Integer inviteId) {
		this.inviteId = inviteId;
	}

	public Byte getOwner() {
		return owner;
	}

	public void setOwner(Byte owner) {
		this.owner = owner;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	public Instant getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Instant lastLogin) {
		this.lastLogin = lastLogin;
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
