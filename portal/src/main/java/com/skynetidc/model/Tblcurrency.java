package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;

@Entity
@Table(name = "tblcurrencies")
public class Tblcurrency {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Lob
	@Column(name = "code", nullable = false)
	private String code;

	@NotNull
	@Lob
	@Column(name = "prefix", nullable = false)
	private String prefix;

	@NotNull
	@Lob
	@Column(name = "suffix", nullable = false)
	private String suffix;

	@NotNull
	@Column(name = "format", nullable = false)
	private Integer format;

	@NotNull
	@ColumnDefault("1.00000")
	@Column(name = "rate", nullable = false, precision = 10, scale = 5)
	private BigDecimal rate;

	@NotNull
	@Column(name = "`default`", nullable = false)
	private Integer defaultField;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public Integer getFormat() {
		return format;
	}

	public void setFormat(Integer format) {
		this.format = format;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public Integer getDefaultField() {
		return defaultField;
	}

	public void setDefaultField(Integer defaultField) {
		this.defaultField = defaultField;
	}

}
