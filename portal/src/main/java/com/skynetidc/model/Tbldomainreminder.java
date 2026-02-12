package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "tbldomainreminders")
public class Tbldomainreminder {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Column(name = "domain_id", nullable = false)
	private Integer domainId;

	@NotNull
	@Column(name = "date", nullable = false)
	private LocalDate date;

	@NotNull
	@Lob
	@Column(name = "recipients", nullable = false)
	private String recipients;

	@NotNull
	@Column(name = "type", nullable = false)
	private Byte type;

	@NotNull
	@Column(name = "days_before_expiry", nullable = false)
	private Byte daysBeforeExpiry;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDomainId() {
		return domainId;
	}

	public void setDomainId(Integer domainId) {
		this.domainId = domainId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getRecipients() {
		return recipients;
	}

	public void setRecipients(String recipients) {
		this.recipients = recipients;
	}

	public Byte getType() {
		return type;
	}

	public void setType(Byte type) {
		this.type = type;
	}

	public Byte getDaysBeforeExpiry() {
		return daysBeforeExpiry;
	}

	public void setDaysBeforeExpiry(Byte daysBeforeExpiry) {
		this.daysBeforeExpiry = daysBeforeExpiry;
	}

}
