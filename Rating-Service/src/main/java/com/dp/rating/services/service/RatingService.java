package com.dp.rating.services.service;

import java.util.List;

import com.dp.rating.services.entites.Rating;

public interface RatingService {

	Rating create(Rating rating);
	
	List<Rating> getRatings();
	
	List<Rating> getRatingByUserId(String userId);
	
	List<Rating> getRatingByHotelId(String hotelId);
	
}
