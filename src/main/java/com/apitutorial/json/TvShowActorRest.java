package com.apitutorial.json;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TvShowActorRest implements Serializable {

	private static final long serialVersionUID = -745746066072238045L;
	
	private TvShowRest tvShow;
	
	private ActorRest actor;

	public TvShowRest getTvShow() {
		return tvShow;
	}

	public void setTvShow(TvShowRest tvShow) {
		this.tvShow = tvShow;
	}

	public ActorRest getActor() {
		return actor;
	}

	public void setActor(ActorRest actor) {
		this.actor = actor;
	}

	

}
