package com.apitutorial.controllers;

import java.util.List;

import com.apitutorial.exceptions.NetflixException;
import com.apitutorial.json.CategoryRest;
import com.apitutorial.responses.NetflixResponse;

public interface CategoryController {

	NetflixResponse<List<CategoryRest>> getCategories() throws NetflixException;

	NetflixResponse<CategoryRest> createCategory(final CategoryRest categoryRest) throws NetflixException;

}
