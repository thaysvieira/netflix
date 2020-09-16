package com.apitutorial.controllers;

import java.util.List;

import com.apitutorial.exceptions.NetflixException;
import com.apitutorial.json.ChapterRest;
import com.apitutorial.responses.NetflixResponse;

public interface ChapterController {

	NetflixResponse<List<ChapterRest>> getChaptersByTvShowIdAndSeasonNumber(final Long tvShowId,
			final short seasonNumber) throws NetflixException;

	NetflixResponse<ChapterRest> getChapterByTvShowIdAndSeasonNumberAndChapterNumber(final Long tvShowId,
			final short seasonNumber, final short chapterNumber) throws NetflixException;

	NetflixResponse<ChapterRest> putChapter(final Long tvShowId, final short seasonNumber,
			final ChapterRest chapterRest) throws NetflixException;

	NetflixResponse<String> deleteChapter(final Long tvShowId, final short seasonNumber, final short chapterNumber)
			throws NetflixException;

}
