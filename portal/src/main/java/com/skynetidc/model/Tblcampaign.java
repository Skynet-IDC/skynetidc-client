package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "tblcampaigns")
public class Tblcampaign {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "admin_id", nullable = false)
	private Integer adminId;

	@Size(max = 250)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "name", nullable = false, length = 250)
	private String name;

	@Lob
	@Column(name = "configuration")
	private String configuration;

	@Lob
	@Column(name = "message_data")
	private String messageData;

	@Column(name = "sending_start_at")
	private Instant sendingStartAt;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "draft", nullable = false)
	private Boolean draft = false;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "started", nullable = false)
	private Boolean started = false;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "paused", nullable = false)
	private Boolean paused = false;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "position", nullable = false)
	private Integer position;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "completed", nullable = false)
	private Boolean completed = false;

	@Column(name = "completed_at")
	private Instant completedAt;

	@Column(name = "queue_completed_at")
	private Instant queueCompletedAt;

	@Column(name = "created_at")
	private Instant createdAt;

	@Column(name = "updated_at")
	private Instant updatedAt;

	@Column(name = "deleted_at")
	private Instant deletedAt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getConfiguration() {
		return configuration;
	}

	public void setConfiguration(String configuration) {
		this.configuration = configuration;
	}

	public String getMessageData() {
		return messageData;
	}

	public void setMessageData(String messageData) {
		this.messageData = messageData;
	}

	public Instant getSendingStartAt() {
		return sendingStartAt;
	}

	public void setSendingStartAt(Instant sendingStartAt) {
		this.sendingStartAt = sendingStartAt;
	}

	public Boolean getDraft() {
		return draft;
	}

	public void setDraft(Boolean draft) {
		this.draft = draft;
	}

	public Boolean getStarted() {
		return started;
	}

	public void setStarted(Boolean started) {
		this.started = started;
	}

	public Boolean getPaused() {
		return paused;
	}

	public void setPaused(Boolean paused) {
		this.paused = paused;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

	public Instant getCompletedAt() {
		return completedAt;
	}

	public void setCompletedAt(Instant completedAt) {
		this.completedAt = completedAt;
	}

	public Instant getQueueCompletedAt() {
		return queueCompletedAt;
	}

	public void setQueueCompletedAt(Instant queueCompletedAt) {
		this.queueCompletedAt = queueCompletedAt;
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

	public Instant getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Instant deletedAt) {
		this.deletedAt = deletedAt;
	}

}
