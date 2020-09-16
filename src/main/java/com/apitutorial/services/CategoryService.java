package com.apitutorial.services;

import java.util.List;

import com.apitutorial.exceptions.NetflixException;
import com.apitutorial.json.CategoryRest;

public interface CategoryService {

	List<CategoryRest> getCategories() throws NetflixException;

	CategoryRest createCategories(final CategoryRest categoryRest) throws NetflixException;
}
