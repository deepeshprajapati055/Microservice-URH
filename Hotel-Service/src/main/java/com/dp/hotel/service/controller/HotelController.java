package com.dp.hotel.service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dp.hotel.service.entities.Hotel;
import com.dp.hotel.service.serviceinterface.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	private final HotelService hotelService;
	public HotelController(HotelService hotelService) {
		super();
		this.hotelService = hotelService;
	}

	@PostMapping
	public ResponseEntity<Hotel> saveHotels(@RequestBody Hotel hotel){
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.createHotel(hotel));
	}
	
	@GetMapping
	public ResponseEntity<List<Hotel>> showAllHotels(){
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.getAllHotel());
	}
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getHotels(@PathVariable String hotelId){
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.get(hotelId));
	}
}
