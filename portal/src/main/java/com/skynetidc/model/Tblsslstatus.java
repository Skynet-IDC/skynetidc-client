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
@Table(name = "tblsslstatus")
public class Tblsslstatus {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "user_id", nullable = false)
	private Integer userId;

	@Size(max = 128)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "domain_name", nullable = false, length = 128)
	private String domainName;

	@Size(max = 128)
	@ColumnDefault("''")
	@Column(name = "subject_name", length = 128)
	private String subjectName;

	@Size(max = 128)
	@ColumnDefault("''")
	@Column(name = "subject_org", length = 128)
	private String subjectOrg;

	@Size(max = 128)
	@ColumnDefault("''")
	@Column(name = "issuer_name", length = 128)
	private String issuerName;

	@Size(max = 128)
	@ColumnDefault("''")
	@Column(name = "issuer_org", length = 128)
	private String issuerOrg;

	@Column(name = "start_date")
	private Instant startDate;

	@Column(name = "expiry_date")
	private Instant expiryDate;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "active", nullable = false)
	private Boolean active = false;

	@Column(name = "last_synced_date")
	private Instant lastSyncedDate;

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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectOrg() {
		return subjectOrg;
	}

	public void setSubjectOrg(String subjectOrg) {
		this.subjectOrg = subjectOrg;
	}

	public String getIssuerName() {
		return issuerName;
	}

	public void setIssuerName(String issuerName) {
		this.issuerName = issuerName;
	}

	public String getIssuerOrg() {
		return issuerOrg;
	}

	public void setIssuerOrg(String issuerOrg) {
		this.issuerOrg = issuerOrg;
	}

	public Instant getStartDate() {
		return startDate;
	}

	public void setStartDate(Instant startDate) {
		this.startDate = startDate;
	}

	public Instant getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Instant expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Instant getLastSyncedDate() {
		return lastSyncedDate;
	}

	public void setLastSyncedDate(Instant lastSyncedDate) {
		this.lastSyncedDate = lastSyncedDate;
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
