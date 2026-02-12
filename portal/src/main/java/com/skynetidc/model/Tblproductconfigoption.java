package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "tblproductconfigoptions")
public class Tblproductconfigoption {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "gid", nullable = false)
	private Integer gid;

	@NotNull
	@Lob
	@Column(name = "optionname", nullable = false)
	private String optionname;

	@NotNull
	@Lob
	@Column(name = "optiontype", nullable = false)
	private String optiontype;

	@NotNull
	@Column(name = "qtyminimum", nullable = false)
	private Integer qtyminimum;

	@NotNull
	@Column(name = "qtymaximum", nullable = false)
	private Integer qtymaximum;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "`order`", nullable = false)
	private Integer order;

	@NotNull
	@Column(name = "hidden", nullable = false)
	private Integer hidden;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGid() {
		return gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public String getOptionname() {
		return optionname;
	}

	public void setOptionname(String optionname) {
		this.optionname = optionname;
	}

	public String getOptiontype() {
		return optiontype;
	}

	public void setOptiontype(String optiontype) {
		this.optiontype = optiontype;
	}

	public Integer getQtyminimum() {
		return qtyminimum;
	}

	public void setQtyminimum(Integer qtyminimum) {
		this.qtyminimum = qtyminimum;
	}

	public Integer getQtymaximum() {
		return qtymaximum;
	}

	public void setQtymaximum(Integer qtymaximum) {
		this.qtymaximum = qtymaximum;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public Integer getHidden() {
		return hidden;
	}

	public void setHidden(Integer hidden) {
		this.hidden = hidden;
	}

}
