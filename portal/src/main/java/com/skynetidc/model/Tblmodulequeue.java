package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "tblmodulequeue")
public class Tblmodulequeue {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@Size(max = 20)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "service_type", nullable = false, length = 20)
	private String serviceType;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "service_id", nullable = false)
	private Integer serviceId;

	@Size(max = 64)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "module_name", nullable = false, length = 64)
	private String moduleName;

	@Size(max = 64)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "module_action", nullable = false, length = 64)
	private String moduleAction;

	@NotNull
	@ColumnDefault("'0000-00-00 00:00:00'")
	@Column(name = "last_attempt", nullable = false)
	private Instant lastAttempt;

	@NotNull
	@Lob
	@Column(name = "last_attempt_error", nullable = false)
	private String lastAttemptError;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "num_retries", nullable = false)
	private Short numRetries;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "completed", nullable = false)
	private Boolean completed = false;

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

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getModuleAction() {
		return moduleAction;
	}

	public void setModuleAction(String moduleAction) {
		this.moduleAction = moduleAction;
	}

	public Instant getLastAttempt() {
		return lastAttempt;
	}

	public void setLastAttempt(Instant lastAttempt) {
		this.lastAttempt = lastAttempt;
	}

	public String getLastAttemptError() {
		return lastAttemptError;
	}

	public void setLastAttemptError(String lastAttemptError) {
		this.lastAttemptError = lastAttemptError;
	}

	public Short getNumRetries() {
		return numRetries;
	}

	public void setNumRetries(Short numRetries) {
		this.numRetries = numRetries;
	}

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
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
