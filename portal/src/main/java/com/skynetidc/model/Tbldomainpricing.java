package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "tbldomainpricing")
public class Tbldomainpricing {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Lob
	@Column(name = "extension", nullable = false)
	private String extension;

	@NotNull
	@Column(name = "dnsmanagement", nullable = false)
	private Boolean dnsmanagement = false;

	@NotNull
	@Column(name = "emailforwarding", nullable = false)
	private Boolean emailforwarding = false;

	@NotNull
	@Column(name = "idprotection", nullable = false)
	private Boolean idprotection = false;

	@NotNull
	@Column(name = "eppcode", nullable = false)
	private Boolean eppcode = false;

	@NotNull
	@Lob
	@Column(name = "autoreg", nullable = false)
	private String autoreg;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "`order`", nullable = false)
	private Integer order;

	@Size(max = 5)
	@NotNull
	@ColumnDefault("'none'")
	@Column(name = "`group`", nullable = false, length = 5)
	private String group;

	@NotNull
	@ColumnDefault("-1")
	@Column(name = "grace_period", nullable = false)
	private Integer gracePeriod;

	@NotNull
	@ColumnDefault("0.00")
	@Column(name = "grace_period_fee", nullable = false, precision = 16, scale = 2)
	private BigDecimal gracePeriodFee;

	@NotNull
	@ColumnDefault("-1")
	@Column(name = "redemption_grace_period", nullable = false)
	private Integer redemptionGracePeriod;

	@NotNull
	@ColumnDefault("-1.00")
	@Column(name = "redemption_grace_period_fee", nullable = false, precision = 16, scale = 2)
	private BigDecimal redemptionGracePeriodFee;

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

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
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

	public Boolean getEppcode() {
		return eppcode;
	}

	public void setEppcode(Boolean eppcode) {
		this.eppcode = eppcode;
	}

	public String getAutoreg() {
		return autoreg;
	}

	public void setAutoreg(String autoreg) {
		this.autoreg = autoreg;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public Integer getGracePeriod() {
		return gracePeriod;
	}

	public void setGracePeriod(Integer gracePeriod) {
		this.gracePeriod = gracePeriod;
	}

	public BigDecimal getGracePeriodFee() {
		return gracePeriodFee;
	}

	public void setGracePeriodFee(BigDecimal gracePeriodFee) {
		this.gracePeriodFee = gracePeriodFee;
	}

	public Integer getRedemptionGracePeriod() {
		return redemptionGracePeriod;
	}

	public void setRedemptionGracePeriod(Integer redemptionGracePeriod) {
		this.redemptionGracePeriod = redemptionGracePeriod;
	}

	public BigDecimal getRedemptionGracePeriodFee() {
		return redemptionGracePeriodFee;
	}

	public void setRedemptionGracePeriodFee(BigDecimal redemptionGracePeriodFee) {
		this.redemptionGracePeriodFee = redemptionGracePeriodFee;
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
