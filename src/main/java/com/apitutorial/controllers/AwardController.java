package com.apitutorial.controllers;

import com.apitutorial.exceptions.NetflixException;
import com.apitutorial.json.AwardRest;
import com.apitutorial.responses.NetflixResponse;

public interface AwardController {
	NetflixResponse<AwardRest> getAwardById(Long id) throws NetflixException;

	
}
