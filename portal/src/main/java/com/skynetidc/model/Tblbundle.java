package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tblbundles")
public class Tblbundle {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Lob
	@Column(name = "name", nullable = false)
	private String name;

	@NotNull
	@Column(name = "validfrom", nullable = false)
	private LocalDate validfrom;

	@NotNull
	@Column(name = "validuntil", nullable = false)
	private LocalDate validuntil;

	@NotNull
	@Column(name = "uses", nullable = false)
	private Integer uses;

	@NotNull
	@Column(name = "maxuses", nullable = false)
	private Integer maxuses;

	@NotNull
	@Lob
	@Column(name = "itemdata", nullable = false)
	private String itemdata;

	@NotNull
	@Column(name = "allowpromo", nullable = false)
	private Integer allowpromo;

	@NotNull
	@Column(name = "showgroup", nullable = false)
	private Integer showgroup;

	@NotNull
	@Column(name = "gid", nullable = false)
	private Integer gid;

	@NotNull
	@Lob
	@Column(name = "description", nullable = false)
	private String description;

	@NotNull
	@Column(name = "displayprice", nullable = false, precision = 16, scale = 2)
	private BigDecimal displayprice;

	@NotNull
	@Column(name = "sortorder", nullable = false)
	private Integer sortorder;

	@NotNull
	@Column(name = "is_featured", nullable = false)
	private Boolean isFeatured = false;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getValidfrom() {
		return validfrom;
	}

	public void setValidfrom(LocalDate validfrom) {
		this.validfrom = validfrom;
	}

	public LocalDate getValiduntil() {
		return validuntil;
	}

	public void setValiduntil(LocalDate validuntil) {
		this.validuntil = validuntil;
	}

	public Integer getUses() {
		return uses;
	}

	public void setUses(Integer uses) {
		this.uses = uses;
	}

	public Integer getMaxuses() {
		return maxuses;
	}

	public void setMaxuses(Integer maxuses) {
		this.maxuses = maxuses;
	}

	public String getItemdata() {
		return itemdata;
	}

	public void setItemdata(String itemdata) {
		this.itemdata = itemdata;
	}

	public Integer getAllowpromo() {
		return allowpromo;
	}

	public void setAllowpromo(Integer allowpromo) {
		this.allowpromo = allowpromo;
	}

	public Integer getShowgroup() {
		return showgroup;
	}

	public void setShowgroup(Integer showgroup) {
		this.showgroup = showgroup;
	}

	public Integer getGid() {
		return gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getDisplayprice() {
		return displayprice;
	}

	public void setDisplayprice(BigDecimal displayprice) {
		this.displayprice = displayprice;
	}

	public Integer getSortorder() {
		return sortorder;
	}

	public void setSortorder(Integer sortorder) {
		this.sortorder = sortorder;
	}

	public Boolean getIsFeatured() {
		return isFeatured;
	}

	public void setIsFeatured(Boolean isFeatured) {
		this.isFeatured = isFeatured;
	}

}
