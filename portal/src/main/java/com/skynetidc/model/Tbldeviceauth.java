package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "tbldeviceauth")
public class Tbldeviceauth {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@Size(max = 255)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "identifier", nullable = false)
	private String identifier;

	@Size(max = 255)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "secret", nullable = false)
	private String secret;

	@Size(max = 255)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "compat_secret", nullable = false)
	private String compatSecret;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "user_id", nullable = false)
	private Integer userId;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "is_admin", nullable = false)
	private Boolean isAdmin = false;

	@NotNull
	@Lob
	@Column(name = "role_ids", nullable = false)
	private String roleIds;

	@Size(max = 255)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "description", nullable = false)
	private String description;

	@NotNull
	@ColumnDefault("'0000-00-00 00:00:00'")
	@Column(name = "last_access", nullable = false)
	private Instant lastAccess;

	@NotNull
	@ColumnDefault("'0000-00-00 00:00:00'")
	@Column(name = "created_at", nullable = false)
	private Instant createdAt;

	@NotNull
	@ColumnDefault("'0000-00-00 00:00:00'")
	@Column(name = "updated_at", nullable = false)
	private Instant updatedAt;

	@Column(name = "deleted_at")
	private Instant deletedAt;

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

	public String getCompatSecret() {
		return compatSecret;
	}

	public void setCompatSecret(String compatSecret) {
		this.compatSecret = compatSecret;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Instant getLastAccess() {
		return lastAccess;
	}

	public void setLastAccess(Instant lastAccess) {
		this.lastAccess = lastAccess;
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
