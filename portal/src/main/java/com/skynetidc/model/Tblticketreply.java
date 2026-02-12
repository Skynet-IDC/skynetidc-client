package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "tblticketreplies")
public class Tblticketreply {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Column(name = "tid", nullable = false)
	private Integer tid;

	@NotNull
	@Column(name = "userid", nullable = false)
	private Integer userid;

	@NotNull
	@Column(name = "contactid", nullable = false)
	private Integer contactid;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "requestor_id", nullable = false)
	private Integer requestorId;

	@NotNull
	@Lob
	@Column(name = "name", nullable = false)
	private String name;

	@NotNull
	@Lob
	@Column(name = "email", nullable = false)
	private String email;

	@NotNull
	@Column(name = "date", nullable = false)
	private Instant date;

	@NotNull
	@Lob
	@Column(name = "message", nullable = false)
	private String message;

	@NotNull
	@Lob
	@Column(name = "admin", nullable = false)
	private String admin;

	@NotNull
	@Lob
	@Column(name = "attachment", nullable = false)
	private String attachment;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "attachments_removed", nullable = false)
	private Boolean attachmentsRemoved = false;

	@NotNull
	@Column(name = "rating", nullable = false)
	private Integer rating;

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

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getContactid() {
		return contactid;
	}

	public void setContactid(Integer contactid) {
		this.contactid = contactid;
	}

	public Integer getRequestorId() {
		return requestorId;
	}

	public void setRequestorId(Integer requestorId) {
		this.requestorId = requestorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public Boolean getAttachmentsRemoved() {
		return attachmentsRemoved;
	}

	public void setAttachmentsRemoved(Boolean attachmentsRemoved) {
		this.attachmentsRemoved = attachmentsRemoved;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

}
