package com.apitutorial.json;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChapterRest implements Serializable {

	private static final long serialVersionUID = 8725949484031409482L;

	private Long id;
	private short number;
	private String name;
	private short duration;
	private Long seasonId;

	public ChapterRest() {
		super();
	}

	public ChapterRest(Long id) {
		super();
		this.id = id;
	}

	public ChapterRest(Long id, short number, String name, short duration, Long seasonId) {
		super();
		this.id = id;
		this.number = number;
		this.name = name;
		this.duration = duration;
		this.seasonId = seasonId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public short getNumber() {
		return number;
	}

	public void setNumber(short number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public short getDuration() {
		return duration;
	}

	public void setDuration(short duration) {
		this.duration = duration;
	}

	public Long getSeasonId() {
		return seasonId;
	}

	public void setSeasonId(Long seasonId) {
		this.seasonId = seasonId;
	}

}
