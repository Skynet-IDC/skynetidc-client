package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "tblmodule_configuration")
public class TblmoduleConfiguration {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@Size(max = 8)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "entity_type", nullable = false, length = 8)
	private String entityType;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "entity_id", nullable = false)
	private Integer entityId;

	@Size(max = 16)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "setting_name", nullable = false, length = 16)
	private String settingName;

	@Size(max = 64)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "friendly_name", nullable = false, length = 64)
	private String friendlyName;

	@NotNull
	@Lob
	@Column(name = "value", nullable = false)
	private String value;

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

	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	public Integer getEntityId() {
		return entityId;
	}

	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}

	public String getSettingName() {
		return settingName;
	}

	public void setSettingName(String settingName) {
		this.settingName = settingName;
	}

	public String getFriendlyName() {
		return friendlyName;
	}

	public void setFriendlyName(String friendlyName) {
		this.friendlyName = friendlyName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
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
