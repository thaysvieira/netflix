package com.apitutorial.controllers.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.apitutorial.controllers.SeasonController;
import com.apitutorial.exceptions.NetflixException;
import com.apitutorial.json.SeasonRest;
import com.apitutorial.responses.NetflixResponse;
import com.apitutorial.services.SeasonService;
import com.apitutorial.utils.constants.CommonConstants;
import com.apitutorial.utils.constants.RestConstants;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_SEASON)
public class SeasonControllerImpl implements SeasonController {

	@Autowired
	private SeasonService seasonService;

	@Override
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public NetflixResponse<List<SeasonRest>> getSeasonsByTvShow(final Long tvShowId) throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				seasonService.getSeasonsByTvShow(tvShowId));
	}

	@Override
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = RestConstants.RESOURCE_NUMBER, produces = MediaType.APPLICATION_JSON_VALUE)
	public NetflixResponse<SeasonRest> getSeasonByTvShowIdAndSeasonNumber(@PathVariable final Long tvShowId,
			@PathVariable final short number) throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				seasonService.getSeasonByTvShowIdAndSeasonNumber(tvShowId, number));
	}

}
