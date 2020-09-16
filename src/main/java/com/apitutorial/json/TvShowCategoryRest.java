package com.apitutorial.json;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TvShowCategoryRest implements Serializable {

	private static final long serialVersionUID = -745746066072238045L;
	
	private TvShowRest tvShowRest;
	
	private CategoryRest categoryRest;

	public TvShowRest getTvShowRest() {
		return tvShowRest;
	}

	public void setTvShowRest(TvShowRest tvShowRest) {
		this.tvShowRest = tvShowRest;
	}

	public CategoryRest getCategoryRest() {
		return categoryRest;
	}

	public void setCategoryRest(CategoryRest categoryRest) {
		this.categoryRest = categoryRest;
	}

}
