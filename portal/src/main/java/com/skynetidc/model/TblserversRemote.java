package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "tblservers_remote")
public class TblserversRemote {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "server_id", nullable = false)
	private Integer serverId;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "num_accounts", nullable = false)
	private Integer numAccounts;

	@NotNull
	@Lob
	@Column(name = "meta_data", nullable = false)
	private String metaData;

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

	public Integer getServerId() {
		return serverId;
	}

	public void setServerId(Integer serverId) {
		this.serverId = serverId;
	}

	public Integer getNumAccounts() {
		return numAccounts;
	}

	public void setNumAccounts(Integer numAccounts) {
		this.numAccounts = numAccounts;
	}

	public String getMetaData() {
		return metaData;
	}

	public void setMetaData(String metaData) {
		this.metaData = metaData;
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
