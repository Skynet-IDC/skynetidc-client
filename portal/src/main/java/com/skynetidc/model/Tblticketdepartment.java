package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "tblticketdepartments")
public class Tblticketdepartment {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Lob
	@Column(name = "name", nullable = false)
	private String name;

	@NotNull
	@Lob
	@Column(name = "description", nullable = false)
	private String description;

	@NotNull
	@Lob
	@Column(name = "email", nullable = false)
	private String email;

	@NotNull
	@Lob
	@Column(name = "clientsonly", nullable = false)
	private String clientsonly;

	@NotNull
	@Lob
	@Column(name = "piperepliesonly", nullable = false)
	private String piperepliesonly;

	@NotNull
	@Lob
	@Column(name = "noautoresponder", nullable = false)
	private String noautoresponder;

	@NotNull
	@Lob
	@Column(name = "hidden", nullable = false)
	private String hidden;

	@NotNull
	@Column(name = "`order`", nullable = false)
	private Integer order;

	@NotNull
	@Lob
	@Column(name = "host", nullable = false)
	private String host;

	@NotNull
	@Lob
	@Column(name = "port", nullable = false)
	private String port;

	@NotNull
	@Lob
	@Column(name = "login", nullable = false)
	private String login;

	@NotNull
	@Lob
	@Column(name = "password", nullable = false)
	private String password;

	@Lob
	@Column(name = "mail_auth_config")
	private String mailAuthConfig;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "feedback_request", nullable = false)
	private Boolean feedbackRequest = false;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "prevent_client_closure", nullable = false)
	private Boolean preventClientClosure = false;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClientsonly() {
		return clientsonly;
	}

	public void setClientsonly(String clientsonly) {
		this.clientsonly = clientsonly;
	}

	public String getPiperepliesonly() {
		return piperepliesonly;
	}

	public void setPiperepliesonly(String piperepliesonly) {
		this.piperepliesonly = piperepliesonly;
	}

	public String getNoautoresponder() {
		return noautoresponder;
	}

	public void setNoautoresponder(String noautoresponder) {
		this.noautoresponder = noautoresponder;
	}

	public String getHidden() {
		return hidden;
	}

	public void setHidden(String hidden) {
		this.hidden = hidden;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMailAuthConfig() {
		return mailAuthConfig;
	}

	public void setMailAuthConfig(String mailAuthConfig) {
		this.mailAuthConfig = mailAuthConfig;
	}

	public Boolean getFeedbackRequest() {
		return feedbackRequest;
	}

	public void setFeedbackRequest(Boolean feedbackRequest) {
		this.feedbackRequest = feedbackRequest;
	}

	public Boolean getPreventClientClosure() {
		return preventClientClosure;
	}

	public void setPreventClientClosure(Boolean preventClientClosure) {
		this.preventClientClosure = preventClientClosure;
	}

}
