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
@Table(name = "tblapplinks_links")
public class TblapplinksLink {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "applink_id", nullable = false)
	private Integer applinkId;

	@Size(max = 80)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "scope", nullable = false, length = 80)
	private String scope;

	@Size(max = 256)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "display_label", nullable = false, length = 256)
	private String displayLabel;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "is_enabled", nullable = false)
	private Byte isEnabled;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "`order`", nullable = false)
	private Byte order;

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

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getDisplayLabel() {
		return displayLabel;
	}

	public void setDisplayLabel(String displayLabel) {
		this.displayLabel = displayLabel;
	}

	public Byte getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Byte isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Byte getOrder() {
		return order;
	}

	public void setOrder(Byte order) {
		this.order = order;
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
