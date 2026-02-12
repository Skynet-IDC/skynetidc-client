package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tblbillableitems")
public class Tblbillableitem {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Column(name = "userid", nullable = false)
	private Integer userid;

	@NotNull
	@Lob
	@Column(name = "description", nullable = false)
	private String description;

	@NotNull
	@Column(name = "hours", nullable = false, precision = 5, scale = 2)
	private BigDecimal hours;

	@NotNull
	@Column(name = "amount", nullable = false, precision = 16, scale = 2)
	private BigDecimal amount;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "recur", nullable = false)
	private Integer recur;

	@NotNull
	@Lob
	@Column(name = "recurcycle", nullable = false)
	private String recurcycle;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "recurfor", nullable = false)
	private Integer recurfor;

	@NotNull
	@Column(name = "invoiceaction", nullable = false)
	private Integer invoiceaction;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "unit", nullable = false)
	private Boolean unit = false;

	@NotNull
	@Column(name = "duedate", nullable = false)
	private LocalDate duedate;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "invoicecount", nullable = false)
	private Integer invoicecount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getHours() {
		return hours;
	}

	public void setHours(BigDecimal hours) {
		this.hours = hours;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Integer getRecur() {
		return recur;
	}

	public void setRecur(Integer recur) {
		this.recur = recur;
	}

	public String getRecurcycle() {
		return recurcycle;
	}

	public void setRecurcycle(String recurcycle) {
		this.recurcycle = recurcycle;
	}

	public Integer getRecurfor() {
		return recurfor;
	}

	public void setRecurfor(Integer recurfor) {
		this.recurfor = recurfor;
	}

	public Integer getInvoiceaction() {
		return invoiceaction;
	}

	public void setInvoiceaction(Integer invoiceaction) {
		this.invoiceaction = invoiceaction;
	}

	public Boolean getUnit() {
		return unit;
	}

	public void setUnit(Boolean unit) {
		this.unit = unit;
	}

	public LocalDate getDuedate() {
		return duedate;
	}

	public void setDuedate(LocalDate duedate) {
		this.duedate = duedate;
	}

	public Integer getInvoicecount() {
		return invoicecount;
	}

	public void setInvoicecount(Integer invoicecount) {
		this.invoicecount = invoicecount;
	}

}
