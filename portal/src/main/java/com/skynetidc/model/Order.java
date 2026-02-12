package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Instant;

@Entity
@Table(name = "tblorders")
public class Order {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Column(name = "ordernum", nullable = false)
	private BigInteger ordernum;

	@NotNull
	@Column(name = "userid", nullable = false)
	private Long userid;

	@NotNull
	@Column(name = "contactid", nullable = false)
	private Integer contactid;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "requestor_id", nullable = false)
	private Long requestorId;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "admin_requestor_id", nullable = false)
	private Integer adminRequestorId;

	@NotNull
	@Column(name = "date", nullable = false)
	private Instant date;

	@NotNull
	@Lob
	@Column(name = "nameservers", nullable = false)
	private String nameservers;

	@NotNull
	@Lob
	@Column(name = "transfersecret", nullable = false)
	private String transfersecret;

	@NotNull
	@Lob
	@Column(name = "renewals", nullable = false)
	private String renewals;

	@NotNull
	@Lob
	@Column(name = "promocode", nullable = false)
	private String promocode;

	@NotNull
	@Lob
	@Column(name = "promotype", nullable = false)
	private String promotype;

	@NotNull
	@Lob
	@Column(name = "promovalue", nullable = false)
	private String promovalue;

	@NotNull
	@Lob
	@Column(name = "orderdata", nullable = false)
	private String orderdata;

	@NotNull
	@Column(name = "amount", nullable = false, precision = 16, scale = 2)
	private BigDecimal amount;

	@NotNull
	@Lob
	@Column(name = "paymentmethod", nullable = false)
	private String paymentmethod;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "invoiceid", nullable = false)
	private Integer invoiceid;

	@NotNull
	@Lob
	@Column(name = "status", nullable = false)
	private String status;

	@NotNull
	@Lob
	@Column(name = "ipaddress", nullable = false)
	private String ipaddress;

	@NotNull
	@Lob
	@Column(name = "fraudmodule", nullable = false)
	private String fraudmodule;

	@NotNull
	@Lob
	@Column(name = "fraudoutput", nullable = false)
	private String fraudoutput;

	@NotNull
	@Lob
	@Column(name = "notes", nullable = false)
	private String notes;

	@NotNull
	@ColumnDefault("4")
	@Column(name = "purchase_source", nullable = false)
	private Integer purchaseSource;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "has_referral_products", nullable = false)
	private Short hasReferralProducts;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigInteger getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(BigInteger ordernum) {
		this.ordernum = ordernum;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Integer getContactid() {
		return contactid;
	}

	public void setContactid(Integer contactid) {
		this.contactid = contactid;
	}

	public Long getRequestorId() {
		return requestorId;
	}

	public void setRequestorId(Long requestorId) {
		this.requestorId = requestorId;
	}

	public Integer getAdminRequestorId() {
		return adminRequestorId;
	}

	public void setAdminRequestorId(Integer adminRequestorId) {
		this.adminRequestorId = adminRequestorId;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public String getNameservers() {
		return nameservers;
	}

	public void setNameservers(String nameservers) {
		this.nameservers = nameservers;
	}

	public String getTransfersecret() {
		return transfersecret;
	}

	public void setTransfersecret(String transfersecret) {
		this.transfersecret = transfersecret;
	}

	public String getRenewals() {
		return renewals;
	}

	public void setRenewals(String renewals) {
		this.renewals = renewals;
	}

	public String getPromocode() {
		return promocode;
	}

	public void setPromocode(String promocode) {
		this.promocode = promocode;
	}

	public String getPromotype() {
		return promotype;
	}

	public void setPromotype(String promotype) {
		this.promotype = promotype;
	}

	public String getPromovalue() {
		return promovalue;
	}

	public void setPromovalue(String promovalue) {
		this.promovalue = promovalue;
	}

	public String getOrderdata() {
		return orderdata;
	}

	public void setOrderdata(String orderdata) {
		this.orderdata = orderdata;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getPaymentmethod() {
		return paymentmethod;
	}

	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}

	public Integer getInvoiceid() {
		return invoiceid;
	}

	public void setInvoiceid(Integer invoiceid) {
		this.invoiceid = invoiceid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public String getFraudmodule() {
		return fraudmodule;
	}

	public void setFraudmodule(String fraudmodule) {
		this.fraudmodule = fraudmodule;
	}

	public String getFraudoutput() {
		return fraudoutput;
	}

	public void setFraudoutput(String fraudoutput) {
		this.fraudoutput = fraudoutput;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Integer getPurchaseSource() {
		return purchaseSource;
	}

	public void setPurchaseSource(Integer purchaseSource) {
		this.purchaseSource = purchaseSource;
	}

	public Short getHasReferralProducts() {
		return hasReferralProducts;
	}

	public void setHasReferralProducts(Short hasReferralProducts) {
		this.hasReferralProducts = hasReferralProducts;
	}

}
