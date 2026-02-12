package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "tbltask")
public class Tbltask {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "priority", nullable = false)
	private Integer priority;

	@Size(max = 255)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "class_name", nullable = false)
	private String className;

	@NotNull
	@ColumnDefault("1")
	@Column(name = "is_enabled", nullable = false)
	private Byte isEnabled;

	@NotNull
	@ColumnDefault("1")
	@Column(name = "is_periodic", nullable = false)
	private Byte isPeriodic;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "frequency", nullable = false)
	private Integer frequency;

	@Size(max = 255)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "name", nullable = false)
	private String name;

	@NotNull
	@Lob
	@Column(name = "description", nullable = false)
	private String description;

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

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Byte getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Byte isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Byte getIsPeriodic() {
		return isPeriodic;
	}

	public void setIsPeriodic(Byte isPeriodic) {
		this.isPeriodic = isPeriodic;
	}

	public Integer getFrequency() {
		return frequency;
	}

	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
