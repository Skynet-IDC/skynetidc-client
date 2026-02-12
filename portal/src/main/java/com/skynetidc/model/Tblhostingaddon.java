package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "tblhostingaddons")
public class Tblhostingaddon {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Column(name = "orderid", nullable = false)
	private Integer orderid;

	@NotNull
	@Column(name = "hostingid", nullable = false)
	private Integer hostingid;

	@NotNull
	@Column(name = "addonid", nullable = false)
	private Integer addonid;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "userid", nullable = false)
	private Integer userid;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "server", nullable = false)
	private Integer server;

	@NotNull
	@Lob
	@Column(name = "name", nullable = false)
	private String name;

	@NotNull
	@ColumnDefault("1")
	@Column(name = "qty", nullable = false)
	private Integer qty;

	@NotNull
	@ColumnDefault("0.00")
	@Column(name = "firstpaymentamount", nullable = false, precision = 16, scale = 2)
	private BigDecimal firstpaymentamount;

	@NotNull
	@ColumnDefault("0.00")
	@Column(name = "setupfee", nullable = false, precision = 16, scale = 2)
	private BigDecimal setupfee;

	@NotNull
	@ColumnDefault("0.00")
	@Column(name = "recurring", nullable = false, precision = 16, scale = 2)
	private BigDecimal recurring;

	@NotNull
	@Lob
	@Column(name = "billingcycle", nullable = false)
	private String billingcycle;

	@NotNull
	@Lob
	@Column(name = "tax", nullable = false)
	private String tax;

	@NotNull
	@ColumnDefault("'Pending'")
	@Lob
	@Column(name = "status", nullable = false)
	private String status;

	@NotNull
	@ColumnDefault("'0000-00-00'")
	@Column(name = "regdate", nullable = false)
	private LocalDate regdate;

	@Column(name = "nextduedate")
	private LocalDate nextduedate;

	@NotNull
	@Column(name = "nextinvoicedate", nullable = false)
	private LocalDate nextinvoicedate;

	@NotNull
	@ColumnDefault("'0000-00-00'")
	@Column(name = "termination_date", nullable = false)
	private LocalDate terminationDate;

	@NotNull
	@ColumnDefault("'0000-00-00'")
	@Column(name = "proratadate", nullable = false)
	private LocalDate proratadate;

	@NotNull
	@Lob
	@Column(name = "paymentmethod", nullable = false)
	private String paymentmethod;

	@NotNull
	@Lob
	@Column(name = "notes", nullable = false)
	private String notes;

	@Size(max = 128)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "subscriptionid", nullable = false, length = 128)
	private String subscriptionid;

	@Size(max = 40)
	@Column(name = "upsell_from_products", length = 40)
	private String upsellFromProducts;

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

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public Integer getHostingid() {
		return hostingid;
	}

	public void setHostingid(Integer hostingid) {
		this.hostingid = hostingid;
	}

	public Integer getAddonid() {
		return addonid;
	}

	public void setAddonid(Integer addonid) {
		this.addonid = addonid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getServer() {
		return server;
	}

	public void setServer(Integer server) {
		this.server = server;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public BigDecimal getFirstpaymentamount() {
		return firstpaymentamount;
	}

	public void setFirstpaymentamount(BigDecimal firstpaymentamount) {
		this.firstpaymentamount = firstpaymentamount;
	}

	public BigDecimal getSetupfee() {
		return setupfee;
	}

	public void setSetupfee(BigDecimal setupfee) {
		this.setupfee = setupfee;
	}

	public BigDecimal getRecurring() {
		return recurring;
	}

	public void setRecurring(BigDecimal recurring) {
		this.recurring = recurring;
	}

	public String getBillingcycle() {
		return billingcycle;
	}

	public void setBillingcycle(String billingcycle) {
		this.billingcycle = billingcycle;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getRegdate() {
		return regdate;
	}

	public void setRegdate(LocalDate regdate) {
		this.regdate = regdate;
	}

	public LocalDate getNextduedate() {
		return nextduedate;
	}

	public void setNextduedate(LocalDate nextduedate) {
		this.nextduedate = nextduedate;
	}

	public LocalDate getNextinvoicedate() {
		return nextinvoicedate;
	}

	public void setNextinvoicedate(LocalDate nextinvoicedate) {
		this.nextinvoicedate = nextinvoicedate;
	}

	public LocalDate getTerminationDate() {
		return terminationDate;
	}

	public void setTerminationDate(LocalDate terminationDate) {
		this.terminationDate = terminationDate;
	}

	public LocalDate getProratadate() {
		return proratadate;
	}

	public void setProratadate(LocalDate proratadate) {
		this.proratadate = proratadate;
	}

	public String getPaymentmethod() {
		return paymentmethod;
	}

	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getSubscriptionid() {
		return subscriptionid;
	}

	public void setSubscriptionid(String subscriptionid) {
		this.subscriptionid = subscriptionid;
	}

	public String getUpsellFromProducts() {
		return upsellFromProducts;
	}

	public void setUpsellFromProducts(String upsellFromProducts) {
		this.upsellFromProducts = upsellFromProducts;
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
