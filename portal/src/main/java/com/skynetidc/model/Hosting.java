package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "tblhosting")
public class Hosting {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@NotNull
	@Column(name = "userid", nullable = false)
	private Long userid;

	@NotNull
	@Column(name = "orderid", nullable = false)
	private Long orderid;

	@NotNull
	@Column(name = "packageid", nullable = false)
	private Long packageid;

	@NotNull
	@Column(name = "server", nullable = false)
	private Long server;

	@NotNull
	@Column(name = "regdate", nullable = false)
	private LocalDate regdate;

	@NotNull
	@Lob
	@Column(name = "domain", nullable = false)
	private String domain;

	@NotNull
	@Lob
	@Column(name = "paymentmethod", nullable = false)
	private String paymentmethod;

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
	@Column(name = "amount", nullable = false, precision = 16, scale = 2)
	private BigDecimal amount;

	@NotNull
	@Lob
	@Column(name = "billingcycle", nullable = false)
	private String billingcycle;

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
	@Column(name = "completed_date", nullable = false)
	private LocalDate completedDate;

	@NotNull
	@ColumnDefault("'Pending'")
	@Lob
	@Column(name = "domainstatus", nullable = false)
	private String domainStatus;

	@NotNull
	@Lob
	@Column(name = "username", nullable = false)
	private String username;

	@NotNull
	@Lob
	@Column(name = "password", nullable = false)
	private String password;

	@NotNull
	@Lob
	@Column(name = "notes", nullable = false)
	private String notes;

	@NotNull
	@Lob
	@Column(name = "subscriptionid", nullable = false)
	private String subscriptionid;

	@Column(name = "recommendation_source_product_id")
	private Integer recommendationSourceProductId;

	@NotNull
	@Column(name = "promoid", nullable = false)
	private Integer promoid;

	@ColumnDefault("0")
	@Column(name = "promocount")
	private Integer promocount;

	@NotNull
	@Lob
	@Column(name = "suspendreason", nullable = false)
	private String suspendreason;

	@NotNull
	@Column(name = "overideautosuspend", nullable = false)
	private Boolean overideautosuspend = false;

	@NotNull
	@Column(name = "overidesuspenduntil", nullable = false)
	private LocalDate overidesuspenduntil;

	@NotNull
	@Lob
	@Column(name = "dedicatedip", nullable = false)
	private String dedicatedip;

	@NotNull
	@Lob
	@Column(name = "assignedips", nullable = false)
	private String assignedips;

	@NotNull
	@Lob
	@Column(name = "ns1", nullable = false)
	private String ns1;

	@NotNull
	@Lob
	@Column(name = "ns2", nullable = false)
	private String ns2;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "diskusage", nullable = false)
	private Integer diskusage;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "disklimit", nullable = false)
	private Integer disklimit;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "bwusage", nullable = false)
	private Integer bwusage;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "bwlimit", nullable = false)
	private Integer bwlimit;

	@Size(max = 40)
	@Column(name = "upsell_from_products", length = 40)
	private String upsellFromProducts;

	@NotNull
	@ColumnDefault("'0000-00-00 00:00:00'")
	@Column(name = "lastupdate", nullable = false)
	private Instant lastUpdate;

	@NotNull
	@ColumnDefault("'0000-00-00 00:00:00'")
	@Column(name = "created_at", nullable = false)
	private Instant createdAt;

	@NotNull
	@ColumnDefault("'0000-00-00 00:00:00'")
	@Column(name = "updated_at", nullable = false)
	private Instant updatedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Long getOrderid() {
		return orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	public Long getPackageid() {
		return packageid;
	}

	public void setPackageid(Long packageid) {
		this.packageid = packageid;
	}

	public Long getServer() {
		return server;
	}

	public void setServer(Long server) {
		this.server = server;
	}

	public LocalDate getRegdate() {
		return regdate;
	}

	public void setRegdate(LocalDate regdate) {
		this.regdate = regdate;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getPaymentmethod() {
		return paymentmethod;
	}

	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
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

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getBillingcycle() {
		return billingcycle;
	}

	public void setBillingcycle(String billingcycle) {
		this.billingcycle = billingcycle;
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

	public LocalDate getCompletedDate() {
		return completedDate;
	}

	public void setCompletedDate(LocalDate completedDate) {
		this.completedDate = completedDate;
	}

	public String getDomainStatus() {
		return domainStatus;
	}

	public void setDomainStatus(String domainStatus) {
		this.domainStatus = domainStatus;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Integer getRecommendationSourceProductId() {
		return recommendationSourceProductId;
	}

	public void setRecommendationSourceProductId(Integer recommendationSourceProductId) {
		this.recommendationSourceProductId = recommendationSourceProductId;
	}

	public Integer getPromoid() {
		return promoid;
	}

	public void setPromoid(Integer promoid) {
		this.promoid = promoid;
	}

	public Integer getPromocount() {
		return promocount;
	}

	public void setPromocount(Integer promocount) {
		this.promocount = promocount;
	}

	public String getSuspendreason() {
		return suspendreason;
	}

	public void setSuspendreason(String suspendreason) {
		this.suspendreason = suspendreason;
	}

	public Boolean getOverideautosuspend() {
		return overideautosuspend;
	}

	public void setOverideautosuspend(Boolean overideautosuspend) {
		this.overideautosuspend = overideautosuspend;
	}

	public LocalDate getOveridesuspenduntil() {
		return overidesuspenduntil;
	}

	public void setOveridesuspenduntil(LocalDate overidesuspenduntil) {
		this.overidesuspenduntil = overidesuspenduntil;
	}

	public String getDedicatedip() {
		return dedicatedip;
	}

	public void setDedicatedip(String dedicatedip) {
		this.dedicatedip = dedicatedip;
	}

	public String getAssignedips() {
		return assignedips;
	}

	public void setAssignedips(String assignedips) {
		this.assignedips = assignedips;
	}

	public String getNs1() {
		return ns1;
	}

	public void setNs1(String ns1) {
		this.ns1 = ns1;
	}

	public String getNs2() {
		return ns2;
	}

	public void setNs2(String ns2) {
		this.ns2 = ns2;
	}

	public Integer getDiskusage() {
		return diskusage;
	}

	public void setDiskusage(Integer diskusage) {
		this.diskusage = diskusage;
	}

	public Integer getDisklimit() {
		return disklimit;
	}

	public void setDisklimit(Integer disklimit) {
		this.disklimit = disklimit;
	}

	public Integer getBwusage() {
		return bwusage;
	}

	public void setBwusage(Integer bwusage) {
		this.bwusage = bwusage;
	}

	public Integer getBwlimit() {
		return bwlimit;
	}

	public void setBwlimit(Integer bwlimit) {
		this.bwlimit = bwlimit;
	}

	public String getUpsellFromProducts() {
		return upsellFromProducts;
	}

	public void setUpsellFromProducts(String upsellFromProducts) {
		this.upsellFromProducts = upsellFromProducts;
	}

	public Instant getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Instant lastUpdate) {
		this.lastUpdate = lastUpdate;
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
