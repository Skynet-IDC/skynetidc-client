package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "tblondemandrenewals")
public class Tblondemandrenewal {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Lob
	@Column(name = "rel_type", nullable = false)
	private String relType;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "rel_id", nullable = false)
	private Integer relId;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "enabled", nullable = false)
	private Byte enabled;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "monthly", nullable = false)
	private Byte monthly;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "quarterly", nullable = false)
	private Byte quarterly;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "semiannually", nullable = false)
	private Short semiannually;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "annually", nullable = false)
	private Short annually;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "biennially", nullable = false)
	private Short biennially;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "triennially", nullable = false)
	private Short triennially;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRelType() {
		return relType;
	}

	public void setRelType(String relType) {
		this.relType = relType;
	}

	public Integer getRelId() {
		return relId;
	}

	public void setRelId(Integer relId) {
		this.relId = relId;
	}

	public Byte getEnabled() {
		return enabled;
	}

	public void setEnabled(Byte enabled) {
		this.enabled = enabled;
	}

	public Byte getMonthly() {
		return monthly;
	}

	public void setMonthly(Byte monthly) {
		this.monthly = monthly;
	}

	public Byte getQuarterly() {
		return quarterly;
	}

	public void setQuarterly(Byte quarterly) {
		this.quarterly = quarterly;
	}

	public Short getSemiannually() {
		return semiannually;
	}

	public void setSemiannually(Short semiannually) {
		this.semiannually = semiannually;
	}

	public Short getAnnually() {
		return annually;
	}

	public void setAnnually(Short annually) {
		this.annually = annually;
	}

	public Short getBiennially() {
		return biennially;
	}

	public void setBiennially(Short biennially) {
		this.biennially = biennially;
	}

	public Short getTriennially() {
		return triennially;
	}

	public void setTriennially(Short triennially) {
		this.triennially = triennially;
	}

}
