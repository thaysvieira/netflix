package com.apitutorial.services.impl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apitutorial.entities.Award;
import com.apitutorial.exceptions.NetflixException;
import com.apitutorial.json.AwardRest;
import com.apitutorial.repositories.AwardRepository;
import com.apitutorial.services.AwardService;

@Service
public class AwardServiceImpl implements AwardService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AwardServiceImpl.class);

	@Autowired
	private AwardRepository awardRepository;
	


	private ModelMapper modelMapper = new ModelMapper();



	@Override
	public AwardRest getAwardById(Long id) throws NetflixException {
		// TODO Auto-generated method stub
		Award award = new Award();
		//Optional<Award> award = awardRepository.findById(id);
         if(awardRepository.findById(id).isPresent()) {
        	 award = awardRepository.findById(id).get();
         }
      	return modelMapper.map(award, AwardRest.class);

	}



}
