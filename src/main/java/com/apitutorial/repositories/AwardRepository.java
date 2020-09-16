package com.apitutorial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apitutorial.entities.Award;

@Repository
public interface AwardRepository extends JpaRepository<Award, Long> {
	


}
