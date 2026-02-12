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
@Table(name = "tblfileassetsettings")
public class Tblfileassetsetting {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@Size(max = 64)
	@NotNull
	@Column(name = "asset_type", nullable = false, length = 64)
	private String assetType;

	@NotNull
	@Column(name = "storageconfiguration_id", nullable = false)
	private Integer storageconfigurationId;

	@Column(name = "migratetoconfiguration_id")
	private Integer migratetoconfigurationId;

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

	public String getAssetType() {
		return assetType;
	}

	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}

	public Integer getStorageconfigurationId() {
		return storageconfigurationId;
	}

	public void setStorageconfigurationId(Integer storageconfigurationId) {
		this.storageconfigurationId = storageconfigurationId;
	}

	public Integer getMigratetoconfigurationId() {
		return migratetoconfigurationId;
	}

	public void setMigratetoconfigurationId(Integer migratetoconfigurationId) {
		this.migratetoconfigurationId = migratetoconfigurationId;
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
