package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "tblcustomfields")
public class Tblcustomfield {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Lob
	@Column(name = "type", nullable = false)
	private String type;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "relid", nullable = false)
	private Integer relid;

	@NotNull
	@Lob
	@Column(name = "fieldname", nullable = false)
	private String fieldname;

	@NotNull
	@Lob
	@Column(name = "fieldtype", nullable = false)
	private String fieldtype;

	@NotNull
	@Lob
	@Column(name = "description", nullable = false)
	private String description;

	@NotNull
	@Lob
	@Column(name = "fieldoptions", nullable = false)
	private String fieldoptions;

	@NotNull
	@Lob
	@Column(name = "regexpr", nullable = false)
	private String regexpr;

	@NotNull
	@Lob
	@Column(name = "adminonly", nullable = false)
	private String adminonly;

	@NotNull
	@Lob
	@Column(name = "required", nullable = false)
	private String required;

	@NotNull
	@Lob
	@Column(name = "showorder", nullable = false)
	private String showorder;

	@NotNull
	@Lob
	@Column(name = "showinvoice", nullable = false)
	private String showinvoice;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "sortorder", nullable = false)
	private Integer sortorder;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getRelid() {
		return relid;
	}

	public void setRelid(Integer relid) {
		this.relid = relid;
	}

	public String getFieldname() {
		return fieldname;
	}

	public void setFieldname(String fieldname) {
		this.fieldname = fieldname;
	}

	public String getFieldtype() {
		return fieldtype;
	}

	public void setFieldtype(String fieldtype) {
		this.fieldtype = fieldtype;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFieldoptions() {
		return fieldoptions;
	}

	public void setFieldoptions(String fieldoptions) {
		this.fieldoptions = fieldoptions;
	}

	public String getRegexpr() {
		return regexpr;
	}

	public void setRegexpr(String regexpr) {
		this.regexpr = regexpr;
	}

	public String getAdminonly() {
		return adminonly;
	}

	public void setAdminonly(String adminonly) {
		this.adminonly = adminonly;
	}

	public String getRequired() {
		return required;
	}

	public void setRequired(String required) {
		this.required = required;
	}

	public String getShoworder() {
		return showorder;
	}

	public void setShoworder(String showorder) {
		this.showorder = showorder;
	}

	public String getShowinvoice() {
		return showinvoice;
	}

	public void setShowinvoice(String showinvoice) {
		this.showinvoice = showinvoice;
	}

	public Integer getSortorder() {
		return sortorder;
	}

	public void setSortorder(Integer sortorder) {
		this.sortorder = sortorder;
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
