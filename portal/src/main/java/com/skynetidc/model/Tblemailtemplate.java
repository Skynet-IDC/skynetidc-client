package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "tblemailtemplates")
public class Tblemailtemplate {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Lob
	@Column(name = "type", nullable = false)
	private String type;

	@NotNull
	@Lob
	@Column(name = "name", nullable = false)
	private String name;

	@NotNull
	@Lob
	@Column(name = "subject", nullable = false)
	private String subject;

	@NotNull
	@Lob
	@Column(name = "message", nullable = false)
	private String message;

	@NotNull
	@Lob
	@Column(name = "attachments", nullable = false)
	private String attachments;

	@NotNull
	@Lob
	@Column(name = "fromname", nullable = false)
	private String fromname;

	@NotNull
	@Lob
	@Column(name = "fromemail", nullable = false)
	private String fromemail;

	@NotNull
	@Column(name = "disabled", nullable = false)
	private Boolean disabled = false;

	@NotNull
	@Column(name = "custom", nullable = false)
	private Boolean custom = false;

	@NotNull
	@Lob
	@Column(name = "language", nullable = false)
	private String language;

	@NotNull
	@Lob
	@Column(name = "copyto", nullable = false)
	private String copyto;

	@NotNull
	@Lob
	@Column(name = "blind_copy_to", nullable = false)
	private String blindCopyTo;

	@NotNull
	@Column(name = "plaintext", nullable = false)
	private Boolean plaintext = false;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
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

	public String getFromname() {
		return fromname;
	}

	public void setFromname(String fromname) {
		this.fromname = fromname;
	}

	public String getFromemail() {
		return fromemail;
	}

	public void setFromemail(String fromemail) {
		this.fromemail = fromemail;
	}

	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public Boolean getCustom() {
		return custom;
	}

	public void setCustom(Boolean custom) {
		this.custom = custom;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCopyto() {
		return copyto;
	}

	public void setCopyto(String copyto) {
		this.copyto = copyto;
	}

	public String getBlindCopyTo() {
		return blindCopyTo;
	}

	public void setBlindCopyTo(String blindCopyTo) {
		this.blindCopyTo = blindCopyTo;
	}

	public Boolean getPlaintext() {
		return plaintext;
	}

	public void setPlaintext(Boolean plaintext) {
		this.plaintext = plaintext;
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
