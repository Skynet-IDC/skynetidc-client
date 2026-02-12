package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "tblproductconfigoptionssub")
public class Tblproductconfigoptionssub {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Column(name = "configid", nullable = false)
	private Integer configid;

	@NotNull
	@Lob
	@Column(name = "optionname", nullable = false)
	private String optionname;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "sortorder", nullable = false)
	private Integer sortorder;

	@NotNull
	@Column(name = "hidden", nullable = false)
	private Integer hidden;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getConfigid() {
		return configid;
	}

	public void setConfigid(Integer configid) {
		this.configid = configid;
	}

	public String getOptionname() {
		return optionname;
	}

	public void setOptionname(String optionname) {
		this.optionname = optionname;
	}

	public Integer getSortorder() {
		return sortorder;
	}

	public void setSortorder(Integer sortorder) {
		this.sortorder = sortorder;
	}

	public Integer getHidden() {
		return hidden;
	}

	public void setHidden(Integer hidden) {
		this.hidden = hidden;
	}

}
