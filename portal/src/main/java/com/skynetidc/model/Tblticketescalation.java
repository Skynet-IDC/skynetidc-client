package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "tblticketescalations")
public class Tblticketescalation {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Lob
	@Column(name = "name", nullable = false)
	private String name;

	@NotNull
	@Lob
	@Column(name = "departments", nullable = false)
	private String departments;

	@NotNull
	@Lob
	@Column(name = "statuses", nullable = false)
	private String statuses;

	@NotNull
	@Lob
	@Column(name = "priorities", nullable = false)
	private String priorities;

	@NotNull
	@Column(name = "timeelapsed", nullable = false)
	private Integer timeelapsed;

	@NotNull
	@Lob
	@Column(name = "newdepartment", nullable = false)
	private String newdepartment;

	@NotNull
	@Lob
	@Column(name = "newpriority", nullable = false)
	private String newpriority;

	@NotNull
	@Lob
	@Column(name = "newstatus", nullable = false)
	private String newstatus;

	@NotNull
	@Lob
	@Column(name = "flagto", nullable = false)
	private String flagto;

	@NotNull
	@Lob
	@Column(name = "notify", nullable = false)
	private String notify;

	@NotNull
	@Lob
	@Column(name = "addreply", nullable = false)
	private String addreply;

	@NotNull
	@ColumnDefault("'plain'")
	@Lob
	@Column(name = "editor", nullable = false)
	private String editor;

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

	public String getDepartments() {
		return departments;
	}

	public void setDepartments(String departments) {
		this.departments = departments;
	}

	public String getStatuses() {
		return statuses;
	}

	public void setStatuses(String statuses) {
		this.statuses = statuses;
	}

	public String getPriorities() {
		return priorities;
	}

	public void setPriorities(String priorities) {
		this.priorities = priorities;
	}

	public Integer getTimeelapsed() {
		return timeelapsed;
	}

	public void setTimeelapsed(Integer timeelapsed) {
		this.timeelapsed = timeelapsed;
	}

	public String getNewdepartment() {
		return newdepartment;
	}

	public void setNewdepartment(String newdepartment) {
		this.newdepartment = newdepartment;
	}

	public String getNewpriority() {
		return newpriority;
	}

	public void setNewpriority(String newpriority) {
		this.newpriority = newpriority;
	}

	public String getNewstatus() {
		return newstatus;
	}

	public void setNewstatus(String newstatus) {
		this.newstatus = newstatus;
	}

	public String getFlagto() {
		return flagto;
	}

	public void setFlagto(String flagto) {
		this.flagto = flagto;
	}

	public String getNotify() {
		return notify;
	}

	public void setNotify(String notify) {
		this.notify = notify;
	}

	public String getAddreply() {
		return addreply;
	}

	public void setAddreply(String addreply) {
		this.addreply = addreply;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

}
