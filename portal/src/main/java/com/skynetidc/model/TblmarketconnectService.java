package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "tblmarketconnect_services")
public class TblmarketconnectService {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@Size(max = 30)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "name", nullable = false, length = 30)
	private String name;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "status", nullable = false)
	private Boolean status = false;

	@NotNull
	@Lob
	@Column(name = "product_ids", nullable = false)
	private String productIds;

	@NotNull
	@Lob
	@Column(name = "settings", nullable = false)
	private String settings;

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

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getProductIds() {
		return productIds;
	}

	public void setProductIds(String productIds) {
		this.productIds = productIds;
	}

	public String getSettings() {
		return settings;
	}

	public void setSettings(String settings) {
		this.settings = settings;
	}

}
