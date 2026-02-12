package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "tblproductgroups")
public class Tblproductgroup {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Lob
	@Column(name = "name", nullable = false)
	private String name;

	@Size(max = 128)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "slug", nullable = false, length = 128)
	private String slug;

	@Lob
	@Column(name = "headline")
	private String headline;

	@Lob
	@Column(name = "tagline")
	private String tagline;

	@NotNull
	@Lob
	@Column(name = "orderfrmtpl", nullable = false)
	private String orderfrmtpl;

	@NotNull
	@Lob
	@Column(name = "disabledgateways", nullable = false)
	private String disabledgateways;

	@NotNull
	@Column(name = "hidden", nullable = false)
	private Boolean hidden = false;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "`order`", nullable = false)
	private Integer order;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getTagline() {
		return tagline;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	public String getOrderfrmtpl() {
		return orderfrmtpl;
	}

	public void setOrderfrmtpl(String orderfrmtpl) {
		this.orderfrmtpl = orderfrmtpl;
	}

	public String getDisabledgateways() {
		return disabledgateways;
	}

	public void setDisabledgateways(String disabledgateways) {
		this.disabledgateways = disabledgateways;
	}

	public Boolean getHidden() {
		return hidden;
	}

	public void setHidden(Boolean hidden) {
		this.hidden = hidden;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
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
