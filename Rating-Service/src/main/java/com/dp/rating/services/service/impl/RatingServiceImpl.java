package com.dp.rating.services.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.dp.rating.services.Repository.RatingRepository;
import com.dp.rating.services.entites.Rating;
import com.dp.rating.services.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {
	
	private final RatingRepository ratingRepository;
	public RatingServiceImpl(RatingRepository ratingRepository) {
		super();
		this.ratingRepository = ratingRepository;
	}

	@Override
	public Rating create(Rating rating) {
		String ratings = UUID.randomUUID().toString();
		rating.setRatingId(ratings);
		return this.ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getRatings() {
		return this.ratingRepository.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		return this.ratingRepository.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		return this.ratingRepository.findByHotelId(hotelId);
	}

}
