package com.apitutorial.controllers.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.apitutorial.controllers.ActorController;
import com.apitutorial.exceptions.NetflixException;
import com.apitutorial.json.ActorRest;
import com.apitutorial.responses.NetflixResponse;
import com.apitutorial.services.ActorService;
import com.apitutorial.utils.constants.CommonConstants;
import com.apitutorial.utils.constants.RestConstants;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_ACTORS)
public class ActorControllerImpl implements ActorController {

	@Autowired
	private ActorService actorService;

	@Override
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public NetflixResponse<List<ActorRest>> getActors() throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				actorService.getActors());
	}

	@Override
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = RestConstants.RESOURCE_ID, produces = MediaType.APPLICATION_JSON_VALUE)
	public NetflixResponse<ActorRest> getActorById(@PathVariable final Long id) throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				actorService.getActorById(id));
	}

	@Override
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public NetflixResponse<ActorRest> saveActor(
			@ApiParam(value = RestConstants.PARAMETER_ACTOR, required = true) @RequestBody @Valid final ActorRest actorRest)
			throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				actorService.saveActor(actorRest));
	}

	@Override
	@ResponseStatus(HttpStatus.OK)
	@PutMapping(value = RestConstants.RESOURCE_ID, consumes = MediaType.APPLICATION_JSON_VALUE)
	public NetflixResponse<ActorRest> updateActor(@PathVariable final Long id,
			@ApiParam(value = RestConstants.PARAMETER_ACTOR, required = true) @RequestBody @Valid final ActorRest actorRest)
			throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				actorService.updateActor(id, actorRest));

	}

	@Override
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(value = RestConstants.RESOURCE_ID, consumes = MediaType.APPLICATION_JSON_VALUE)
	public NetflixResponse<String> deleteActor(@PathVariable final Long id) throws NetflixException {
		actorService.deleteActor(id);
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.NO_CONTENT), CommonConstants.OK,
				CommonConstants.ACTOR_DELETED);
	}
}
