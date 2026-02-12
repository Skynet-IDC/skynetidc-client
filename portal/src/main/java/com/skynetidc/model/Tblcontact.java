package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "tblcontacts")
public class Tblcontact {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

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
	@ColumnDefault("0")
	@Column(name = "subaccount", nullable = false)
	private Integer subaccount;

	@NotNull
	@Lob
	@Column(name = "password", nullable = false)
	private String password;

	@NotNull
	@Lob
	@Column(name = "permissions", nullable = false)
	private String permissions;

	@NotNull
	@Column(name = "domainemails", nullable = false)
	private Integer domainemails;

	@NotNull
	@Column(name = "generalemails", nullable = false)
	private Integer generalemails;

	@NotNull
	@Column(name = "invoiceemails", nullable = false)
	private Integer invoiceemails;

	@NotNull
	@Column(name = "productemails", nullable = false)
	private Integer productemails;

	@NotNull
	@Column(name = "supportemails", nullable = false)
	private Integer supportemails;

	@NotNull
	@Column(name = "affiliateemails", nullable = false)
	private Integer affiliateemails;

	@NotNull
	@Lob
	@Column(name = "pwresetkey", nullable = false)
	private String pwresetkey;

	@NotNull
	@ColumnDefault("'0000-00-00 00:00:00'")
	@Column(name = "created_at", nullable = false)
	private Instant createdAt;

	@NotNull
	@ColumnDefault("'0000-00-00 00:00:00'")
	@Column(name = "updated_at", nullable = false)
	private Instant updatedAt;

	@NotNull
	@ColumnDefault("'0000-00-00 00:00:00'")
	@Column(name = "pwresetexpiry", nullable = false)
	private Instant pwresetexpiry;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getSubaccount() {
		return subaccount;
	}

	public void setSubaccount(Integer subaccount) {
		this.subaccount = subaccount;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	public Integer getDomainemails() {
		return domainemails;
	}

	public void setDomainemails(Integer domainemails) {
		this.domainemails = domainemails;
	}

	public Integer getGeneralemails() {
		return generalemails;
	}

	public void setGeneralemails(Integer generalemails) {
		this.generalemails = generalemails;
	}

	public Integer getInvoiceemails() {
		return invoiceemails;
	}

	public void setInvoiceemails(Integer invoiceemails) {
		this.invoiceemails = invoiceemails;
	}

	public Integer getProductemails() {
		return productemails;
	}

	public void setProductemails(Integer productemails) {
		this.productemails = productemails;
	}

	public Integer getSupportemails() {
		return supportemails;
	}

	public void setSupportemails(Integer supportemails) {
		this.supportemails = supportemails;
	}

	public Integer getAffiliateemails() {
		return affiliateemails;
	}

	public void setAffiliateemails(Integer affiliateemails) {
		this.affiliateemails = affiliateemails;
	}

	public String getPwresetkey() {
		return pwresetkey;
	}

	public void setPwresetkey(String pwresetkey) {
		this.pwresetkey = pwresetkey;
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

	public Instant getPwresetexpiry() {
		return pwresetexpiry;
	}

	public void setPwresetexpiry(Instant pwresetexpiry) {
		this.pwresetexpiry = pwresetexpiry;
	}

}
