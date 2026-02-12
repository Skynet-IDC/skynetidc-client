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
@Table(name = "tblpricing_bracket")
public class TblpricingBracket {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@ColumnDefault("0.000000")
	@Column(name = "floor", nullable = false, precision = 19, scale = 6)
	private BigDecimal floor;

	@NotNull
	@ColumnDefault("0.000000")
	@Column(name = "ceiling", nullable = false, precision = 19, scale = 6)
	private BigDecimal ceiling;

	@Size(max = 200)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "rel_type", nullable = false, length = 200)
	private String relType;

	@Size(max = 200)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "rel_id", nullable = false, length = 200)
	private String relId;

	@Size(max = 32)
	@NotNull
	@ColumnDefault("'flat'")
	@Column(name = "schema_type", nullable = false, length = 32)
	private String schemaType;

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

	public BigDecimal getFloor() {
		return floor;
	}

	public void setFloor(BigDecimal floor) {
		this.floor = floor;
	}

	public BigDecimal getCeiling() {
		return ceiling;
	}

	public void setCeiling(BigDecimal ceiling) {
		this.ceiling = ceiling;
	}

	public String getRelType() {
		return relType;
	}

	public void setRelType(String relType) {
		this.relType = relType;
	}

	public String getRelId() {
		return relId;
	}

	public void setRelId(String relId) {
		this.relId = relId;
	}

	public String getSchemaType() {
		return schemaType;
	}

	public void setSchemaType(String schemaType) {
		this.schemaType = schemaType;
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
