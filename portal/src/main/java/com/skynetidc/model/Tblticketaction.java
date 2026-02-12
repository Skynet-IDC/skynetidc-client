package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "tblticketactions")
public class Tblticketaction {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Column(name = "ticket_id", nullable = false)
	private Integer ticketId;

	@Size(max = 256)
	@NotNull
	@Column(name = "action", nullable = false, length = 256)
	private String action;

	@Size(max = 50)
	@NotNull
	@Column(name = "status", nullable = false, length = 50)
	private String status;

	@Lob
	@Column(name = "parameters")
	private String parameters;

	@NotNull
	@Column(name = "scheduled", nullable = false)
	private Instant scheduled;

	@Column(name = "created_by_admin_id")
	private Integer createdByAdminId;

	@Column(name = "updated_by_admin_id")
	private Integer updatedByAdminId;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "skip_flags", nullable = false)
	private Short skipFlags;

	@NotNull
	@Column(name = "status_at", nullable = false)
	private Instant statusAt;

	@Size(max = 32)
	@Column(name = "processor_id", length = 32)
	private String processorId;

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

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

	public Instant getScheduled() {
		return scheduled;
	}

	public void setScheduled(Instant scheduled) {
		this.scheduled = scheduled;
	}

	public Integer getCreatedByAdminId() {
		return createdByAdminId;
	}

	public void setCreatedByAdminId(Integer createdByAdminId) {
		this.createdByAdminId = createdByAdminId;
	}

	public Integer getUpdatedByAdminId() {
		return updatedByAdminId;
	}

	public void setUpdatedByAdminId(Integer updatedByAdminId) {
		this.updatedByAdminId = updatedByAdminId;
	}

	public Short getSkipFlags() {
		return skipFlags;
	}

	public void setSkipFlags(Short skipFlags) {
		this.skipFlags = skipFlags;
	}

	public Instant getStatusAt() {
		return statusAt;
	}

	public void setStatusAt(Instant statusAt) {
		this.statusAt = statusAt;
	}

	public String getProcessorId() {
		return processorId;
	}

	public void setProcessorId(String processorId) {
		this.processorId = processorId;
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
