package com.apitutorial.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apitutorial.entities.Chapter;
import com.apitutorial.exceptions.NetflixException;
import com.apitutorial.exceptions.NotFoundException;
import com.apitutorial.json.ChapterRest;
import com.apitutorial.repositories.ChapterRepository;
import com.apitutorial.services.ChapterService;
import com.apitutorial.utils.constants.ExceptionConstants;

@Service
public class ChapterServiceImpl implements ChapterService {

	@Autowired
	private ChapterRepository chapterRepository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<ChapterRest> getChaptersByTvShowIdAndSeasonNumber(final Long tvShowId, final short seasonNumber)
			throws NetflixException {
		return chapterRepository.findBySeasonTvShowIdAndSeasonNumber(tvShowId, seasonNumber).stream()
				.map(chapter -> modelMapper.map(chapter, ChapterRest.class)).collect(Collectors.toList());
	}

	@Override
	public ChapterRest getChapterByTvShowIdAndSeasonNumberAndChapterNumber(final Long tvShowId,
			final short seasonNumber, final short chapterNumber) throws NetflixException {
		final Chapter chapter = chapterRepository
				.findBySeasonTvShowIdAndSeasonNumberAndNumber(tvShowId, seasonNumber, chapterNumber)
				.orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_CHAPTER));
		return modelMapper.map(chapter, ChapterRest.class);
	}

	@Override
	public ChapterRest putChapter(final Long tvShowId, final short seasonNumber, final ChapterRest chapterRest)
			throws NetflixException {
		Chapter chapter = chapterRepository
				.findBySeasonTvShowIdAndSeasonNumberAndNumber(tvShowId, seasonNumber, chapterRest.getNumber())
				.orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_CHAPTER));
		String name = chapterRest.getName();
		chapter.setName(name);
		chapter = chapterRepository.save(chapter);

		return modelMapper.map(chapter, ChapterRest.class);
	}

	@Override
	public void deleteChapter(final Long tvShowId, final short seasonNumber, final short chapterNumber)
			throws NetflixException {
		final Chapter chapter = chapterRepository
				.findBySeasonTvShowIdAndSeasonNumberAndNumber(tvShowId, seasonNumber, chapterNumber)
				.orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_CHAPTER));
		chapterRepository.delete(chapter);
	}

}
