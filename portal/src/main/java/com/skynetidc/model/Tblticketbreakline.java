package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tblticketbreaklines")
public class Tblticketbreakline {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Lob
	@Column(name = "breakline", nullable = false)
	private String breakline;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBreakline() {
		return breakline;
	}

	public void setBreakline(String breakline) {
		this.breakline = breakline;
	}

}
