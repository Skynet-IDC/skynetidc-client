package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "tblfileassetmigrationprogress")
public class Tblfileassetmigrationprogress {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@Size(max = 64)
	@NotNull
	@Column(name = "asset_type", nullable = false, length = 64)
	private String assetType;

	@NotNull
	@Lob
	@Column(name = "migrated_objects", nullable = false)
	private String migratedObjects;

	@ColumnDefault("0")
	@Column(name = "num_objects_migrated")
	private Integer numObjectsMigrated;

	@ColumnDefault("0")
	@Column(name = "num_objects_total")
	private Integer numObjectsTotal;

	@ColumnDefault("1")
	@Column(name = "active")
	private Boolean active;

	@ColumnDefault("0")
	@Column(name = "num_failures")
	private Integer numFailures;

	@NotNull
	@Lob
	@Column(name = "last_failure_reason", nullable = false)
	private String lastFailureReason;

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

	public String getMigratedObjects() {
		return migratedObjects;
	}

	public void setMigratedObjects(String migratedObjects) {
		this.migratedObjects = migratedObjects;
	}

	public Integer getNumObjectsMigrated() {
		return numObjectsMigrated;
	}

	public void setNumObjectsMigrated(Integer numObjectsMigrated) {
		this.numObjectsMigrated = numObjectsMigrated;
	}

	public Integer getNumObjectsTotal() {
		return numObjectsTotal;
	}

	public void setNumObjectsTotal(Integer numObjectsTotal) {
		this.numObjectsTotal = numObjectsTotal;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Integer getNumFailures() {
		return numFailures;
	}

	public void setNumFailures(Integer numFailures) {
		this.numFailures = numFailures;
	}

	public String getLastFailureReason() {
		return lastFailureReason;
	}

	public void setLastFailureReason(String lastFailureReason) {
		this.lastFailureReason = lastFailureReason;
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
