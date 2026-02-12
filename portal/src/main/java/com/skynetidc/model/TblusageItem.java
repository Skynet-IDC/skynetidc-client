package com.skynetidc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "tblusage_items")
public class TblusageItem {

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

	@NotNull
	@ColumnDefault("0.000000")
	@Column(name = "included", nullable = false, precision = 19, scale = 6)
	private BigDecimal included;

	@NotNull
	@ColumnDefault("1")
	@Column(name = "is_hidden", nullable = false)
	private Byte isHidden;

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

	public BigDecimal getIncluded() {
		return included;
	}

	public void setIncluded(BigDecimal included) {
		this.included = included;
	}

	public Byte getIsHidden() {
		return isHidden;
	}

	public void setIsHidden(Byte isHidden) {
		this.isHidden = isHidden;
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
