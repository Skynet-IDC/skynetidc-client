package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "tbladmin_invites")
public class TbladminInvite {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@Size(max = 255)
	@Column(name = "username")
	private String username;

	@Size(max = 100)
	@NotNull
	@Column(name = "token", nullable = false, length = 100)
	private String token;

	@NotNull
	@ColumnDefault("current_timestamp()")
	@Column(name = "created_at", nullable = false)
	private Instant createdAt;

	@NotNull
	@ColumnDefault("'0000-00-00 00:00:00'")
	@Column(name = "updated_at", nullable = false)
	private Instant updatedAt;

	@NotNull
	@ColumnDefault("'0000-00-00 00:00:00'")
	@Column(name = "expires_at", nullable = false)
	private Instant expiresAt;

	@NotNull
	@Column(name = "expiration_period_in_days", nullable = false)
	private Integer expirationPeriodInDays;

	@Size(max = 255)
	@NotNull
	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Size(max = 255)
	@Column(name = "last_name")
	private String lastName;

	@NotNull
	@ColumnDefault("1")
	@Column(name = "roleid", nullable = false)
	private Integer roleid;

	@Size(max = 255)
	@NotNull
	@Column(name = "email", nullable = false)
	private String email;

	@Lob
	@Column(name = "assigned_departments")
	private String assignedDepartments;

	@Lob
	@Column(name = "ticket_notify")
	private String ticketNotify;

	@Lob
	@Column(name = "support_ticket_signature")
	private String supportTicketSignature;

	@Lob
	@Column(name = "private_notes")
	private String privateNotes;

	@NotNull
	@Lob
	@Column(name = "template", nullable = false)
	private String template;

	@Size(max = 32)
	@NotNull
	@Column(name = "language", nullable = false, length = 32)
	private String language;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "disable", nullable = false)
	private Integer disable;

	@NotNull
	@Column(name = "invited_by", nullable = false)
	private Integer invitedBy;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
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

	public Instant getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(Instant expiresAt) {
		this.expiresAt = expiresAt;
	}

	public Integer getExpirationPeriodInDays() {
		return expirationPeriodInDays;
	}

	public void setExpirationPeriodInDays(Integer expirationPeriodInDays) {
		this.expirationPeriodInDays = expirationPeriodInDays;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAssignedDepartments() {
		return assignedDepartments;
	}

	public void setAssignedDepartments(String assignedDepartments) {
		this.assignedDepartments = assignedDepartments;
	}

	public String getTicketNotify() {
		return ticketNotify;
	}

	public void setTicketNotify(String ticketNotify) {
		this.ticketNotify = ticketNotify;
	}

	public String getSupportTicketSignature() {
		return supportTicketSignature;
	}

	public void setSupportTicketSignature(String supportTicketSignature) {
		this.supportTicketSignature = supportTicketSignature;
	}

	public String getPrivateNotes() {
		return privateNotes;
	}

	public void setPrivateNotes(String privateNotes) {
		this.privateNotes = privateNotes;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Integer getDisable() {
		return disable;
	}

	public void setDisable(Integer disable) {
		this.disable = disable;
	}

	public Integer getInvitedBy() {
		return invitedBy;
	}

	public void setInvitedBy(Integer invitedBy) {
		this.invitedBy = invitedBy;
	}

}
