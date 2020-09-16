package com.apitutorial.json;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeasonRest implements Serializable {

	private static final long serialVersionUID = 180802329613616000L;

	private Long id;
	private short number;
	private String name;
	private List<ChapterRest> chapters;

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

	public List<ChapterRest> getChapters() {
		return chapters;
	}

	public void setChapters(List<ChapterRest> chapters) {
		this.chapters = chapters;
	}

}
