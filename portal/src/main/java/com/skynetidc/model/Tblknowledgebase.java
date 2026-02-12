package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "tblknowledgebase")
public class Tblknowledgebase {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Lob
	@Column(name = "title", nullable = false)
	private String title;

	@NotNull
	@Lob
	@Column(name = "article", nullable = false)
	private String article;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "views", nullable = false)
	private Integer views;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "useful", nullable = false)
	private Integer useful;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "votes", nullable = false)
	private Integer votes;

	@NotNull
	@Lob
	@Column(name = "private", nullable = false)
	private String privateField;

	@NotNull
	@Column(name = "`order`", nullable = false)
	private Integer order;

	@NotNull
	@Column(name = "parentid", nullable = false)
	private Integer parentid;

	@NotNull
	@Lob
	@Column(name = "language", nullable = false)
	private String language;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	public Integer getUseful() {
		return useful;
	}

	public void setUseful(Integer useful) {
		this.useful = useful;
	}

	public Integer getVotes() {
		return votes;
	}

	public void setVotes(Integer votes) {
		this.votes = votes;
	}

	public String getPrivateField() {
		return privateField;
	}

	public void setPrivateField(String privateField) {
		this.privateField = privateField;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

}
