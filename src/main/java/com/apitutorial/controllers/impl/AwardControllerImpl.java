package com.apitutorial.controllers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.apitutorial.controllers.AwardController;
import com.apitutorial.exceptions.NetflixException;
import com.apitutorial.json.AwardRest;
import com.apitutorial.responses.NetflixResponse;
import com.apitutorial.services.AwardService;
import com.apitutorial.utils.constants.CommonConstants;
import com.apitutorial.utils.constants.RestConstants;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_AWARDS)
public class AwardControllerImpl implements AwardController {

	@Autowired
	private AwardService awardService;

	

	@Override
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = RestConstants.RESOURCE_ID,produces = MediaType.APPLICATION_JSON_VALUE)
	public NetflixResponse<AwardRest> getAwardById(Long id) throws NetflixException {
		// TODO Auto-generated method stub
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				awardService.getAwardById(id));
	}


}
