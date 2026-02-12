package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "tblgatewaylog")
public class Tblgatewaylog {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@ColumnDefault("'0000-00-00 00:00:00'")
	@Column(name = "date", nullable = false)
	private Instant date;

	@NotNull
	@Lob
	@Column(name = "gateway", nullable = false)
	private String gateway;

	@NotNull
	@Lob
	@Column(name = "data", nullable = false)
	private String data;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "transaction_history_id", nullable = false)
	private Integer transactionHistoryId;

	@NotNull
	@Lob
	@Column(name = "result", nullable = false)
	private String result;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public String getGateway() {
		return gateway;
	}

	public void setGateway(String gateway) {
		this.gateway = gateway;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Integer getTransactionHistoryId() {
		return transactionHistoryId;
	}

	public void setTransactionHistoryId(Integer transactionHistoryId) {
		this.transactionHistoryId = transactionHistoryId;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
