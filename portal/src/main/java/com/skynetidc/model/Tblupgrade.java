package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tblupgrades")
public class Tblupgrade {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Column(name = "userid", nullable = false)
	private Integer userid;

	@NotNull
	@Column(name = "orderid", nullable = false)
	private Integer orderid;

	@NotNull
	@Lob
	@Column(name = "type", nullable = false)
	private String type;

	@NotNull
	@Column(name = "date", nullable = false)
	private LocalDate date;

	@NotNull
	@Column(name = "relid", nullable = false)
	private Integer relid;

	@NotNull
	@Lob
	@Column(name = "originalvalue", nullable = false)
	private String originalvalue;

	@NotNull
	@Lob
	@Column(name = "newvalue", nullable = false)
	private String newvalue;

	@Size(max = 30)
	@NotNull
	@Column(name = "new_cycle", nullable = false, length = 30)
	private String newCycle;

	@NotNull
	@Column(name = "amount", nullable = false, precision = 16, scale = 2)
	private BigDecimal amount;

	@NotNull
	@Column(name = "credit_amount", nullable = false, precision = 16, scale = 2)
	private BigDecimal creditAmount;

	@NotNull
	@Column(name = "days_remaining", nullable = false)
	private Integer daysRemaining;

	@NotNull
	@Column(name = "total_days_in_cycle", nullable = false)
	private Integer totalDaysInCycle;

	@NotNull
	@Column(name = "new_recurring_amount", nullable = false, precision = 16, scale = 2)
	private BigDecimal newRecurringAmount;

	@NotNull
	@Column(name = "recurringchange", nullable = false, precision = 16, scale = 2)
	private BigDecimal recurringchange;

	@NotNull
	@ColumnDefault("'Pending'")
	@Lob
	@Column(name = "status", nullable = false)
	private String status;

	@NotNull
	@ColumnDefault("'N'")
	@Lob
	@Column(name = "paid", nullable = false)
	private String paid;

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

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Integer getRelid() {
		return relid;
	}

	public void setRelid(Integer relid) {
		this.relid = relid;
	}

	public String getOriginalvalue() {
		return originalvalue;
	}

	public void setOriginalvalue(String originalvalue) {
		this.originalvalue = originalvalue;
	}

	public String getNewvalue() {
		return newvalue;
	}

	public void setNewvalue(String newvalue) {
		this.newvalue = newvalue;
	}

	public String getNewCycle() {
		return newCycle;
	}

	public void setNewCycle(String newCycle) {
		this.newCycle = newCycle;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(BigDecimal creditAmount) {
		this.creditAmount = creditAmount;
	}

	public Integer getDaysRemaining() {
		return daysRemaining;
	}

	public void setDaysRemaining(Integer daysRemaining) {
		this.daysRemaining = daysRemaining;
	}

	public Integer getTotalDaysInCycle() {
		return totalDaysInCycle;
	}

	public void setTotalDaysInCycle(Integer totalDaysInCycle) {
		this.totalDaysInCycle = totalDaysInCycle;
	}

	public BigDecimal getNewRecurringAmount() {
		return newRecurringAmount;
	}

	public void setNewRecurringAmount(BigDecimal newRecurringAmount) {
		this.newRecurringAmount = newRecurringAmount;
	}

	public BigDecimal getRecurringchange() {
		return recurringchange;
	}

	public void setRecurringchange(BigDecimal recurringchange) {
		this.recurringchange = recurringchange;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPaid() {
		return paid;
	}

	public void setPaid(String paid) {
		this.paid = paid;
	}

}
