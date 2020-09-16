package com.apitutorial.json;

import java.io.Serializable;
import java.time.Year;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TvShowRest implements Serializable {

	private static final long serialVersionUID = 4916713904971425156L;

	private Long id;
	private String name;
	private String shortDescription;
	private String longDescription;
	private Year year;
	private byte recommendedAge;
	private String advertising;
	private List<CategoryRest> categories;
	private List<ActorRest> actors;
	private List<SeasonRest> seasons;
	private List<AwardRest> awards;
	private Double points;
	
	
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

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public Year getYear() {
		return year;
	}

	public void setYear(Year year) {
		this.year = year;
	}

	public byte getRecommendedAge() {
		return recommendedAge;
	}

	public void setRecommendedAge(byte recommendedAge) {
		this.recommendedAge = recommendedAge;
	}

	public String getAdvertising() {
		return advertising;
	}

	public void setAdvertising(String advertising) {
		this.advertising = advertising;
	}

	public List<CategoryRest> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryRest> categories) {
		this.categories = categories;
	}

	public List<ActorRest> getActors() {
		return actors;
	}

	public void setActors(List<ActorRest> actors) {
		this.actors = actors;
	}

	public List<SeasonRest> getSeasons() {
		return seasons;
	}

	public void setSeasons(List<SeasonRest> seasons) {
		this.seasons = seasons;
	}

	public List<AwardRest> getAwards() {
		return awards;
	}

	public void setAwards(List<AwardRest> awards) {
		this.awards = awards;
	}

	public Double getPoints() {
		return points;
	}

	public void setPoints(Double points) {
		this.points = points;
	}

}
