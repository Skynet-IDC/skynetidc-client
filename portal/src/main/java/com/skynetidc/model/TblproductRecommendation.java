package com.skynetidc.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "tblproduct_recommendations")
public class TblproductRecommendation {

	@EmbeddedId
	private TblproductRecommendationId id;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "sortorder", nullable = false)
	private Integer sortorder;

	public TblproductRecommendationId getId() {
		return id;
	}

	public void setId(TblproductRecommendationId id) {
		this.id = id;
	}

	public Integer getSortorder() {
		return sortorder;
	}

	public void setSortorder(Integer sortorder) {
		this.sortorder = sortorder;
	}

}
