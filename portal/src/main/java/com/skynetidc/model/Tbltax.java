package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;

@Entity
@Table(name = "tbltax")
public class Tbltax {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Column(name = "level", nullable = false)
	private Integer level;

	@NotNull
	@Lob
	@Column(name = "name", nullable = false)
	private String name;

	@NotNull
	@Lob
	@Column(name = "state", nullable = false)
	private String state;

	@NotNull
	@Lob
	@Column(name = "country", nullable = false)
	private String country;

	@NotNull
	@ColumnDefault("0.000")
	@Column(name = "taxrate", nullable = false, precision = 10, scale = 3)
	private BigDecimal taxrate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public BigDecimal getTaxrate() {
		return taxrate;
	}

	public void setTaxrate(BigDecimal taxrate) {
		this.taxrate = taxrate;
	}

}
