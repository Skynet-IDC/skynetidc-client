package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "tbluser_invites")
public class TbluserInvite {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@Size(max = 100)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "token", nullable = false, length = 100)
	private String token;

	@Size(max = 255)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "email", nullable = false)
	private String email;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "client_id", nullable = false)
	private Integer clientId;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "invited_by", nullable = false)
	private Integer invitedBy;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "invited_by_admin", nullable = false)
	private Byte invitedByAdmin;

	@Lob
	@Column(name = "permissions")
	private String permissions;

	@Column(name = "accepted_at")
	private Instant acceptedAt;

	@Column(name = "created_at")
	private Instant createdAt;

	@Column(name = "updated_at")
	private Instant updatedAt;

	@Column(name = "deleted_at")
	private Instant deletedAt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public Integer getInvitedBy() {
		return invitedBy;
	}

	public void setInvitedBy(Integer invitedBy) {
		this.invitedBy = invitedBy;
	}

	public Byte getInvitedByAdmin() {
		return invitedByAdmin;
	}

	public void setInvitedByAdmin(Byte invitedByAdmin) {
		this.invitedByAdmin = invitedByAdmin;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	public Instant getAcceptedAt() {
		return acceptedAt;
	}

	public void setAcceptedAt(Instant acceptedAt) {
		this.acceptedAt = acceptedAt;
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

	public Instant getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Instant deletedAt) {
		this.deletedAt = deletedAt;
	}

}
