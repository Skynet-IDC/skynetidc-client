package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "tbljobs_queue")
public class TbljobsQueue {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@Size(max = 255)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "name", nullable = false)
	private String name;

	@Size(max = 255)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "class_name", nullable = false)
	private String className;

	@Size(max = 255)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "method_name", nullable = false)
	private String methodName;

	@NotNull
	@Lob
	@Column(name = "input_parameters", nullable = false)
	private String inputParameters;

	@NotNull
	@Column(name = "available_at", nullable = false)
	private Instant availableAt;

	@Column(name = "started_at")
	private Instant startedAt;

	@Size(max = 255)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "digest_hash", nullable = false)
	private String digestHash;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "async", nullable = false)
	private Boolean async = false;

	@NotNull
	@Column(name = "created_at", nullable = false)
	private Instant createdAt;

	@NotNull
	@Column(name = "updated_at", nullable = false)
	private Instant updatedAt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getInputParameters() {
		return inputParameters;
	}

	public void setInputParameters(String inputParameters) {
		this.inputParameters = inputParameters;
	}

	public Instant getAvailableAt() {
		return availableAt;
	}

	public void setAvailableAt(Instant availableAt) {
		this.availableAt = availableAt;
	}

	public Instant getStartedAt() {
		return startedAt;
	}

	public void setStartedAt(Instant startedAt) {
		this.startedAt = startedAt;
	}

	public String getDigestHash() {
		return digestHash;
	}

	public void setDigestHash(String digestHash) {
		this.digestHash = digestHash;
	}

	public Boolean getAsync() {
		return async;
	}

	public void setAsync(Boolean async) {
		this.async = async;
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
