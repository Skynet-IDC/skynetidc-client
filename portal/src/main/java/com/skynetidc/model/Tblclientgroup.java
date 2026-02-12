package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;

@Entity
@Table(name = "tblclientgroups")
public class Tblclientgroup {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@Size(max = 45)
	@NotNull
	@Column(name = "groupname", nullable = false, length = 45)
	private String groupname;

	@Size(max = 45)
	@Column(name = "groupcolour", length = 45)
	private String groupcolour;

	@ColumnDefault("0.00")
	@Column(name = "discountpercent", precision = 10, scale = 2)
	private BigDecimal discountpercent;

	@Lob
	@Column(name = "susptermexempt")
	private String susptermexempt;

	@NotNull
	@Lob
	@Column(name = "separateinvoices", nullable = false)
	private String separateinvoices;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public String getGroupcolour() {
		return groupcolour;
	}

	public void setGroupcolour(String groupcolour) {
		this.groupcolour = groupcolour;
	}

	public BigDecimal getDiscountpercent() {
		return discountpercent;
	}

	public void setDiscountpercent(BigDecimal discountpercent) {
		this.discountpercent = discountpercent;
	}

	public String getSusptermexempt() {
		return susptermexempt;
	}

	public void setSusptermexempt(String susptermexempt) {
		this.susptermexempt = susptermexempt;
	}

	public String getSeparateinvoices() {
		return separateinvoices;
	}

	public void setSeparateinvoices(String separateinvoices) {
		this.separateinvoices = separateinvoices;
	}

}
