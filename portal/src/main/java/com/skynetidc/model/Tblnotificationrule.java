package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "tblnotificationrules")
public class Tblnotificationrule {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@Size(max = 255)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "description", nullable = false)
	private String description;

	@Size(max = 255)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "event_type", nullable = false)
	private String eventType;

	@Size(max = 255)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "events", nullable = false)
	private String events;

	@NotNull
	@Lob
	@Column(name = "conditions", nullable = false)
	private String conditions;

	@Size(max = 255)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "provider", nullable = false)
	private String provider;

	@NotNull
	@Lob
	@Column(name = "provider_config", nullable = false)
	private String providerConfig;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "active", nullable = false)
	private Byte active;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "can_delete", nullable = false)
	private Byte canDelete;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getEvents() {
		return events;
	}

	public void setEvents(String events) {
		this.events = events;
	}

	public String getConditions() {
		return conditions;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getProviderConfig() {
		return providerConfig;
	}

	public void setProviderConfig(String providerConfig) {
		this.providerConfig = providerConfig;
	}

	public Byte getActive() {
		return active;
	}

	public void setActive(Byte active) {
		this.active = active;
	}

	public Byte getCanDelete() {
		return canDelete;
	}

	public void setCanDelete(Byte canDelete) {
		this.canDelete = canDelete;
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
