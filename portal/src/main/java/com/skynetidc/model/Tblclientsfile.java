package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "tblclientsfiles")
public class Tblclientsfile {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Column(name = "userid", nullable = false)
	private Integer userid;

	@NotNull
	@Lob
	@Column(name = "title", nullable = false)
	private String title;

	@NotNull
	@Lob
	@Column(name = "filename", nullable = false)
	private String filename;

	@NotNull
	@Column(name = "adminonly", nullable = false)
	private Integer adminonly;

	@NotNull
	@Column(name = "dateadded", nullable = false)
	private LocalDate dateadded;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Integer getAdminonly() {
		return adminonly;
	}

	public void setAdminonly(Integer adminonly) {
		this.adminonly = adminonly;
	}

	public LocalDate getDateadded() {
		return dateadded;
	}

	public void setDateadded(LocalDate dateadded) {
		this.dateadded = dateadded;
	}

}
