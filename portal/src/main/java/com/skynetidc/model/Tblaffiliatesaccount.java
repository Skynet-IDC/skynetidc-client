package com.skynetidc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "tblaffiliatesaccounts")
public class Tblaffiliatesaccount {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Column(name = "affiliateid", nullable = false)
	private Integer affiliateid;

	@NotNull
	@Column(name = "relid", nullable = false)
	private Integer relid;

	@NotNull
	@ColumnDefault("'0000-00-00'")
	@Column(name = "lastpaid", nullable = false)
	private LocalDate lastpaid;

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

	public Integer getAffiliateid() {
		return affiliateid;
	}

	public void setAffiliateid(Integer affiliateid) {
		this.affiliateid = affiliateid;
	}

	public Integer getRelid() {
		return relid;
	}

	public void setRelid(Integer relid) {
		this.relid = relid;
	}

	public LocalDate getLastpaid() {
		return lastpaid;
	}

	public void setLastpaid(LocalDate lastpaid) {
		this.lastpaid = lastpaid;
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
