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
@Table(name = "tblpaymethods")
public class Tblpaymethod {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "userid", nullable = false)
	private Integer userid;

	@Size(max = 255)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "description", nullable = false)
	private String description;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "contact_id", nullable = false)
	private Integer contactId;

	@Size(max = 255)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "contact_type", nullable = false)
	private String contactType;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "payment_id", nullable = false)
	private Integer paymentId;

	@Size(max = 255)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "payment_type", nullable = false)
	private String paymentType;

	@Size(max = 255)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "gateway_name", nullable = false)
	private String gatewayName;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "order_preference", nullable = false)
	private Integer orderPreference;

	@NotNull
	@ColumnDefault("'0000-00-00 00:00:00'")
	@Column(name = "created_at", nullable = false)
	private Instant createdAt;

	@NotNull
	@ColumnDefault("'0000-00-00 00:00:00'")
	@Column(name = "updated_at", nullable = false)
	private Instant updatedAt;

	@Column(name = "deleted_at")
	private Instant deletedAt;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	public String getContactType() {
		return contactType;
	}

	public void setContactType(String contactType) {
		this.contactType = contactType;
	}

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getGatewayName() {
		return gatewayName;
	}

	public void setGatewayName(String gatewayName) {
		this.gatewayName = gatewayName;
	}

	public Integer getOrderPreference() {
		return orderPreference;
	}

	public void setOrderPreference(Integer orderPreference) {
		this.orderPreference = orderPreference;
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

	public Instant getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Instant deletedAt) {
		this.deletedAt = deletedAt;
	}

}
