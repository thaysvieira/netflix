package com.apitutorial.services;

import java.util.List;

import com.apitutorial.exceptions.NetflixException;
import com.apitutorial.json.TvShowRest;

public interface TvShowService {

	List<TvShowRest> getTvShowsByCategory(final Long categoryId) throws NetflixException;

	List<TvShowRest> getTvShows() throws NetflixException;

	TvShowRest getTvShowById(final Long id) throws NetflixException;

	TvShowRest putTvShow(final Long id, final TvShowRest tvShowRest) throws NetflixException;

	void deleteTvShow(final Long id) throws NetflixException;

	TvShowRest getTvShowByIdAwards(final Long id) throws NetflixException;

	TvShowRest getTvShowByIdPoints(final Long id) throws NetflixException;

}
