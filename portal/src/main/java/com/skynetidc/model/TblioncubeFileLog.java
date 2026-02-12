package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "tblioncube_file_log")
public class TblioncubeFileLog {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Lob
	@Column(name = "filename", nullable = false)
	private String filename;

	@Size(max = 512)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "content_hash", nullable = false, length = 512)
	private String contentHash;

	@Size(max = 16)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "encoder_version", nullable = false, length = 16)
	private String encoderVersion;

	@Size(max = 128)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "bundled_php_versions", nullable = false, length = 128)
	private String bundledPhpVersions;

	@Size(max = 128)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "loaded_in_php", nullable = false, length = 128)
	private String loadedInPhp;

	@Size(max = 16)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "target_php_version", nullable = false, length = 16)
	private String targetPhpVersion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getContentHash() {
		return contentHash;
	}

	public void setContentHash(String contentHash) {
		this.contentHash = contentHash;
	}

	public String getEncoderVersion() {
		return encoderVersion;
	}

	public void setEncoderVersion(String encoderVersion) {
		this.encoderVersion = encoderVersion;
	}

	public String getBundledPhpVersions() {
		return bundledPhpVersions;
	}

	public void setBundledPhpVersions(String bundledPhpVersions) {
		this.bundledPhpVersions = bundledPhpVersions;
	}

	public String getLoadedInPhp() {
		return loadedInPhp;
	}

	public void setLoadedInPhp(String loadedInPhp) {
		this.loadedInPhp = loadedInPhp;
	}

	public String getTargetPhpVersion() {
		return targetPhpVersion;
	}

	public void setTargetPhpVersion(String targetPhpVersion) {
		this.targetPhpVersion = targetPhpVersion;
	}

}
