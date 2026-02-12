package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "tblaffiliateshistory")
public class Tblaffiliateshistory {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Column(name = "affiliateid", nullable = false)
	private Integer affiliateid;

	@NotNull
	@Column(name = "date", nullable = false)
	private LocalDate date;

	@NotNull
	@Column(name = "affaccid", nullable = false)
	private Integer affaccid;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "invoice_id", nullable = false)
	private Integer invoiceId;

	@NotNull
	@Lob
	@Column(name = "description", nullable = false)
	private String description;

	@NotNull
	@Column(name = "amount", nullable = false, precision = 16, scale = 2)
	private BigDecimal amount;

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

	public Integer getAffiliateid() {
		return affiliateid;
	}

	public void setAffiliateid(Integer affiliateid) {
		this.affiliateid = affiliateid;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
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
