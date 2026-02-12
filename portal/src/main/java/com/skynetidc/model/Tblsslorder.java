package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "tblsslorders")
public class Tblsslorder {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Column(name = "userid", nullable = false)
	private Integer userid;

	@NotNull
	@Column(name = "serviceid", nullable = false)
	private Integer serviceid;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "addon_id", nullable = false)
	private Integer addonId;

	@NotNull
	@Lob
	@Column(name = "remoteid", nullable = false)
	private String remoteid;

	@NotNull
	@Lob
	@Column(name = "module", nullable = false)
	private String module;

	@NotNull
	@Lob
	@Column(name = "certtype", nullable = false)
	private String certtype;

	@NotNull
	@Lob
	@Column(name = "configdata", nullable = false)
	private String configdata;

	@Lob
	@Column(name = "authdata")
	private String authdata;

	@NotNull
	@ColumnDefault("'0000-00-00 00:00:00'")
	@Column(name = "completiondate", nullable = false)
	private Instant completiondate;

	@NotNull
	@Lob
	@Column(name = "status", nullable = false)
	private String status;

	@Column(name = "certificate_expiry_date")
	private Instant certificateExpiryDate;

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

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getServiceid() {
		return serviceid;
	}

	public void setServiceid(Integer serviceid) {
		this.serviceid = serviceid;
	}

	public Integer getAddonId() {
		return addonId;
	}

	public void setAddonId(Integer addonId) {
		this.addonId = addonId;
	}

	public String getRemoteid() {
		return remoteid;
	}

	public void setRemoteid(String remoteid) {
		this.remoteid = remoteid;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getCerttype() {
		return certtype;
	}

	public void setCerttype(String certtype) {
		this.certtype = certtype;
	}

	public String getConfigdata() {
		return configdata;
	}

	public void setConfigdata(String configdata) {
		this.configdata = configdata;
	}

	public String getAuthdata() {
		return authdata;
	}

	public void setAuthdata(String authdata) {
		this.authdata = authdata;
	}

	public Instant getCompletiondate() {
		return completiondate;
	}

	public void setCompletiondate(Instant completiondate) {
		this.completiondate = completiondate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Instant getCertificateExpiryDate() {
		return certificateExpiryDate;
	}

	public void setCertificateExpiryDate(Instant certificateExpiryDate) {
		this.certificateExpiryDate = certificateExpiryDate;
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
