package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "tbldownloads")
public class Tbldownload {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Column(name = "category", nullable = false)
	private Integer category;

	@NotNull
	@Lob
	@Column(name = "type", nullable = false)
	private String type;

	@NotNull
	@Lob
	@Column(name = "title", nullable = false)
	private String title;

	@NotNull
	@Lob
	@Column(name = "description", nullable = false)
	private String description;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "downloads", nullable = false)
	private Integer downloads;

	@NotNull
	@Lob
	@Column(name = "location", nullable = false)
	private String location;

	@NotNull
	@Column(name = "clientsonly", nullable = false)
	private Boolean clientsonly = false;

	@NotNull
	@Column(name = "hidden", nullable = false)
	private Boolean hidden = false;

	@NotNull
	@Column(name = "productdownload", nullable = false)
	private Boolean productdownload = false;

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

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getDownloads() {
		return downloads;
	}

	public void setDownloads(Integer downloads) {
		this.downloads = downloads;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Boolean getClientsonly() {
		return clientsonly;
	}

	public void setClientsonly(Boolean clientsonly) {
		this.clientsonly = clientsonly;
	}

	public Boolean getHidden() {
		return hidden;
	}

	public void setHidden(Boolean hidden) {
		this.hidden = hidden;
	}

	public Boolean getProductdownload() {
		return productdownload;
	}

	public void setProductdownload(Boolean productdownload) {
		this.productdownload = productdownload;
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
