package com.apitutorial.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apitutorial.entities.TvShow;

@Repository
public interface TvShowRepository extends JpaRepository<TvShow, Long> {

	List<TvShow> findByTvShowCategoryCategoryId(Long categoryId);

}
