package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "tblaccounts")
public class Tblaccount {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Column(name = "userid", nullable = false)
	private Integer userid;

	@NotNull
	@Column(name = "currency", nullable = false)
	private Integer currency;

	@NotNull
	@Lob
	@Column(name = "gateway", nullable = false)
	private String gateway;

	@Column(name = "date")
	private Instant date;

	@NotNull
	@Lob
	@Column(name = "description", nullable = false)
	private String description;

	@NotNull
	@ColumnDefault("0.00")
	@Column(name = "amountin", nullable = false, precision = 16, scale = 2)
	private BigDecimal amountin;

	@NotNull
	@ColumnDefault("0.00")
	@Column(name = "fees", nullable = false, precision = 16, scale = 2)
	private BigDecimal fees;

	@NotNull
	@ColumnDefault("0.00")
	@Column(name = "amountout", nullable = false, precision = 16, scale = 2)
	private BigDecimal amountout;

	@NotNull
	@ColumnDefault("1.00000")
	@Column(name = "rate", nullable = false, precision = 16, scale = 5)
	private BigDecimal rate;

	@NotNull
	@Lob
	@Column(name = "transid", nullable = false)
	private String transid;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "invoiceid", nullable = false)
	private Integer invoiceid;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "refundid", nullable = false)
	private Integer refundid;

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

	public Integer getCurrency() {
		return currency;
	}

	public void setCurrency(Integer currency) {
		this.currency = currency;
	}

	public String getGateway() {
		return gateway;
	}

	public void setGateway(String gateway) {
		this.gateway = gateway;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getAmountin() {
		return amountin;
	}

	public void setAmountin(BigDecimal amountin) {
		this.amountin = amountin;
	}

	public BigDecimal getFees() {
		return fees;
	}

	public void setFees(BigDecimal fees) {
		this.fees = fees;
	}

	public BigDecimal getAmountout() {
		return amountout;
	}

	public void setAmountout(BigDecimal amountout) {
		this.amountout = amountout;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public String getTransid() {
		return transid;
	}

	public void setTransid(String transid) {
		this.transid = transid;
	}

	public Integer getInvoiceid() {
		return invoiceid;
	}

	public void setInvoiceid(Integer invoiceid) {
		this.invoiceid = invoiceid;
	}

	public Integer getRefundid() {
		return refundid;
	}

	public void setRefundid(Integer refundid) {
		this.refundid = refundid;
	}

}
