package com.skynetidc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "tblpaymentgateways_product_mapping")
public class TblpaymentgatewaysProductMapping {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@Size(max = 255)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "gateway", nullable = false)
	private String gateway;

	@Size(max = 255)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "account_identifier", nullable = false)
	private String accountIdentifier;

	@Size(max = 255)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "product_identifier", nullable = false)
	private String productIdentifier;

	@Size(max = 255)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "remote_identifier", nullable = false)
	private String remoteIdentifier;

	@ColumnDefault("'0000-00-00 00:00:00'")
	@Column(name = "created_at")
	private Instant createdAt;

	@ColumnDefault("'0000-00-00 00:00:00'")
	@Column(name = "updated_at")
	private Instant updatedAt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGateway() {
		return gateway;
	}

	public void setGateway(String gateway) {
		this.gateway = gateway;
	}

	public String getAccountIdentifier() {
		return accountIdentifier;
	}

	public void setAccountIdentifier(String accountIdentifier) {
		this.accountIdentifier = accountIdentifier;
	}

	public String getProductIdentifier() {
		return productIdentifier;
	}

	public void setProductIdentifier(String productIdentifier) {
		this.productIdentifier = productIdentifier;
	}

	public String getRemoteIdentifier() {
		return remoteIdentifier;
	}

	public void setRemoteIdentifier(String remoteIdentifier) {
		this.remoteIdentifier = remoteIdentifier;
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

}
