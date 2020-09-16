package com.apitutorial.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TVSHOWS_CATEGORIES")
public class TvShowCategory implements Serializable {

	private static final long serialVersionUID = -9184354615276785243L;
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TVSHOW_ID", nullable = false)
	private TvShow tvShow;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CATEGORY_ID", nullable = false)
	private Category category;
	
	
	public TvShow getTvShow() {
		return tvShow;
	}

	public void setTvShow(TvShow tvShow) {
		this.tvShow = tvShow;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}
