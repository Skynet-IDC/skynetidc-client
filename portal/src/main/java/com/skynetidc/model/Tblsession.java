package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tblsessions")
public class Tblsession {

	@Id
	@Column(name = "id", nullable = false)
	private Long id;

	@Size(max = 255)
	@NotNull
	@Column(name = "session_id", nullable = false)
	private String sessionId;

	@NotNull
	@Lob
	@Column(name = "payload", nullable = false)
	private String payload;

	@NotNull
	@Column(name = "last_activity", nullable = false)
	private Integer lastActivity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	public Integer getLastActivity() {
		return lastActivity;
	}

	public void setLastActivity(Integer lastActivity) {
		this.lastActivity = lastActivity;
	}

}
