package com.apitutorial.controllers;

import java.util.List;

import com.apitutorial.exceptions.NetflixException;
import com.apitutorial.json.TvShowRest;
import com.apitutorial.responses.NetflixResponse;

public interface TvShowController {

	NetflixResponse<List<TvShowRest>> getTvShowsByCategoryId(final Long categoryId) throws NetflixException;

	NetflixResponse<List<TvShowRest>> getTvShows() throws NetflixException;

	NetflixResponse<TvShowRest> getTvShowById(final Long id) throws NetflixException;

	NetflixResponse<TvShowRest> putTvShow(final Long id, final TvShowRest tvShowRest) throws NetflixException;

	NetflixResponse<String> deleteTvShow(final Long id) throws NetflixException;

	NetflixResponse<TvShowRest> getTvShowByIdAwards(final Long id) throws NetflixException;

	NetflixResponse<TvShowRest> getTvShowByIdPoints(final Long id) throws NetflixException;
}
