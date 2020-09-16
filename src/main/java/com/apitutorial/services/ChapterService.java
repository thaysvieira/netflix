package com.apitutorial.services;

import java.util.List;

import com.apitutorial.exceptions.NetflixException;
import com.apitutorial.json.ChapterRest;

public interface ChapterService {

	List<ChapterRest> getChaptersByTvShowIdAndSeasonNumber(final Long tvShowId, final short seasonNumber)
			throws NetflixException;

	ChapterRest getChapterByTvShowIdAndSeasonNumberAndChapterNumber(final Long tvShowId, final short seasonNumber,
			final short chapterNumber) throws NetflixException;

	ChapterRest putChapter(final Long tvShowId, final short seasonNumber, final ChapterRest chapterRest)
			throws NetflixException;

	void deleteChapter(final Long tvShowId, final short seasonNumber, final short chapterNumber)
			throws NetflixException;
}
