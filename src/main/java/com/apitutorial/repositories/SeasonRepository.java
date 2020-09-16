package com.apitutorial.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apitutorial.entities.Season;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Long> {

	List<Season> findByTvShowId(final Long tvShowId);

	Optional<Season> findByTvShowIdAndNumber(final Long tvShowId, final short seasonNumber);

}
