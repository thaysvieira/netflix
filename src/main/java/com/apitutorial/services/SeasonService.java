package com.apitutorial.services;

import java.util.List;

import com.apitutorial.exceptions.NetflixException;
import com.apitutorial.json.SeasonRest;

public interface SeasonService {

	List<SeasonRest> getSeasonsByTvShow(final Long tvShowId) throws NetflixException;

	SeasonRest getSeasonByTvShowIdAndSeasonNumber(final Long tvShowId, final short seasonNumber)
			throws NetflixException;

}
