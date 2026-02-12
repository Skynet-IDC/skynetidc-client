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
@Table(name = "tblmetric_usage")
public class TblmetricUsage {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@Size(max = 200)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "rel_type", nullable = false, length = 200)
	private String relType;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "rel_id", nullable = false)
	private Integer relId;

	@Size(max = 200)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "module_type", nullable = false, length = 200)
	private String moduleType;

	@Size(max = 200)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "module", nullable = false, length = 200)
	private String module;

	@Size(max = 200)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "metric", nullable = false, length = 200)
	private String metric;

	@Size(max = 255)
	@NotNull
	@ColumnDefault("''")
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

	public String getRelType() {
		return relType;
	}

	public void setRelType(String relType) {
		this.relType = relType;
	}

	public Integer getRelId() {
		return relId;
	}

	public void setRelId(Integer relId) {
		this.relId = relId;
	}

	public String getModuleType() {
		return moduleType;
	}

	public void setModuleType(String moduleType) {
		this.moduleType = moduleType;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getMetric() {
		return metric;
	}

	public void setMetric(String metric) {
		this.metric = metric;
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
