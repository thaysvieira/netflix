package com.apitutorial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apitutorial.entities.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {

}
