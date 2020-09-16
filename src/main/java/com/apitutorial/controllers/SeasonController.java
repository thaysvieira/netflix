package com.apitutorial.controllers;

import java.util.List;

import com.apitutorial.exceptions.NetflixException;
import com.apitutorial.json.SeasonRest;
import com.apitutorial.responses.NetflixResponse;

public interface SeasonController {

	NetflixResponse<List<SeasonRest>> getSeasonsByTvShow(final Long tvShowId) throws NetflixException;

	NetflixResponse<SeasonRest> getSeasonByTvShowIdAndSeasonNumber(final Long tvShowId, final short seasonNumber)
			throws NetflixException;

}
