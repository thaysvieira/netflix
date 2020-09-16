package com.apitutorial.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apitutorial.entities.Chapter;

@Repository
public interface ChapterRepository extends JpaRepository<Chapter, Long> {

	List<Chapter> findBySeasonTvShowIdAndSeasonNumber(final Long tvShowId, final short seasonNumber);

	Optional<Chapter> findBySeasonTvShowIdAndSeasonNumberAndNumber(final Long tvShowId, final short seasonNumber,
			final short chapterNumber);

}
