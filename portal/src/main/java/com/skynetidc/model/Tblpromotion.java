package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tblpromotions")
public class Tblpromotion {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Lob
	@Column(name = "code", nullable = false)
	private String code;

	@NotNull
	@Lob
	@Column(name = "type", nullable = false)
	private String type;

	@Column(name = "recurring")
	private Integer recurring;

	@NotNull
	@ColumnDefault("0.00")
	@Column(name = "value", nullable = false, precision = 16, scale = 2)
	private BigDecimal value;

	@NotNull
	@Lob
	@Column(name = "cycles", nullable = false)
	private String cycles;

	@NotNull
	@Lob
	@Column(name = "appliesto", nullable = false)
	private String appliesto;

	@NotNull
	@Lob
	@Column(name = "requires", nullable = false)
	private String requires;

	@NotNull
	@Column(name = "requiresexisting", nullable = false)
	private Integer requiresexisting;

	@NotNull
	@Column(name = "startdate", nullable = false)
	private LocalDate startdate;

	@Column(name = "expirationdate")
	private LocalDate expirationdate;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "maxuses", nullable = false)
	private Integer maxuses;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "uses", nullable = false)
	private Integer uses;

	@NotNull
	@Column(name = "lifetimepromo", nullable = false)
	private Integer lifetimepromo;

	@NotNull
	@Column(name = "applyonce", nullable = false)
	private Integer applyonce;

	@NotNull
	@Column(name = "newsignups", nullable = false)
	private Integer newsignups;

	@NotNull
	@Column(name = "existingclient", nullable = false)
	private Integer existingclient;

	@NotNull
	@Column(name = "onceperclient", nullable = false)
	private Integer onceperclient;

	@NotNull
	@Column(name = "recurfor", nullable = false)
	private Integer recurfor;

	@NotNull
	@Column(name = "upgrades", nullable = false)
	private Integer upgrades;

	@NotNull
	@Lob
	@Column(name = "upgradeconfig", nullable = false)
	private String upgradeconfig;

	@NotNull
	@Lob
	@Column(name = "notes", nullable = false)
	private String notes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getRecurring() {
		return recurring;
	}

	public void setRecurring(Integer recurring) {
		this.recurring = recurring;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public String getCycles() {
		return cycles;
	}

	public void setCycles(String cycles) {
		this.cycles = cycles;
	}

	public String getAppliesto() {
		return appliesto;
	}

	public void setAppliesto(String appliesto) {
		this.appliesto = appliesto;
	}

	public String getRequires() {
		return requires;
	}

	public void setRequires(String requires) {
		this.requires = requires;
	}

	public Integer getRequiresexisting() {
		return requiresexisting;
	}

	public void setRequiresexisting(Integer requiresexisting) {
		this.requiresexisting = requiresexisting;
	}

	public LocalDate getStartdate() {
		return startdate;
	}

	public void setStartdate(LocalDate startdate) {
		this.startdate = startdate;
	}

	public LocalDate getExpirationdate() {
		return expirationdate;
	}

	public void setExpirationdate(LocalDate expirationdate) {
		this.expirationdate = expirationdate;
	}

	public Integer getMaxuses() {
		return maxuses;
	}

	public void setMaxuses(Integer maxuses) {
		this.maxuses = maxuses;
	}

	public Integer getUses() {
		return uses;
	}

	public void setUses(Integer uses) {
		this.uses = uses;
	}

	public Integer getLifetimepromo() {
		return lifetimepromo;
	}

	public void setLifetimepromo(Integer lifetimepromo) {
		this.lifetimepromo = lifetimepromo;
	}

	public Integer getApplyonce() {
		return applyonce;
	}

	public void setApplyonce(Integer applyonce) {
		this.applyonce = applyonce;
	}

	public Integer getNewsignups() {
		return newsignups;
	}

	public void setNewsignups(Integer newsignups) {
		this.newsignups = newsignups;
	}

	public Integer getExistingclient() {
		return existingclient;
	}

	public void setExistingclient(Integer existingclient) {
		this.existingclient = existingclient;
	}

	public Integer getOnceperclient() {
		return onceperclient;
	}

	public void setOnceperclient(Integer onceperclient) {
		this.onceperclient = onceperclient;
	}

	public Integer getRecurfor() {
		return recurfor;
	}

	public void setRecurfor(Integer recurfor) {
		this.recurfor = recurfor;
	}

	public Integer getUpgrades() {
		return upgrades;
	}

	public void setUpgrades(Integer upgrades) {
		this.upgrades = upgrades;
	}

	public String getUpgradeconfig() {
		return upgradeconfig;
	}

	public void setUpgradeconfig(String upgradeconfig) {
		this.upgradeconfig = upgradeconfig;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
