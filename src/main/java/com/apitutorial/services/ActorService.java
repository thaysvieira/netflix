package com.apitutorial.services;

import java.util.List;

import com.apitutorial.exceptions.NetflixException;
import com.apitutorial.json.ActorRest;

public interface ActorService {

	List<ActorRest> getActors() throws NetflixException;

	ActorRest getActorById(final Long id) throws NetflixException;

	ActorRest saveActor(final ActorRest actorRest) throws NetflixException;

	ActorRest updateActor(final Long id, final ActorRest actorRest) throws NetflixException;

	void deleteActor(final Long id) throws NetflixException;
}
