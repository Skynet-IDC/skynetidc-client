package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

@Entity
@Table(name = "tblticketfeedback")
public class Tblticketfeedback {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Column(name = "ticketid", nullable = false)
	private Integer ticketid;

	@NotNull
	@Column(name = "adminid", nullable = false)
	private Integer adminid;

	@NotNull
	@Column(name = "rating", nullable = false)
	private Integer rating;

	@NotNull
	@Lob
	@Column(name = "comments", nullable = false)
	private String comments;

	@NotNull
	@Column(name = "datetime", nullable = false)
	private Instant datetime;

	@NotNull
	@Lob
	@Column(name = "ip", nullable = false)
	private String ip;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTicketid() {
		return ticketid;
	}

	public void setTicketid(Integer ticketid) {
		this.ticketid = ticketid;
	}

	public Integer getAdminid() {
		return adminid;
	}

	public void setAdminid(Integer adminid) {
		this.adminid = adminid;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Instant getDatetime() {
		return datetime;
	}

	public void setDatetime(Instant datetime) {
		this.datetime = datetime;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}
