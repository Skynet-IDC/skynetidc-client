package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tblticketstatuses")
public class Tblticketstatus {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@Size(max = 64)
	@NotNull
	@Column(name = "title", nullable = false, length = 64)
	private String title;

	@NotNull
	@Lob
	@Column(name = "color", nullable = false)
	private String color;

	@NotNull
	@Column(name = "sortorder", nullable = false)
	private Integer sortorder;

	@NotNull
	@Column(name = "showactive", nullable = false)
	private Integer showactive;

	@NotNull
	@Column(name = "showawaiting", nullable = false)
	private Integer showawaiting;

	@NotNull
	@Column(name = "autoclose", nullable = false)
	private Integer autoclose;

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

	public Integer getSortorder() {
		return sortorder;
	}

	public void setSortorder(Integer sortorder) {
		this.sortorder = sortorder;
	}

	public Integer getShowactive() {
		return showactive;
	}

	public void setShowactive(Integer showactive) {
		this.showactive = showactive;
	}

	public Integer getShowawaiting() {
		return showawaiting;
	}

	public void setShowawaiting(Integer showawaiting) {
		this.showawaiting = showawaiting;
	}

	public Integer getAutoclose() {
		return autoclose;
	}

	public void setAutoclose(Integer autoclose) {
		this.autoclose = autoclose;
	}

}
