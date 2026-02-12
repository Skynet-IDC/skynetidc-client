package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "tblrsakeypairs")
public class Tblrsakeypair {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@Size(max = 96)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "identifier", nullable = false, length = 96)
	private String identifier;

	@NotNull
	@Lob
	@Column(name = "private_key", nullable = false)
	private String privateKey;

	@NotNull
	@Lob
	@Column(name = "public_key", nullable = false)
	private String publicKey;

	@Size(max = 16)
	@NotNull
	@ColumnDefault("'RS256'")
	@Column(name = "algorithm", nullable = false, length = 16)
	private String algorithm;

	@Size(max = 255)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "name", nullable = false)
	private String name;

	@Size(max = 255)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "description", nullable = false)
	private String description;

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

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public String getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
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
