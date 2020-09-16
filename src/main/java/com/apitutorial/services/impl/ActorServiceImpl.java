package com.apitutorial.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apitutorial.entities.Actor;
import com.apitutorial.entities.Season;
import com.apitutorial.entities.TvShow;
import com.apitutorial.entities.TvShowActor;
import com.apitutorial.exceptions.InternalServerErrorException;
import com.apitutorial.exceptions.NetflixException;
import com.apitutorial.exceptions.NotFoundException;
import com.apitutorial.json.ActorRest;
import com.apitutorial.json.ChapterRest;
import com.apitutorial.json.SeasonRest;
import com.apitutorial.json.TvShowRest;
import com.apitutorial.repositories.ActorRepository;
import com.apitutorial.services.ActorService;
import com.apitutorial.utils.constants.ExceptionConstants;

@Service
public class ActorServiceImpl implements ActorService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ActorServiceImpl.class);

	@Autowired
	private ActorRepository actorRepository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<ActorRest> getActors() throws NetflixException {
		return actorRepository.findAll().stream().map(actor -> modelMapper.map(actor, ActorRest.class))
				.collect(Collectors.toList());

	}

	@Override
	public ActorRest getActorById(final Long id) throws NetflixException {
		final Actor actor = actorRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_ACTOR));

		final ActorRest actorRest = modelMapper.map(actor, ActorRest.class);
		final List<TvShowActor> tvShowActorList = actor.getTvShowsActors();
		final List<TvShowRest> tvShowRestList = new ArrayList<>();

		tvShowActorList.stream().forEach(tvShowActor -> {
			final TvShowRest tvShowRest = getTvShowRest(tvShowActor.getTvShow());
			tvShowRestList.add(tvShowRest);
		});

		actorRest.setTvShows(tvShowRestList);
		return actorRest;
	}

	private TvShowRest getTvShowRest(final TvShow tvShow) {
		final TvShowRest tvShowRest = new TvShowRest();
		tvShowRest.setId(tvShow.getId());
		tvShowRest.setName(tvShow.getName());
		tvShowRest.setRecommendedAge(tvShow.getRecommendedAge());
		final List<SeasonRest> seasonRestList = getSeasonRestList(tvShow);
		tvShowRest.setSeasons(seasonRestList);
		return tvShowRest;
	}

	private List<SeasonRest> getSeasonRestList(final TvShow tvShow) {
		final List<Season> seasons = tvShow.getSeasons();
		return seasons.stream().map(season -> {
			final SeasonRest seasonRest = getSeasonRest(season);
			final List<ChapterRest> chapterRestList = getChapterRestList(season);
			seasonRest.setChapters(chapterRestList);
			return seasonRest;
		}).collect(Collectors.toList());
	}

	private List<ChapterRest> getChapterRestList(final Season season) {
		return season.getChapters().stream().map(chapter -> {
			final ChapterRest chapterRest = new ChapterRest();
			chapterRest.setId(chapter.getId());
			chapterRest.setName(chapter.getName());
			return chapterRest;
		}).collect(Collectors.toList());
	}

	private SeasonRest getSeasonRest(final Season season) {
		final SeasonRest seasonRest = new SeasonRest();
		seasonRest.setId(season.getId());
		seasonRest.setName(season.getName());
		seasonRest.setNumber(season.getNumber());
		return seasonRest;
	}

	@Override
	public ActorRest saveActor(final ActorRest actorRest) throws NetflixException {
		Actor actor = getActorEntity(actorRest);
		try {
			actor = actorRepository.save(actor);
		} catch (final Exception e) {
			LOGGER.error(ExceptionConstants.INTERNAL_SERVER_ERROR, e);
			throw new InternalServerErrorException(ExceptionConstants.INTERNAL_SERVER_ERROR);
		}
		return modelMapper.map(actor, ActorRest.class);
	}

	private Actor getActorEntity(final ActorRest actorRest) {
		Actor actor = new Actor();
		actor.setName(actorRest.getName());
		return actor;
	}

	@Override
	public ActorRest updateActor(final Long id, final ActorRest actorRest) throws NetflixException {
		Actor actor = actorRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_TV_SHOW));
		actor.setName(actorRest.getName());
		actor = actorRepository.save(actor);
		return modelMapper.map(actor, ActorRest.class);
	}

	@Override
	public void deleteActor(final Long id) throws NetflixException {
		final Actor actor = actorRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_ACTOR));
		actorRepository.delete(actor);
	}

}
