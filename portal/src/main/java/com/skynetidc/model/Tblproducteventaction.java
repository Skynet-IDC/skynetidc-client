package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.Instant;

@Entity
@Table(name = "tblproducteventactions")
public class Tblproducteventaction {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@Size(max = 16)
	@NotNull
	@Column(name = "entity_type", nullable = false, length = 16)
	private String entityType;

	@NotNull
	@Column(name = "entity_id", nullable = false)
	private Integer entityId;

	@Size(max = 64)
	@NotNull
	@Column(name = "name", nullable = false, length = 64)
	private String name;

	@Size(max = 32)
	@NotNull
	@Column(name = "event_name", nullable = false, length = 32)
	private String eventName;

	@Size(max = 64)
	@NotNull
	@Column(name = "action", nullable = false, length = 64)
	private String action;

	@Lob
	@Column(name = "params")
	private String params;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
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
