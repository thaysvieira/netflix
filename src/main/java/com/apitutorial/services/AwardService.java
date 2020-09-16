package com.apitutorial.services;

import com.apitutorial.exceptions.NetflixException;
import com.apitutorial.json.AwardRest;

public interface AwardService {
    AwardRest getAwardById(Long id) throws NetflixException;

}
