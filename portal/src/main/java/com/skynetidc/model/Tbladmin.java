package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "tbladmins")
public class Tbladmin {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@Size(max = 255)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "uuid", nullable = false)
	private String uuid;

	@NotNull
	@Column(name = "roleid", nullable = false)
	private Integer roleid;

	@NotNull
	@Lob
	@Column(name = "username", nullable = false)
	private String username;

	@Size(max = 255)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "password", nullable = false)
	private String password;

	@Size(max = 255)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "passwordhash", nullable = false)
	private String passwordhash;

	@NotNull
	@Lob
	@Column(name = "authmodule", nullable = false)
	private String authmodule;

	@NotNull
	@Lob
	@Column(name = "authdata", nullable = false)
	private String authdata;

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
	@Column(name = "email", nullable = false)
	private String email;

	@NotNull
	@Lob
	@Column(name = "signature", nullable = false)
	private String signature;

	@NotNull
	@Lob
	@Column(name = "notes", nullable = false)
	private String notes;

	@NotNull
	@Lob
	@Column(name = "template", nullable = false)
	private String template;

	@NotNull
	@Lob
	@Column(name = "language", nullable = false)
	private String language;

	@NotNull
	@Column(name = "disabled", nullable = false)
	private Integer disabled;

	@NotNull
	@Column(name = "loginattempts", nullable = false)
	private Integer loginattempts;

	@NotNull
	@Lob
	@Column(name = "supportdepts", nullable = false)
	private String supportdepts;

	@NotNull
	@Lob
	@Column(name = "ticketnotifications", nullable = false)
	private String ticketnotifications;

	@NotNull
	@Lob
	@Column(name = "homewidgets", nullable = false)
	private String homewidgets;

	@Size(max = 255)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "password_reset_key", nullable = false)
	private String passwordResetKey;

	@NotNull
	@Lob
	@Column(name = "password_reset_data", nullable = false)
	private String passwordResetData;

	@NotNull
	@ColumnDefault("'0000-00-00 00:00:00'")
	@Column(name = "password_reset_expiry", nullable = false)
	private Instant passwordResetExpiry;

	@NotNull
	@Lob
	@Column(name = "hidden_widgets", nullable = false)
	private String hiddenWidgets;

	@NotNull
	@Lob
	@Column(name = "widget_order", nullable = false)
	private String widgetOrder;

	@Lob
	@Column(name = "user_preferences")
	private String userPreferences;

	@NotNull
	@ColumnDefault("'0000-00-00 00:00:00'")
	@Column(name = "created_at", nullable = false)
	private Instant createdAt;

	@NotNull
	@ColumnDefault("'0000-00-00 00:00:00'")
	@Column(name = "updated_at", nullable = false)
	private Instant updatedAt;

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

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordhash() {
		return passwordhash;
	}

	public void setPasswordhash(String passwordhash) {
		this.passwordhash = passwordhash;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
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

	public Integer getDisabled() {
		return disabled;
	}

	public void setDisabled(Integer disabled) {
		this.disabled = disabled;
	}

	public Integer getLoginattempts() {
		return loginattempts;
	}

	public void setLoginattempts(Integer loginattempts) {
		this.loginattempts = loginattempts;
	}

	public String getSupportdepts() {
		return supportdepts;
	}

	public void setSupportdepts(String supportdepts) {
		this.supportdepts = supportdepts;
	}

	public String getTicketnotifications() {
		return ticketnotifications;
	}

	public void setTicketnotifications(String ticketnotifications) {
		this.ticketnotifications = ticketnotifications;
	}

	public String getHomewidgets() {
		return homewidgets;
	}

	public void setHomewidgets(String homewidgets) {
		this.homewidgets = homewidgets;
	}

	public String getPasswordResetKey() {
		return passwordResetKey;
	}

	public void setPasswordResetKey(String passwordResetKey) {
		this.passwordResetKey = passwordResetKey;
	}

	public String getPasswordResetData() {
		return passwordResetData;
	}

	public void setPasswordResetData(String passwordResetData) {
		this.passwordResetData = passwordResetData;
	}

	public Instant getPasswordResetExpiry() {
		return passwordResetExpiry;
	}

	public void setPasswordResetExpiry(Instant passwordResetExpiry) {
		this.passwordResetExpiry = passwordResetExpiry;
	}

	public String getHiddenWidgets() {
		return hiddenWidgets;
	}

	public void setHiddenWidgets(String hiddenWidgets) {
		this.hiddenWidgets = hiddenWidgets;
	}

	public String getWidgetOrder() {
		return widgetOrder;
	}

	public void setWidgetOrder(String widgetOrder) {
		this.widgetOrder = widgetOrder;
	}

	public String getUserPreferences() {
		return userPreferences;
	}

	public void setUserPreferences(String userPreferences) {
		this.userPreferences = userPreferences;
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
