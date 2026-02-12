package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tblorderstatuses")
public class Tblorderstatus {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Lob
	@Column(name = "title", nullable = false)
	private String title;

	@NotNull
	@Lob
	@Column(name = "color", nullable = false)
	private String color;

	@NotNull
	@Column(name = "showpending", nullable = false)
	private Integer showpending;

	@NotNull
	@Column(name = "showactive", nullable = false)
	private Integer showactive;

	@NotNull
	@Column(name = "showcancelled", nullable = false)
	private Integer showcancelled;

	@NotNull
	@Column(name = "sortorder", nullable = false)
	private Integer sortorder;

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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getShowpending() {
		return showpending;
	}

	public void setShowpending(Integer showpending) {
		this.showpending = showpending;
	}

	public Integer getShowactive() {
		return showactive;
	}

	public void setShowactive(Integer showactive) {
		this.showactive = showactive;
	}

	public Integer getShowcancelled() {
		return showcancelled;
	}

	public void setShowcancelled(Integer showcancelled) {
		this.showcancelled = showcancelled;
	}

	public Integer getSortorder() {
		return sortorder;
	}

	public void setSortorder(Integer sortorder) {
		this.sortorder = sortorder;
	}

}
