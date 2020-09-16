package com.apitutorial.controllers;

import java.util.List;

import com.apitutorial.exceptions.NetflixException;
import com.apitutorial.json.ActorRest;
import com.apitutorial.responses.NetflixResponse;

public interface ActorController {

	NetflixResponse<List<ActorRest>> getActors() throws NetflixException;

	NetflixResponse<ActorRest> getActorById(final Long id) throws NetflixException;

	NetflixResponse<ActorRest> saveActor(final ActorRest actorRest) throws NetflixException;

	NetflixResponse<ActorRest> updateActor(final Long id, final ActorRest actorRest) throws NetflixException;

	NetflixResponse<String> deleteActor(final Long id) throws NetflixException;

}