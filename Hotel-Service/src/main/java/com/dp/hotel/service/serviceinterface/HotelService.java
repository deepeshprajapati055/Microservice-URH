package com.dp.hotel.service.serviceinterface;

import java.util.List;

import com.dp.hotel.service.entities.Hotel;

public interface HotelService {
	
	Hotel createHotel(Hotel hotel);
	
	List<Hotel> getAllHotel();
	
	Hotel get(String id);
}
