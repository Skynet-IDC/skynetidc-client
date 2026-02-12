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
@Table(name = "tblapplinks_log")
public class TblapplinksLog {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "applink_id", nullable = false)
	private Integer applinkId;

	@Size(max = 2000)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "message", nullable = false, length = 2000)
	private String message;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "level", nullable = false)
	private Integer level;

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

	public Integer getApplinkId() {
		return applinkId;
	}

	public void setApplinkId(Integer applinkId) {
		this.applinkId = applinkId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
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
