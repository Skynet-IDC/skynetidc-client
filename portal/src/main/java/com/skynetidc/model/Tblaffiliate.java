package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "tblaffiliates")
public class Tblaffiliate {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "date")
	private LocalDate date;

	@NotNull
	@Column(name = "clientid", nullable = false)
	private Integer clientid;

	@NotNull
	@Column(name = "visitors", nullable = false)
	private Integer visitors;

	@NotNull
	@Lob
	@Column(name = "paytype", nullable = false)
	private String paytype;

	@NotNull
	@Column(name = "payamount", nullable = false, precision = 16, scale = 2)
	private BigDecimal payamount;

	@NotNull
	@Column(name = "onetime", nullable = false)
	private Integer onetime;

	@NotNull
	@ColumnDefault("0.00")
	@Column(name = "balance", nullable = false, precision = 16, scale = 2)
	private BigDecimal balance;

	@NotNull
	@ColumnDefault("0.00")
	@Column(name = "withdrawn", nullable = false, precision = 16, scale = 2)
	private BigDecimal withdrawn;

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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Integer getClientid() {
		return clientid;
	}

	public void setClientid(Integer clientid) {
		this.clientid = clientid;
	}

	public Integer getVisitors() {
		return visitors;
	}

	public void setVisitors(Integer visitors) {
		this.visitors = visitors;
	}

	public String getPaytype() {
		return paytype;
	}

	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}

	public BigDecimal getPayamount() {
		return payamount;
	}

	public void setPayamount(BigDecimal payamount) {
		this.payamount = payamount;
	}

	public Integer getOnetime() {
		return onetime;
	}

	public void setOnetime(Integer onetime) {
		this.onetime = onetime;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public BigDecimal getWithdrawn() {
		return withdrawn;
	}

	public void setWithdrawn(BigDecimal withdrawn) {
		this.withdrawn = withdrawn;
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
