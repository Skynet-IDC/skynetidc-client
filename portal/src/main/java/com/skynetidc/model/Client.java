package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "tblclients")
public class Client {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@Size(max = 255)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "uuid", nullable = false)
	private String uuid;

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
	@Lob
	@Column(name = "password", nullable = false)
	private String password;

	@NotNull
	@Lob
	@Column(name = "authmodule", nullable = false)
	private String authmodule;

	@NotNull
	@Lob
	@Column(name = "authdata", nullable = false)
	private String authdata;

	@NotNull
	@Column(name = "currency", nullable = false)
	private Integer currency;

	@NotNull
	@Lob
	@Column(name = "defaultgateway", nullable = false)
	private String defaultgateway;

	@NotNull
	@Column(name = "credit", nullable = false, precision = 16, scale = 2)
	private BigDecimal credit;

	@NotNull
	@Column(name = "taxexempt", nullable = false)
	private Boolean taxexempt = false;

	@NotNull
	@Column(name = "latefeeoveride", nullable = false)
	private Boolean latefeeoveride = false;

	@NotNull
	@Column(name = "overideduenotices", nullable = false)
	private Boolean overideduenotices = false;

	@NotNull
	@Column(name = "separateinvoices", nullable = false)
	private Boolean separateinvoices = false;

	@NotNull
	@Column(name = "disableautocc", nullable = false)
	private Boolean disableautocc = false;

	@NotNull
	@Column(name = "datecreated", nullable = false)
	private LocalDate datecreated;

	@NotNull
	@Lob
	@Column(name = "notes", nullable = false)
	private String notes;

	@NotNull
	@Column(name = "billingcid", nullable = false)
	private Integer billingcid;

	@NotNull
	@Column(name = "securityqid", nullable = false)
	private Integer securityqid;

	@NotNull
	@Lob
	@Column(name = "securityqans", nullable = false)
	private String securityqans;

	@NotNull
	@Column(name = "groupid", nullable = false)
	private Integer groupid;

	@Size(max = 255)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "cardtype", nullable = false)
	private String cardtype;

	@NotNull
	@Lob
	@Column(name = "cardlastfour", nullable = false)
	private String cardlastfour;

	@NotNull
	@Column(name = "cardnum", nullable = false)
	private byte[] cardnum;

	@NotNull
	@Column(name = "startdate", nullable = false)
	private byte[] startdate;

	@NotNull
	@Column(name = "expdate", nullable = false)
	private byte[] expdate;

	@NotNull
	@Column(name = "issuenumber", nullable = false)
	private byte[] issuenumber;

	@NotNull
	@Lob
	@Column(name = "bankname", nullable = false)
	private String bankname;

	@NotNull
	@Lob
	@Column(name = "banktype", nullable = false)
	private String banktype;

	@NotNull
	@Column(name = "bankcode", nullable = false)
	private byte[] bankcode;

	@NotNull
	@Column(name = "bankacct", nullable = false)
	private byte[] bankacct;

	@NotNull
	@Lob
	@Column(name = "gatewayid", nullable = false)
	private String gatewayid;

	@Column(name = "lastlogin")
	private Instant lastlogin;

	@NotNull
	@Lob
	@Column(name = "ip", nullable = false)
	private String ip;

	@NotNull
	@Lob
	@Column(name = "host", nullable = false)
	private String host;

	@NotNull
	@ColumnDefault("'Active'")
	@Lob
	@Column(name = "status", nullable = false)
	private String status;

	@NotNull
	@Lob
	@Column(name = "language", nullable = false)
	private String language;

	@NotNull
	@Lob
	@Column(name = "pwresetkey", nullable = false)
	private String pwresetkey;

	@NotNull
	@Column(name = "emailoptout", nullable = false)
	private Integer emailoptout;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "marketing_emails_opt_in", nullable = false)
	private Boolean marketingEmailsOptIn = false;

	@NotNull
	@Column(name = "overrideautoclose", nullable = false)
	private Integer overrideautoclose;

	@NotNull
	@ColumnDefault("1")
	@Column(name = "allow_sso", nullable = false)
	private Boolean allowSso = false;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "email_verified", nullable = false)
	private Boolean emailVerified = false;

	@Lob
	@Column(name = "email_preferences")
	private String emailPreferences;

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

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuthmodule() {
		return authmodule;
	}

	public void setAuthmodule(String authmodule) {
		this.authmodule = authmodule;
	}

	public String getAuthdata() {
		return authdata;
	}

	public void setAuthdata(String authdata) {
		this.authdata = authdata;
	}

	public Integer getCurrency() {
		return currency;
	}

	public void setCurrency(Integer currency) {
		this.currency = currency;
	}

	public String getDefaultgateway() {
		return defaultgateway;
	}

	public void setDefaultgateway(String defaultgateway) {
		this.defaultgateway = defaultgateway;
	}

	public BigDecimal getCredit() {
		return credit;
	}

	public void setCredit(BigDecimal credit) {
		this.credit = credit;
	}

	public Boolean getTaxexempt() {
		return taxexempt;
	}

	public void setTaxexempt(Boolean taxexempt) {
		this.taxexempt = taxexempt;
	}

	public Boolean getLatefeeoveride() {
		return latefeeoveride;
	}

	public void setLatefeeoveride(Boolean latefeeoveride) {
		this.latefeeoveride = latefeeoveride;
	}

	public Boolean getOverideduenotices() {
		return overideduenotices;
	}

	public void setOverideduenotices(Boolean overideduenotices) {
		this.overideduenotices = overideduenotices;
	}

	public Boolean getSeparateinvoices() {
		return separateinvoices;
	}

	public void setSeparateinvoices(Boolean separateinvoices) {
		this.separateinvoices = separateinvoices;
	}

	public Boolean getDisableautocc() {
		return disableautocc;
	}

	public void setDisableautocc(Boolean disableautocc) {
		this.disableautocc = disableautocc;
	}

	public LocalDate getDatecreated() {
		return datecreated;
	}

	public void setDatecreated(LocalDate datecreated) {
		this.datecreated = datecreated;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Integer getBillingcid() {
		return billingcid;
	}

	public void setBillingcid(Integer billingcid) {
		this.billingcid = billingcid;
	}

	public Integer getSecurityqid() {
		return securityqid;
	}

	public void setSecurityqid(Integer securityqid) {
		this.securityqid = securityqid;
	}

	public String getSecurityqans() {
		return securityqans;
	}

	public void setSecurityqans(String securityqans) {
		this.securityqans = securityqans;
	}

	public Integer getGroupid() {
		return groupid;
	}

	public void setGroupid(Integer groupid) {
		this.groupid = groupid;
	}

	public String getCardtype() {
		return cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	public String getCardlastfour() {
		return cardlastfour;
	}

	public void setCardlastfour(String cardlastfour) {
		this.cardlastfour = cardlastfour;
	}

	public byte[] getCardnum() {
		return cardnum;
	}

	public void setCardnum(byte[] cardnum) {
		this.cardnum = cardnum;
	}

	public byte[] getStartdate() {
		return startdate;
	}

	public void setStartdate(byte[] startdate) {
		this.startdate = startdate;
	}

	public byte[] getExpdate() {
		return expdate;
	}

	public void setExpdate(byte[] expdate) {
		this.expdate = expdate;
	}

	public byte[] getIssuenumber() {
		return issuenumber;
	}

	public void setIssuenumber(byte[] issuenumber) {
		this.issuenumber = issuenumber;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getBanktype() {
		return banktype;
	}

	public void setBanktype(String banktype) {
		this.banktype = banktype;
	}

	public byte[] getBankcode() {
		return bankcode;
	}

	public void setBankcode(byte[] bankcode) {
		this.bankcode = bankcode;
	}

	public byte[] getBankacct() {
		return bankacct;
	}

	public void setBankacct(byte[] bankacct) {
		this.bankacct = bankacct;
	}

	public String getGatewayid() {
		return gatewayid;
	}

	public void setGatewayid(String gatewayid) {
		this.gatewayid = gatewayid;
	}

	public Instant getLastlogin() {
		return lastlogin;
	}

	public void setLastlogin(Instant lastlogin) {
		this.lastlogin = lastlogin;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getPwresetkey() {
		return pwresetkey;
	}

	public void setPwresetkey(String pwresetkey) {
		this.pwresetkey = pwresetkey;
	}

	public Integer getEmailoptout() {
		return emailoptout;
	}

	public void setEmailoptout(Integer emailoptout) {
		this.emailoptout = emailoptout;
	}

	public Boolean getMarketingEmailsOptIn() {
		return marketingEmailsOptIn;
	}

	public void setMarketingEmailsOptIn(Boolean marketingEmailsOptIn) {
		this.marketingEmailsOptIn = marketingEmailsOptIn;
	}

	public Integer getOverrideautoclose() {
		return overrideautoclose;
	}

	public void setOverrideautoclose(Integer overrideautoclose) {
		this.overrideautoclose = overrideautoclose;
	}

	public Boolean getAllowSso() {
		return allowSso;
	}

	public void setAllowSso(Boolean allowSso) {
		this.allowSso = allowSso;
	}

	public Boolean getEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(Boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	public String getEmailPreferences() {
		return emailPreferences;
	}

	public void setEmailPreferences(String emailPreferences) {
		this.emailPreferences = emailPreferences;
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
