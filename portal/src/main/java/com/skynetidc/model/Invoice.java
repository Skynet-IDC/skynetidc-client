package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "tblinvoices")
public class Invoice {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Column(name = "userid", nullable = false)
	private Integer userid;

	@NotNull
	@Lob
	@Column(name = "invoicenum", nullable = false)
	private String invoicenum;

	@Column(name = "date")
	private LocalDate date;

	@Column(name = "duedate")
	private LocalDate duedate;

	@NotNull
	@ColumnDefault("'0000-00-00 00:00:00'")
	@Column(name = "datepaid", nullable = false)
	private Instant datepaid;

	@NotNull
	@ColumnDefault("'0000-00-00 00:00:00'")
	@Column(name = "last_capture_attempt", nullable = false)
	private Instant lastCaptureAttempt;

	@NotNull
	@ColumnDefault("'0000-00-00 00:00:00'")
	@Column(name = "date_refunded", nullable = false)
	private Instant dateRefunded;

	@NotNull
	@ColumnDefault("'0000-00-00 00:00:00'")
	@Column(name = "date_cancelled", nullable = false)
	private Instant dateCancelled;

	@NotNull
	@Column(name = "subtotal", nullable = false, precision = 16, scale = 2)
	private BigDecimal subtotal;

	@NotNull
	@Column(name = "credit", nullable = false, precision = 16, scale = 2)
	private BigDecimal credit;

	@NotNull
	@Column(name = "tax", nullable = false, precision = 16, scale = 2)
	private BigDecimal tax;

	@NotNull
	@Column(name = "tax2", nullable = false, precision = 16, scale = 2)
	private BigDecimal tax2;

	@NotNull
	@ColumnDefault("0.00")
	@Column(name = "total", nullable = false, precision = 16, scale = 2)
	private BigDecimal total;

	@NotNull
	@ColumnDefault("0.000")
	@Column(name = "taxrate", nullable = false, precision = 10, scale = 3)
	private BigDecimal taxrate;

	@NotNull
	@ColumnDefault("0.000")
	@Column(name = "taxrate2", nullable = false, precision = 10, scale = 3)
	private BigDecimal taxrate2;

	@NotNull
	@Lob
	@Column(name = "status", nullable = false)
	private String status;

	@NotNull
	@Lob
	@Column(name = "paymentmethod", nullable = false)
	private String paymentmethod;

	@Column(name = "paymethodid")
	private Integer paymethodid;

	@NotNull
	@Lob
	@Column(name = "notes", nullable = false)
	private String notes;

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

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getInvoicenum() {
		return invoicenum;
	}

	public void setInvoicenum(String invoicenum) {
		this.invoicenum = invoicenum;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalDate getDuedate() {
		return duedate;
	}

	public void setDuedate(LocalDate duedate) {
		this.duedate = duedate;
	}

	public Instant getDatepaid() {
		return datepaid;
	}

	public void setDatepaid(Instant datepaid) {
		this.datepaid = datepaid;
	}

	public Instant getLastCaptureAttempt() {
		return lastCaptureAttempt;
	}

	public void setLastCaptureAttempt(Instant lastCaptureAttempt) {
		this.lastCaptureAttempt = lastCaptureAttempt;
	}

	public Instant getDateRefunded() {
		return dateRefunded;
	}

	public void setDateRefunded(Instant dateRefunded) {
		this.dateRefunded = dateRefunded;
	}

	public Instant getDateCancelled() {
		return dateCancelled;
	}

	public void setDateCancelled(Instant dateCancelled) {
		this.dateCancelled = dateCancelled;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public BigDecimal getCredit() {
		return credit;
	}

	public void setCredit(BigDecimal credit) {
		this.credit = credit;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public BigDecimal getTax2() {
		return tax2;
	}

	public void setTax2(BigDecimal tax2) {
		this.tax2 = tax2;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public BigDecimal getTaxrate() {
		return taxrate;
	}

	public void setTaxrate(BigDecimal taxrate) {
		this.taxrate = taxrate;
	}

	public BigDecimal getTaxrate2() {
		return taxrate2;
	}

	public void setTaxrate2(BigDecimal taxrate2) {
		this.taxrate2 = taxrate2;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPaymentmethod() {
		return paymentmethod;
	}

	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}

	public Integer getPaymethodid() {
		return paymethodid;
	}

	public void setPaymethodid(Integer paymethodid) {
		this.paymethodid = paymethodid;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
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
