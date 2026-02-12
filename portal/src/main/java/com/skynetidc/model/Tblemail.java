package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "tblemails")
public class Tblemail {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Column(name = "userid", nullable = false)
	private Integer userid;

	@NotNull
	@Lob
	@Column(name = "subject", nullable = false)
	private String subject;

	@NotNull
	@Lob
	@Column(name = "message", nullable = false)
	private String message;

	@Column(name = "date")
	private Instant date;

	@Lob
	@Column(name = "`to`")
	private String to;

	@Lob
	@Column(name = "cc")
	private String cc;

	@Lob
	@Column(name = "bcc")
	private String bcc;

	@Lob
	@Column(name = "attachments")
	private String attachments;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "pending", nullable = false)
	private Boolean pending = false;

	@Lob
	@Column(name = "message_data")
	private String messageData;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "failed", nullable = false)
	private Boolean failed = false;

	@Size(max = 250)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "failure_reason", nullable = false, length = 250)
	private String failureReason;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "retry_count", nullable = false)
	private Boolean retryCount = false;

	@Column(name = "created_at")
	private Instant createdAt;

	@Column(name = "updated_at")
	private Instant updatedAt;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "campaign_id", nullable = false)
	private Integer campaignId;

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

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getBcc() {
		return bcc;
	}

	public void setBcc(String bcc) {
		this.bcc = bcc;
	}

	public String getAttachments() {
		return attachments;
	}

	public void setAttachments(String attachments) {
		this.attachments = attachments;
	}

	public Boolean getPending() {
		return pending;
	}

	public void setPending(Boolean pending) {
		this.pending = pending;
	}

	public String getMessageData() {
		return messageData;
	}

	public void setMessageData(String messageData) {
		this.messageData = messageData;
	}

	public Boolean getFailed() {
		return failed;
	}

	public void setFailed(Boolean failed) {
		this.failed = failed;
	}

	public String getFailureReason() {
		return failureReason;
	}

	public void setFailureReason(String failureReason) {
		this.failureReason = failureReason;
	}

	public Boolean getRetryCount() {
		return retryCount;
	}

	public void setRetryCount(Boolean retryCount) {
		this.retryCount = retryCount;
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

	public Integer getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(Integer campaignId) {
		this.campaignId = campaignId;
	}

}
