package com.dp.rating.services.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dp.rating.services.entites.Rating;
import com.dp.rating.services.service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {
	
	private final RatingService ratingService;
	public RatingController(RatingService ratingService) {
		super();
		this.ratingService = ratingService;
	}
	
	@PostMapping
	public ResponseEntity<Rating> save(@RequestBody Rating rating){
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
	}
	
	@GetMapping
	public ResponseEntity<List<Rating>> getAllRatings(){
		return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatings());
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Rating>> getAllRatingByUsers(@PathVariable String userId){
		return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingByUserId(userId));
	}
	
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<Rating>> getAllRatingByHotel(@PathVariable String hotelId){
		return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingByHotelId(hotelId));
	}
	
}