package com.apitutorial.controllers.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.apitutorial.controllers.ChapterController;
import com.apitutorial.exceptions.NetflixException;
import com.apitutorial.json.ChapterRest;
import com.apitutorial.responses.NetflixResponse;
import com.apitutorial.services.ChapterService;
import com.apitutorial.utils.constants.CommonConstants;
import com.apitutorial.utils.constants.RestConstants;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_CHAPTER)
public class ChapterControllerImpl implements ChapterController {

	@Autowired
	private ChapterService chapterService;

	@Override
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public NetflixResponse<List<ChapterRest>> getChaptersByTvShowIdAndSeasonNumber(@PathVariable final Long tvShowId,
			@PathVariable final short seasonNumber) throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				chapterService.getChaptersByTvShowIdAndSeasonNumber(tvShowId, seasonNumber));
	}

	@Override
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = RestConstants.RESOURCE_NUMBER, produces = MediaType.APPLICATION_JSON_VALUE)
	public NetflixResponse<ChapterRest> getChapterByTvShowIdAndSeasonNumberAndChapterNumber(
			@PathVariable final Long tvShowId, @PathVariable final short seasonNumber, @PathVariable final short number)
			throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				chapterService.getChapterByTvShowIdAndSeasonNumberAndChapterNumber(tvShowId, seasonNumber, number));
	}

	@Override
	@ResponseStatus(HttpStatus.OK)
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public NetflixResponse<ChapterRest> putChapter(@PathVariable final Long tvShowId,
			@PathVariable final short seasonNumber, @RequestBody @Valid final ChapterRest chapterRest)
			throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				chapterService.putChapter(tvShowId, seasonNumber, chapterRest));
	}

	@Override
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(value = RestConstants.RESOURCE_ID, produces = MediaType.APPLICATION_JSON_VALUE)
	public NetflixResponse<String> deleteChapter(@PathVariable final Long tvShowId,
			@PathVariable final short seasonNumber, @PathVariable final short chapterNumber) throws NetflixException {
		chapterService.deleteChapter(tvShowId, seasonNumber, chapterNumber);
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.NO_CONTENT), CommonConstants.OK,
				CommonConstants.CHAPTER_DELETED);
	}

}
