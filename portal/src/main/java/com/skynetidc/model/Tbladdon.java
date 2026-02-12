package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "tbladdons")
public class Tbladdon {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Lob
	@Column(name = "packages", nullable = false)
	private String packages;

	@NotNull
	@Lob
	@Column(name = "name", nullable = false)
	private String name;

	@NotNull
	@Lob
	@Column(name = "description", nullable = false)
	private String description;

	@NotNull
	@Lob
	@Column(name = "billingcycle", nullable = false)
	private String billingcycle;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "allowqty", nullable = false)
	private Byte allowqty;

	@NotNull
	@Column(name = "tax", nullable = false)
	private Boolean tax = false;

	@NotNull
	@Column(name = "showorder", nullable = false)
	private Boolean showorder = false;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "hidden", nullable = false)
	private Boolean hidden = false;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "retired", nullable = false)
	private Boolean retired = false;

	@NotNull
	@Lob
	@Column(name = "downloads", nullable = false)
	private String downloads;

	@NotNull
	@Lob
	@Column(name = "autoactivate", nullable = false)
	private String autoactivate;

	@NotNull
	@Column(name = "suspendproduct", nullable = false)
	private Boolean suspendproduct = false;

	@NotNull
	@Column(name = "welcomeemail", nullable = false)
	private Integer welcomeemail;

	@Size(max = 16)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "type", nullable = false, length = 16)
	private String type;

	@Size(max = 32)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "module", nullable = false, length = 32)
	private String module;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "server_group_id", nullable = false)
	private Integer serverGroupId;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "prorate", nullable = false)
	private Boolean prorate = false;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "weight", nullable = false)
	private Integer weight;

	@NotNull
	@Lob
	@Column(name = "autolinkby", nullable = false)
	private String autolinkby;

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

	public String getPackages() {
		return packages;
	}

	public void setPackages(String packages) {
		this.packages = packages;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBillingcycle() {
		return billingcycle;
	}

	public void setBillingcycle(String billingcycle) {
		this.billingcycle = billingcycle;
	}

	public Byte getAllowqty() {
		return allowqty;
	}

	public void setAllowqty(Byte allowqty) {
		this.allowqty = allowqty;
	}

	public Boolean getTax() {
		return tax;
	}

	public void setTax(Boolean tax) {
		this.tax = tax;
	}

	public Boolean getShoworder() {
		return showorder;
	}

	public void setShoworder(Boolean showorder) {
		this.showorder = showorder;
	}

	public Boolean getHidden() {
		return hidden;
	}

	public void setHidden(Boolean hidden) {
		this.hidden = hidden;
	}

	public Boolean getRetired() {
		return retired;
	}

	public void setRetired(Boolean retired) {
		this.retired = retired;
	}

	public String getDownloads() {
		return downloads;
	}

	public void setDownloads(String downloads) {
		this.downloads = downloads;
	}

	public String getAutoactivate() {
		return autoactivate;
	}

	public void setAutoactivate(String autoactivate) {
		this.autoactivate = autoactivate;
	}

	public Boolean getSuspendproduct() {
		return suspendproduct;
	}

	public void setSuspendproduct(Boolean suspendproduct) {
		this.suspendproduct = suspendproduct;
	}

	public Integer getWelcomeemail() {
		return welcomeemail;
	}

	public void setWelcomeemail(Integer welcomeemail) {
		this.welcomeemail = welcomeemail;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public Integer getServerGroupId() {
		return serverGroupId;
	}

	public void setServerGroupId(Integer serverGroupId) {
		this.serverGroupId = serverGroupId;
	}

	public Boolean getProrate() {
		return prorate;
	}

	public void setProrate(Boolean prorate) {
		this.prorate = prorate;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getAutolinkby() {
		return autolinkby;
	}

	public void setAutolinkby(String autolinkby) {
		this.autolinkby = autolinkby;
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
