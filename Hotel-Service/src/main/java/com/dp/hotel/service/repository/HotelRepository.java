package com.dp.hotel.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dp.hotel.service.entities.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, String> {

}
