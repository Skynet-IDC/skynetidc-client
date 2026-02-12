package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "mod_invoicedata")
public class ModInvoicedatum {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Column(name = "invoiceid", nullable = false)
	private Integer invoiceid;

	@NotNull
	@Lob
	@Column(name = "clientsdetails", nullable = false)
	private String clientsdetails;

	@NotNull
	@Lob
	@Column(name = "customfields", nullable = false)
	private String customfields;

	@Size(max = 255)
	@Column(name = "version")
	private String version;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getInvoiceid() {
		return invoiceid;
	}

	public void setInvoiceid(Integer invoiceid) {
		this.invoiceid = invoiceid;
	}

	public String getClientsdetails() {
		return clientsdetails;
	}

	public void setClientsdetails(String clientsdetails) {
		this.clientsdetails = clientsdetails;
	}

	public String getCustomfields() {
		return customfields;
	}

	public void setCustomfields(String customfields) {
		this.customfields = customfields;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
