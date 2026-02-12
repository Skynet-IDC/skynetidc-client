package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tblcalendar")
public class Tblcalendar {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Lob
	@Column(name = "title", nullable = false)
	private String title;

	@NotNull
	@Lob
	@Column(name = "`desc`", nullable = false)
	private String desc;

	@NotNull
	@Column(name = "start", nullable = false)
	private Integer start;

	@NotNull
	@Column(name = "end", nullable = false)
	private Integer end;

	@NotNull
	@Column(name = "allday", nullable = false)
	private Integer allday;

	@NotNull
	@Column(name = "adminid", nullable = false)
	private Integer adminid;

	@NotNull
	@Column(name = "recurid", nullable = false)
	private Integer recurid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	public Integer getAllday() {
		return allday;
	}

	public void setAllday(Integer allday) {
		this.allday = allday;
	}

	public Integer getAdminid() {
		return adminid;
	}

	public void setAdminid(Integer adminid) {
		this.adminid = adminid;
	}

	public Integer getRecurid() {
		return recurid;
	}

	public void setRecurid(Integer recurid) {
		this.recurid = recurid;
	}

}
