package com.skynetidc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "tbltask_status")
public class TbltaskStatus {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Column(name = "task_id", nullable = false)
	private Integer taskId;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "in_progress", nullable = false)
	private Byte inProgress;

	@NotNull
	@ColumnDefault("'0000-00-00 00:00:00'")
	@Column(name = "last_run", nullable = false)
	private Instant lastRun;

	@NotNull
	@ColumnDefault("'0000-00-00 00:00:00'")
	@Column(name = "next_due", nullable = false)
	private Instant nextDue;

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

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public Byte getInProgress() {
		return inProgress;
	}

	public void setInProgress(Byte inProgress) {
		this.inProgress = inProgress;
	}

	public Instant getLastRun() {
		return lastRun;
	}

	public void setLastRun(Instant lastRun) {
		this.lastRun = lastRun;
	}

	public Instant getNextDue() {
		return nextDue;
	}

	public void setNextDue(Instant nextDue) {
		this.nextDue = nextDue;
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
