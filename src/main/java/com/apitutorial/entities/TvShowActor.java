package com.apitutorial.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TVSHOWS_ACTORS")
public class TvShowActor implements Serializable {

	private static final long serialVersionUID = 6743083122350180121L;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TVSHOW_ID", nullable = false)
	private TvShow tvShow;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACTOR_ID", nullable = false)
	private Actor actor;

	public TvShow getTvShow() {
		return tvShow;
	}

	public void setTvShow(TvShow tvShow) {
		this.tvShow = tvShow;
	}

	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}
	
}
