package com.apitutorial.json;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActorRest implements Serializable {

	private static final long serialVersionUID = 4916713904971425156L;

	private Long id;
	private String name;
	private Date birthDate;
	private String placeOfBirth;
	private List<TvShowRest> tvShows;
	
	public ActorRest(Long id) {
		super();
		this.id = id;
	}
	
	public ActorRest() {
		super();
	}



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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public List<TvShowRest> getTvShows() {
		return tvShows;
	}

	public void setTvShows(List<TvShowRest> tvShows) {
		this.tvShows = tvShows;
	}

}
