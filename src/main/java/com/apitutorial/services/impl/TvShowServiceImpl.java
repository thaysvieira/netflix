package com.apitutorial.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apitutorial.entities.Award;
import com.apitutorial.entities.Category;
import com.apitutorial.entities.TvShow;
import com.apitutorial.exceptions.NetflixException;
import com.apitutorial.exceptions.NotFoundException;
import com.apitutorial.json.AwardRest;
import com.apitutorial.json.CategoryRest;
import com.apitutorial.json.TvShowRest;
import com.apitutorial.repositories.TvShowRepository;
import com.apitutorial.services.TvShowService;
import com.apitutorial.utils.constants.ExceptionConstants;

@Service
public class TvShowServiceImpl implements TvShowService {

	@Autowired
	private TvShowRepository tvShowRepository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<TvShowRest> getTvShowsByCategory(final Long categoryId) throws NetflixException {
		List<TvShowRest> tvShowList = tvShowRepository.findByTvShowCategoryCategoryId(categoryId).stream()
				.map(tvShow -> {
					List<CategoryRest> categories = tvShow.getTvShowCategory().stream()
							.filter(tvShowCategory -> tvShowCategory.getCategory().getId() == categoryId)
							.map(tvShowCategory -> {
								final Category category = tvShowCategory.getCategory();
								return getCategoryRest(category);
							}).collect(Collectors.toList());
					final TvShowRest tvShowRest = getTvShowRest(tvShow);
					tvShowRest.setCategories(categories);
					return tvShowRest;
				}).collect(Collectors.toList());

		return tvShowList;
	}

	@Override
	public List<TvShowRest> getTvShows() throws NetflixException {
		List<TvShowRest> tvShowList = tvShowRepository.findAll().stream().map(tvShow -> {
			List<CategoryRest> categories = tvShow.getTvShowCategory().stream().map(tvShowCategory -> {
				final Category category = tvShowCategory.getCategory();
				return getCategoryRest(category);
			}).collect(Collectors.toList());
			final TvShowRest tvShowRest = getTvShowRest(tvShow);
			tvShowRest.setCategories(categories);
			return tvShowRest;
		}).collect(Collectors.toList());

		return tvShowList;

	}

	@Override
	public TvShowRest getTvShowById(final Long id) throws NetflixException {
		final TvShow tvShow = tvShowRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_TV_SHOW));
		return getTvShowRest(tvShow);
	}

	@Override
	public TvShowRest putTvShow(final Long id, final TvShowRest tvShowRest) throws NetflixException {
		TvShow tvShow = tvShowRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_TV_SHOW));
		String name = tvShowRest.getName();
		tvShow.setName(name);
		tvShow = tvShowRepository.save(tvShow);
		return modelMapper.map(tvShow, TvShowRest.class);
	}

	@Override
	public void deleteTvShow(final Long id) throws NetflixException {
		final TvShow tvShow = tvShowRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_TV_SHOW));
		tvShowRepository.delete(tvShow);
	}

	@Override
	public TvShowRest getTvShowByIdAwards(final Long id) throws NetflixException {
		final TvShow tvShow = tvShowRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_TV_SHOW));
		final TvShowRest tvShowRest = getTvShowRest(tvShow);
		final List<AwardRest> awardRestList = tvShow.getAwards().stream().map(award -> {
			return getAwardRest(award);
		}).collect(Collectors.toList());
		tvShowRest.setAwards(awardRestList);
		return tvShowRest;

	}

	@Override
	public TvShowRest getTvShowByIdPoints(final Long id) throws NetflixException {
		final TvShow tvShow = tvShowRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_TV_SHOW));

		final TvShowRest tvShowRest = getTvShowRest(tvShow);
		return tvShowRest;
	}

	private CategoryRest getCategoryRest(final Category category) {
		final CategoryRest categoryRest = new CategoryRest();
		categoryRest.setId(category.getId());
		categoryRest.setName(category.getName());
		return categoryRest;
	}

	private TvShowRest getTvShowRest(final TvShow tvShow) {
		final TvShowRest tvShowRest = new TvShowRest();
		tvShowRest.setId(tvShow.getId());
		tvShowRest.setName(tvShow.getName());
		tvShowRest.setLongDescription(tvShow.getLongDescription());
		tvShowRest.setRecommendedAge(tvShow.getRecommendedAge());
		tvShowRest.setYear(tvShow.getYear());
		return tvShowRest;
	}

	private AwardRest getAwardRest(Award award) {
		AwardRest awardRest = new AwardRest();
		awardRest.setId(award.getId());
		awardRest.setName(award.getName());
		return awardRest;
	}

}
