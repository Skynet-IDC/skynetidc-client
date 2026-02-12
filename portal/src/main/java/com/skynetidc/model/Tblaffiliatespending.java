package com.skynetidc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "tblaffiliatespending")
public class Tblaffiliatespending {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "affaccid", nullable = false)
	private Integer affaccid;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "invoice_id", nullable = false)
	private Integer invoiceId;

	@NotNull
	@Column(name = "amount", nullable = false, precision = 16, scale = 2)
	private BigDecimal amount;

	@NotNull
	@Column(name = "clearingdate", nullable = false)
	private LocalDate clearingdate;

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

	public Integer getAffaccid() {
		return affaccid;
	}

	public void setAffaccid(Integer affaccid) {
		this.affaccid = affaccid;
	}

	public Integer getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public LocalDate getClearingdate() {
		return clearingdate;
	}

	public void setClearingdate(LocalDate clearingdate) {
		this.clearingdate = clearingdate;
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
