package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "tbladminlog")
public class Tbladminlog {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Lob
	@Column(name = "adminusername", nullable = false)
	private String adminusername;

	@NotNull
	@ColumnDefault("'0000-00-00 00:00:00'")
	@Column(name = "logintime", nullable = false)
	private Instant logintime;

	@NotNull
	@ColumnDefault("'0000-00-00 00:00:00'")
	@Column(name = "logouttime", nullable = false)
	private Instant logouttime;

	@NotNull
	@Lob
	@Column(name = "ipaddress", nullable = false)
	private String ipaddress;

	@NotNull
	@Lob
	@Column(name = "sessionid", nullable = false)
	private String sessionid;

	@NotNull
	@ColumnDefault("'0000-00-00 00:00:00'")
	@Column(name = "lastvisit", nullable = false)
	private Instant lastvisit;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAdminusername() {
		return adminusername;
	}

	public void setAdminusername(String adminusername) {
		this.adminusername = adminusername;
	}

	public Instant getLogintime() {
		return logintime;
	}

	public void setLogintime(Instant logintime) {
		this.logintime = logintime;
	}

	public Instant getLogouttime() {
		return logouttime;
	}

	public void setLogouttime(Instant logouttime) {
		this.logouttime = logouttime;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public String getSessionid() {
		return sessionid;
	}

	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}

	public Instant getLastvisit() {
		return lastvisit;
	}

	public void setLastvisit(Instant lastvisit) {
		this.lastvisit = lastvisit;
	}

}
