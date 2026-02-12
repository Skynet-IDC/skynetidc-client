package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "tbldomains")
public class Tbldomain {

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
	@Column(name = "registrationdate", nullable = false)
	private LocalDate registrationdate;

	@NotNull
	@Lob
	@Column(name = "domain", nullable = false)
	private String domain;

	@NotNull
	@ColumnDefault("0.00")
	@Column(name = "firstpaymentamount", nullable = false, precision = 16, scale = 2)
	private BigDecimal firstpaymentamount;

	@NotNull
	@Column(name = "recurringamount", nullable = false, precision = 16, scale = 2)
	private BigDecimal recurringamount;

	@NotNull
	@Lob
	@Column(name = "registrar", nullable = false)
	private String registrar;

	@NotNull
	@ColumnDefault("1")
	@Column(name = "registrationperiod", nullable = false)
	private Integer registrationperiod;

	@Column(name = "expirydate")
	private LocalDate expirydate;

	@NotNull
	@Lob
	@Column(name = "subscriptionid", nullable = false)
	private String subscriptionid;

	@NotNull
	@Column(name = "promoid", nullable = false)
	private Integer promoid;

	@NotNull
	@ColumnDefault("'Pending'")
	@Lob
	@Column(name = "status", nullable = false)
	private String status;

	@NotNull
	@ColumnDefault("'0000-00-00'")
	@Column(name = "nextduedate", nullable = false)
	private LocalDate nextduedate;

	@NotNull
	@Column(name = "nextinvoicedate", nullable = false)
	private LocalDate nextinvoicedate;

	@NotNull
	@Lob
	@Column(name = "additionalnotes", nullable = false)
	private String additionalnotes;

	@NotNull
	@Lob
	@Column(name = "paymentmethod", nullable = false)
	private String paymentmethod;

	@NotNull
	@Column(name = "dnsmanagement", nullable = false)
	private Boolean dnsmanagement = false;

	@NotNull
	@Column(name = "emailforwarding", nullable = false)
	private Boolean emailforwarding = false;

	@NotNull
	@Column(name = "idprotection", nullable = false)
	private Boolean idprotection = false;

	@Column(name = "is_premium")
	private Boolean isPremium;

	@NotNull
	@Column(name = "donotrenew", nullable = false)
	private Boolean donotrenew = false;

	@NotNull
	@Lob
	@Column(name = "reminders", nullable = false)
	private String reminders;

	@NotNull
	@Column(name = "synced", nullable = false)
	private Boolean synced = false;

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

	public LocalDate getRegistrationdate() {
		return registrationdate;
	}

	public void setRegistrationdate(LocalDate registrationdate) {
		this.registrationdate = registrationdate;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public BigDecimal getFirstpaymentamount() {
		return firstpaymentamount;
	}

	public void setFirstpaymentamount(BigDecimal firstpaymentamount) {
		this.firstpaymentamount = firstpaymentamount;
	}

	public BigDecimal getRecurringamount() {
		return recurringamount;
	}

	public void setRecurringamount(BigDecimal recurringamount) {
		this.recurringamount = recurringamount;
	}

	public String getRegistrar() {
		return registrar;
	}

	public void setRegistrar(String registrar) {
		this.registrar = registrar;
	}

	public Integer getRegistrationperiod() {
		return registrationperiod;
	}

	public void setRegistrationperiod(Integer registrationperiod) {
		this.registrationperiod = registrationperiod;
	}

	public LocalDate getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(LocalDate expirydate) {
		this.expirydate = expirydate;
	}

	public String getSubscriptionid() {
		return subscriptionid;
	}

	public void setSubscriptionid(String subscriptionid) {
		this.subscriptionid = subscriptionid;
	}

	public Integer getPromoid() {
		return promoid;
	}

	public void setPromoid(Integer promoid) {
		this.promoid = promoid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getAdditionalnotes() {
		return additionalnotes;
	}

	public void setAdditionalnotes(String additionalnotes) {
		this.additionalnotes = additionalnotes;
	}

	public String getPaymentmethod() {
		return paymentmethod;
	}

	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}

	public Boolean getDnsmanagement() {
		return dnsmanagement;
	}

	public void setDnsmanagement(Boolean dnsmanagement) {
		this.dnsmanagement = dnsmanagement;
	}

	public Boolean getEmailforwarding() {
		return emailforwarding;
	}

	public void setEmailforwarding(Boolean emailforwarding) {
		this.emailforwarding = emailforwarding;
	}

	public Boolean getIdprotection() {
		return idprotection;
	}

	public void setIdprotection(Boolean idprotection) {
		this.idprotection = idprotection;
	}

	public Boolean getIsPremium() {
		return isPremium;
	}

	public void setIsPremium(Boolean isPremium) {
		this.isPremium = isPremium;
	}

	public Boolean getDonotrenew() {
		return donotrenew;
	}

	public void setDonotrenew(Boolean donotrenew) {
		this.donotrenew = donotrenew;
	}

	public String getReminders() {
		return reminders;
	}

	public void setReminders(String reminders) {
		this.reminders = reminders;
	}

	public Boolean getSynced() {
		return synced;
	}

	public void setSynced(Boolean synced) {
		this.synced = synced;
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
