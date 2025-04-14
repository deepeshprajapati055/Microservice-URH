package com.dp.user.service.service.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dp.user.service.entities.Hotel;
import com.dp.user.service.entities.Ratings;
import com.dp.user.service.entities.UserEntity;
import com.dp.user.service.exception.ResourceNotFoundExceptions;
import com.dp.user.service.repository.UserRepository;
import com.dp.user.service.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository;
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	@Autowired
	private RestTemplate restTemplate;
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Override
	public UserEntity saveUser(UserEntity user) {
		String randomUserID = UUID.randomUUID().toString();
		user.setUserId(randomUserID);
		return this.userRepository.save(user);
	}

	@Override
	public List<UserEntity> getAllUsers() {
	    List<UserEntity> users = userRepository.findAll();

	    return users.stream().map(user -> {
	        Ratings[] ratingsArray = restTemplate.getForObject(
	                "http://localhost:8083/rating/user/" + user.getUserId(), Ratings[].class);

	        if (ratingsArray != null) {
	            List<Ratings> ratings = Arrays.stream(ratingsArray).map(rating -> {
	                ResponseEntity<Hotel> response = restTemplate.getForEntity(
	                        "http://localhost:8082/hotels/" + rating.getHotelId(), Hotel.class);
	                Hotel hotel = response.getBody();
	                logger.info("Hotel service response status: {}", response.getStatusCode());

	                rating.setHotel(hotel);
	                return rating;
	            }).collect(Collectors.toList());

	            user.setRatings(ratings);
	        } else {
	            user.setRatings(Collections.emptyList());
	        }

	        return user;
	    }).collect(Collectors.toList());
	}

	

	@Override
	public UserEntity getUser(String userId) {
		UserEntity user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundExceptions("User with given id is not found on server!! : "+userId));
		
		Ratings[] ratingsOfList = restTemplate.getForObject("http://localhost:8083/rating/user/"+user.getUserId(), Ratings[].class); 
		
		List<Ratings> ratings =  Arrays.stream(ratingsOfList).toList();
		
		List<Ratings> ratingList = ratings.stream().map(rating->{
			ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://localhost:8082/hotels/"+rating.getHotelId(), Hotel.class);
			Hotel hotel = forEntity.getBody();
			logger.info("response status code : {} ", forEntity.getStatusCode());
			rating.setHotel(hotel);
			return rating;
		}).collect(Collectors.toList());
		
		user.setRatings(ratingList);
		return user;
	}
}