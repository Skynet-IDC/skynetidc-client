package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name = "tblpricing")
public class Tblpricing {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Lob
	@Column(name = "type", nullable = false)
	private String type;

	@NotNull
	@Column(name = "currency", nullable = false)
	private Integer currency;

	@NotNull
	@Column(name = "relid", nullable = false)
	private Integer relid;

	@NotNull
	@Column(name = "msetupfee", nullable = false, precision = 16, scale = 2)
	private BigDecimal msetupfee;

	@NotNull
	@Column(name = "qsetupfee", nullable = false, precision = 16, scale = 2)
	private BigDecimal qsetupfee;

	@NotNull
	@Column(name = "ssetupfee", nullable = false, precision = 16, scale = 2)
	private BigDecimal ssetupfee;

	@NotNull
	@Column(name = "asetupfee", nullable = false, precision = 16, scale = 2)
	private BigDecimal asetupfee;

	@NotNull
	@Column(name = "bsetupfee", nullable = false, precision = 16, scale = 2)
	private BigDecimal bsetupfee;

	@NotNull
	@Column(name = "tsetupfee", nullable = false, precision = 16, scale = 2)
	private BigDecimal tsetupfee;

	@NotNull
	@Column(name = "monthly", nullable = false, precision = 16, scale = 2)
	private BigDecimal monthly;

	@NotNull
	@Column(name = "quarterly", nullable = false, precision = 16, scale = 2)
	private BigDecimal quarterly;

	@NotNull
	@Column(name = "semiannually", nullable = false, precision = 16, scale = 2)
	private BigDecimal semiannually;

	@NotNull
	@Column(name = "annually", nullable = false, precision = 16, scale = 2)
	private BigDecimal annually;

	@NotNull
	@Column(name = "biennially", nullable = false, precision = 16, scale = 2)
	private BigDecimal biennially;

	@NotNull
	@Column(name = "triennially", nullable = false, precision = 16, scale = 2)
	private BigDecimal triennially;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getCurrency() {
		return currency;
	}

	public void setCurrency(Integer currency) {
		this.currency = currency;
	}

	public Integer getRelid() {
		return relid;
	}

	public void setRelid(Integer relid) {
		this.relid = relid;
	}

	public BigDecimal getMsetupfee() {
		return msetupfee;
	}

	public void setMsetupfee(BigDecimal msetupfee) {
		this.msetupfee = msetupfee;
	}

	public BigDecimal getQsetupfee() {
		return qsetupfee;
	}

	public void setQsetupfee(BigDecimal qsetupfee) {
		this.qsetupfee = qsetupfee;
	}

	public BigDecimal getSsetupfee() {
		return ssetupfee;
	}

	public void setSsetupfee(BigDecimal ssetupfee) {
		this.ssetupfee = ssetupfee;
	}

	public BigDecimal getAsetupfee() {
		return asetupfee;
	}

	public void setAsetupfee(BigDecimal asetupfee) {
		this.asetupfee = asetupfee;
	}

	public BigDecimal getBsetupfee() {
		return bsetupfee;
	}

	public void setBsetupfee(BigDecimal bsetupfee) {
		this.bsetupfee = bsetupfee;
	}

	public BigDecimal getTsetupfee() {
		return tsetupfee;
	}

	public void setTsetupfee(BigDecimal tsetupfee) {
		this.tsetupfee = tsetupfee;
	}

	public BigDecimal getMonthly() {
		return monthly;
	}

	public void setMonthly(BigDecimal monthly) {
		this.monthly = monthly;
	}

	public BigDecimal getQuarterly() {
		return quarterly;
	}

	public void setQuarterly(BigDecimal quarterly) {
		this.quarterly = quarterly;
	}

	public BigDecimal getSemiannually() {
		return semiannually;
	}

	public void setSemiannually(BigDecimal semiannually) {
		this.semiannually = semiannually;
	}

	public BigDecimal getAnnually() {
		return annually;
	}

	public void setAnnually(BigDecimal annually) {
		this.annually = annually;
	}

	public BigDecimal getBiennially() {
		return biennially;
	}

	public void setBiennially(BigDecimal biennially) {
		this.biennially = biennially;
	}

	public BigDecimal getTriennially() {
		return triennially;
	}

	public void setTriennially(BigDecimal triennially) {
		this.triennially = triennially;
	}

}
