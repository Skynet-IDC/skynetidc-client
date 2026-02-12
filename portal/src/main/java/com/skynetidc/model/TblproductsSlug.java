package com.skynetidc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "tblproducts_slugs")
public class TblproductsSlug {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Column(name = "product_id", nullable = false)
	private Integer productId;

	@NotNull
	@Column(name = "group_id", nullable = false)
	private Integer groupId;

	@Size(max = 255)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "group_slug", nullable = false)
	private String groupSlug;

	@Size(max = 255)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "slug", nullable = false)
	private String slug;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "active", nullable = false)
	private Boolean active = false;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "clicks", nullable = false)
	private Integer clicks;

	@Column(name = "created_at")
	private Instant createdAt;

	@Column(name = "updated_at")
	private Instant updatedAt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getGroupSlug() {
		return groupSlug;
	}

	public void setGroupSlug(String groupSlug) {
		this.groupSlug = groupSlug;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Integer getClicks() {
		return clicks;
	}

	public void setClicks(Integer clicks) {
		this.clicks = clicks;
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
