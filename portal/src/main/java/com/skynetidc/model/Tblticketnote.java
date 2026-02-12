package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "tblticketnotes")
public class Tblticketnote {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Column(name = "ticketid", nullable = false)
	private Integer ticketid;

	@NotNull
	@Lob
	@Column(name = "admin", nullable = false)
	private String admin;

	@NotNull
	@ColumnDefault("'0000-00-00 00:00:00'")
	@Column(name = "date", nullable = false)
	private Instant date;

	@NotNull
	@Lob
	@Column(name = "message", nullable = false)
	private String message;

	@NotNull
	@Lob
	@Column(name = "attachments", nullable = false)
	private String attachments;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "attachments_removed", nullable = false)
	private Boolean attachmentsRemoved = false;

	@NotNull
	@ColumnDefault("'plain'")
	@Lob
	@Column(name = "editor", nullable = false)
	private String editor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTicketid() {
		return ticketid;
	}

	public void setTicketid(Integer ticketid) {
		this.ticketid = ticketid;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAttachments() {
		return attachments;
	}

	public void setAttachments(String attachments) {
		this.attachments = attachments;
	}

	public Boolean getAttachmentsRemoved() {
		return attachmentsRemoved;
	}

	public void setAttachmentsRemoved(Boolean attachmentsRemoved) {
		this.attachmentsRemoved = attachmentsRemoved;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

}
