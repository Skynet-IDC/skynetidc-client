package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "tblnetworkissues")
public class Tblnetworkissue {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@Size(max = 150)
	@NotNull
	@Column(name = "title", nullable = false, length = 150)
	private String title;

	@NotNull
	@Lob
	@Column(name = "description", nullable = false)
	private String description;

	@NotNull
	@Lob
	@Column(name = "type", nullable = false)
	private String type;

	@Size(max = 100)
	@Column(name = "affecting", length = 100)
	private String affecting;

	@Column(name = "server")
	private Integer server;

	@NotNull
	@Lob
	@Column(name = "priority", nullable = false)
	private String priority;

	@NotNull
	@Column(name = "startdate", nullable = false)
	private Instant startdate;

	@Column(name = "enddate")
	private Instant enddate;

	@NotNull
	@Lob
	@Column(name = "status", nullable = false)
	private String status;

	@NotNull
	@Column(name = "lastupdate", nullable = false)
	private Instant lastupdate;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAffecting() {
		return affecting;
	}

	public void setAffecting(String affecting) {
		this.affecting = affecting;
	}

	public Integer getServer() {
		return server;
	}

	public void setServer(Integer server) {
		this.server = server;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Instant getStartdate() {
		return startdate;
	}

	public void setStartdate(Instant startdate) {
		this.startdate = startdate;
	}

	public Instant getEnddate() {
		return enddate;
	}

	public void setEnddate(Instant enddate) {
		this.enddate = enddate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Instant getLastupdate() {
		return lastupdate;
	}

	public void setLastupdate(Instant lastupdate) {
		this.lastupdate = lastupdate;
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
