package com.apitutorial.json;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class AwardRest implements Serializable {

	private static final long serialVersionUID = -1914174620033448590L;
	
	private Long id;
	private String name;
	private TvShowRest tvShow;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TvShowRest getTvShow() {
		return tvShow;
	}

	public void setTvShow(TvShowRest tvShow) {
		this.tvShow = tvShow;
	}

}
