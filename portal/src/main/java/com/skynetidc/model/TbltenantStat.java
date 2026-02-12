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
@Table(name = "tbltenant_stats")
public class TbltenantStat {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "tenant_id", nullable = false)
	private Integer tenantId;

	@Size(max = 255)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "metric", nullable = false)
	private String metric;

	@Size(max = 255)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "type", nullable = false)
	private String type;

	@NotNull
	@ColumnDefault("0.000000")
	@Column(name = "value", nullable = false, precision = 19, scale = 6)
	private BigDecimal value;

	@NotNull
	@ColumnDefault("0.000000")
	@Column(name = "measured_at", nullable = false, precision = 18, scale = 6)
	private BigDecimal measuredAt;

	@ColumnDefault("0")
	@Column(name = "invoice_id")
	private Integer invoiceId;

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

	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}

	public String getMetric() {
		return metric;
	}

	public void setMetric(String metric) {
		this.metric = metric;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public BigDecimal getMeasuredAt() {
		return measuredAt;
	}

	public void setMeasuredAt(BigDecimal measuredAt) {
		this.measuredAt = measuredAt;
	}

	public Integer getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
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
