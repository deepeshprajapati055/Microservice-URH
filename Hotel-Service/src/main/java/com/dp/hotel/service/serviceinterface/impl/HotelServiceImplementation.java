package com.dp.hotel.service.serviceinterface.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.dp.hotel.service.entities.Hotel;
import com.dp.hotel.service.exceptions.ResourceNotFoundException;
import com.dp.hotel.service.repository.HotelRepository;
import com.dp.hotel.service.serviceinterface.HotelService;

@Service
public class HotelServiceImplementation implements HotelService{

	private final HotelRepository hotelRepository;
	public HotelServiceImplementation(HotelRepository hotelRepository) {
		super();
		this.hotelRepository = hotelRepository;
	}

	@Override
	public Hotel createHotel(Hotel hotel) {
		String hotelId = UUID.randomUUID().toString();
		hotel.setId(hotelId);
		return this.hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotel() {
		return this.hotelRepository.findAll();
	}

	@Override
	public Hotel get(String id) {
		return this.hotelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("hotel is not found with given id!!"));
	}

}
