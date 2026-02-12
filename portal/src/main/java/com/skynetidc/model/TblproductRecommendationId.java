package com.skynetidc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class TblproductRecommendationId implements java.io.Serializable {

	private static final long serialVersionUID = 8025545369900842612L;

	@NotNull
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Column(name = "product_id", nullable = false)
	private Integer productId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
			return false;
		TblproductRecommendationId entity = (TblproductRecommendationId) o;
		return Objects.equals(this.productId, entity.productId) && Objects.equals(this.id, entity.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(productId, id);
	}

}
