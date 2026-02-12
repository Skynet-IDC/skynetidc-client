package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "tblnotes")
public class Tblnote {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Column(name = "userid", nullable = false)
	private Integer userid;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "adminid", nullable = false)
	private Integer adminid;

	@NotNull
	@Column(name = "created", nullable = false)
	private Instant created;

	@NotNull
	@Column(name = "modified", nullable = false)
	private Instant modified;

	@NotNull
	@Lob
	@Column(name = "note", nullable = false)
	private String note;

	@NotNull
	@Column(name = "sticky", nullable = false)
	private Integer sticky;

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

	public Integer getAdminid() {
		return adminid;
	}

	public void setAdminid(Integer adminid) {
		this.adminid = adminid;
	}

	public Instant getCreated() {
		return created;
	}

	public void setCreated(Instant created) {
		this.created = created;
	}

	public Instant getModified() {
		return modified;
	}

	public void setModified(Instant modified) {
		this.modified = modified;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getSticky() {
		return sticky;
	}

	public void setSticky(Integer sticky) {
		this.sticky = sticky;
	}

}
