package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

@Entity
@Table(name = "tblbannedips")
public class Tblbannedip {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Lob
	@Column(name = "ip", nullable = false)
	private String ip;

	@NotNull
	@Lob
	@Column(name = "reason", nullable = false)
	private String reason;

	@NotNull
	@Column(name = "expires", nullable = false)
	private Instant expires;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Instant getExpires() {
		return expires;
	}

	public void setExpires(Instant expires) {
		this.expires = expires;
	}

}
