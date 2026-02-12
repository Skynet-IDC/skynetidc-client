package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "tbltickets")
public class Tblticket {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@Size(max = 128)
	@Column(name = "tid", length = 128)
	private String tid;

	@NotNull
	@Column(name = "did", nullable = false)
	private Integer did;

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
	@ColumnDefault("0")
	@Column(name = "prevent_client_closure", nullable = false)
	private Boolean preventClientClosure = false;

	@NotNull
	@Lob
	@Column(name = "name", nullable = false)
	private String name;

	@NotNull
	@Lob
	@Column(name = "email", nullable = false)
	private String email;

	@NotNull
	@Lob
	@Column(name = "cc", nullable = false)
	private String cc;

	@NotNull
	@Lob
	@Column(name = "c", nullable = false)
	private String c;

	@Size(max = 64)
	@Column(name = "ipaddress", length = 64)
	private String ipaddress;

	@NotNull
	@ColumnDefault("'0000-00-00 00:00:00'")
	@Column(name = "date", nullable = false)
	private Instant date;

	@NotNull
	@Lob
	@Column(name = "title", nullable = false)
	private String title;

	@NotNull
	@Lob
	@Column(name = "message", nullable = false)
	private String message;

	@Size(max = 64)
	@NotNull
	@Column(name = "status", nullable = false, length = 64)
	private String status;

	@NotNull
	@Lob
	@Column(name = "urgency", nullable = false)
	private String urgency;

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
	@Column(name = "lastreply", nullable = false)
	private Instant lastreply;

	@NotNull
	@Column(name = "flag", nullable = false)
	private Integer flag;

	@NotNull
	@Column(name = "clientunread", nullable = false)
	private Integer clientunread;

	@NotNull
	@Lob
	@Column(name = "adminunread", nullable = false)
	private String adminunread;

	@NotNull
	@Column(name = "replyingadmin", nullable = false)
	private Integer replyingadmin;

	@NotNull
	@Column(name = "replyingtime", nullable = false)
	private Instant replyingtime;

	@NotNull
	@Lob
	@Column(name = "service", nullable = false)
	private String service;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "merged_ticket_id", nullable = false)
	private Integer mergedTicketId;

	@NotNull
	@ColumnDefault("'plain'")
	@Lob
	@Column(name = "editor", nullable = false)
	private String editor;

	@Column(name = "pinned_at")
	private Instant pinnedAt;

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

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
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

	public Boolean getPreventClientClosure() {
		return preventClientClosure;
	}

	public void setPreventClientClosure(Boolean preventClientClosure) {
		this.preventClientClosure = preventClientClosure;
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

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUrgency() {
		return urgency;
	}

	public void setUrgency(String urgency) {
		this.urgency = urgency;
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

	public Instant getLastreply() {
		return lastreply;
	}

	public void setLastreply(Instant lastreply) {
		this.lastreply = lastreply;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Integer getClientunread() {
		return clientunread;
	}

	public void setClientunread(Integer clientunread) {
		this.clientunread = clientunread;
	}

	public String getAdminunread() {
		return adminunread;
	}

	public void setAdminunread(String adminunread) {
		this.adminunread = adminunread;
	}

	public Integer getReplyingadmin() {
		return replyingadmin;
	}

	public void setReplyingadmin(Integer replyingadmin) {
		this.replyingadmin = replyingadmin;
	}

	public Instant getReplyingtime() {
		return replyingtime;
	}

	public void setReplyingtime(Instant replyingtime) {
		this.replyingtime = replyingtime;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public Integer getMergedTicketId() {
		return mergedTicketId;
	}

	public void setMergedTicketId(Integer mergedTicketId) {
		this.mergedTicketId = mergedTicketId;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public Instant getPinnedAt() {
		return pinnedAt;
	}

	public void setPinnedAt(Instant pinnedAt) {
		this.pinnedAt = pinnedAt;
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Instant updatedAt) {
		this.updatedAt = updatedAt;
	}

}
