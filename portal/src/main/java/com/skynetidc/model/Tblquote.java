package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tblquotes")
public class Tblquote {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Lob
	@Column(name = "subject", nullable = false)
	private String subject;

	@NotNull
	@Lob
	@Column(name = "stage", nullable = false)
	private String stage;

	@NotNull
	@Column(name = "validuntil", nullable = false)
	private LocalDate validuntil;

	@NotNull
	@Column(name = "userid", nullable = false)
	private Integer userid;

	@NotNull
	@Lob
	@Column(name = "firstname", nullable = false)
	private String firstname;

	@NotNull
	@Lob
	@Column(name = "lastname", nullable = false)
	private String lastname;

	@NotNull
	@Lob
	@Column(name = "companyname", nullable = false)
	private String companyname;

	@NotNull
	@Lob
	@Column(name = "email", nullable = false)
	private String email;

	@NotNull
	@Lob
	@Column(name = "address1", nullable = false)
	private String address1;

	@NotNull
	@Lob
	@Column(name = "address2", nullable = false)
	private String address2;

	@NotNull
	@Lob
	@Column(name = "city", nullable = false)
	private String city;

	@NotNull
	@Lob
	@Column(name = "state", nullable = false)
	private String state;

	@NotNull
	@Lob
	@Column(name = "postcode", nullable = false)
	private String postcode;

	@NotNull
	@Lob
	@Column(name = "country", nullable = false)
	private String country;

	@NotNull
	@Lob
	@Column(name = "phonenumber", nullable = false)
	private String phonenumber;

	@Size(max = 128)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "tax_id", nullable = false, length = 128)
	private String taxId;

	@NotNull
	@Column(name = "currency", nullable = false)
	private Integer currency;

	@NotNull
	@Column(name = "subtotal", nullable = false, precision = 16, scale = 2)
	private BigDecimal subtotal;

	@NotNull
	@Column(name = "tax1", nullable = false, precision = 16, scale = 2)
	private BigDecimal tax1;

	@NotNull
	@Column(name = "tax2", nullable = false, precision = 16, scale = 2)
	private BigDecimal tax2;

	@NotNull
	@Column(name = "total", nullable = false, precision = 16, scale = 2)
	private BigDecimal total;

	@NotNull
	@Lob
	@Column(name = "proposal", nullable = false)
	private String proposal;

	@NotNull
	@Lob
	@Column(name = "customernotes", nullable = false)
	private String customernotes;

	@NotNull
	@Lob
	@Column(name = "adminnotes", nullable = false)
	private String adminnotes;

	@NotNull
	@Column(name = "datecreated", nullable = false)
	private LocalDate datecreated;

	@NotNull
	@Column(name = "lastmodified", nullable = false)
	private LocalDate lastmodified;

	@NotNull
	@Column(name = "datesent", nullable = false)
	private LocalDate datesent;

	@NotNull
	@Column(name = "dateaccepted", nullable = false)
	private LocalDate dateaccepted;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public LocalDate getValiduntil() {
		return validuntil;
	}

	public void setValiduntil(LocalDate validuntil) {
		this.validuntil = validuntil;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public Integer getCurrency() {
		return currency;
	}

	public void setCurrency(Integer currency) {
		this.currency = currency;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public BigDecimal getTax1() {
		return tax1;
	}

	public void setTax1(BigDecimal tax1) {
		this.tax1 = tax1;
	}

	public BigDecimal getTax2() {
		return tax2;
	}

	public void setTax2(BigDecimal tax2) {
		this.tax2 = tax2;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public String getProposal() {
		return proposal;
	}

	public void setProposal(String proposal) {
		this.proposal = proposal;
	}

	public String getCustomernotes() {
		return customernotes;
	}

	public void setCustomernotes(String customernotes) {
		this.customernotes = customernotes;
	}

	public String getAdminnotes() {
		return adminnotes;
	}

	public void setAdminnotes(String adminnotes) {
		this.adminnotes = adminnotes;
	}

	public LocalDate getDatecreated() {
		return datecreated;
	}

	public void setDatecreated(LocalDate datecreated) {
		this.datecreated = datecreated;
	}

	public LocalDate getLastmodified() {
		return lastmodified;
	}

	public void setLastmodified(LocalDate lastmodified) {
		this.lastmodified = lastmodified;
	}

	public LocalDate getDatesent() {
		return datesent;
	}

	public void setDatesent(LocalDate datesent) {
		this.datesent = datesent;
	}

	public LocalDate getDateaccepted() {
		return dateaccepted;
	}

	public void setDateaccepted(LocalDate dateaccepted) {
		this.dateaccepted = dateaccepted;
	}

}
