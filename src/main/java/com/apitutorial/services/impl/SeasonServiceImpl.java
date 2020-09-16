package com.apitutorial.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apitutorial.entities.Season;
import com.apitutorial.exceptions.NetflixException;
import com.apitutorial.exceptions.NotFoundException;
import com.apitutorial.json.SeasonRest;
import com.apitutorial.repositories.SeasonRepository;
import com.apitutorial.services.SeasonService;
import com.apitutorial.utils.constants.ExceptionConstants;

@Service
public class SeasonServiceImpl implements SeasonService {

	@Autowired
	private SeasonRepository seasonRepository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<SeasonRest> getSeasonsByTvShow(final Long tvShowId) throws NetflixException {
		return seasonRepository.findByTvShowId(tvShowId).stream()
				.map(season -> modelMapper.map(season, SeasonRest.class)).collect(Collectors.toList());
	}

	@Override
	public SeasonRest getSeasonByTvShowIdAndSeasonNumber(final Long tvShowId, final short seasonNumber)
			throws NetflixException {
		final Season season = seasonRepository.findByTvShowIdAndNumber(tvShowId, seasonNumber)
				.orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_SEASON));
		return modelMapper.map(season, SeasonRest.class);
	}

}
