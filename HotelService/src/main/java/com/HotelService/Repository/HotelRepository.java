package com.HotelService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HotelService.Entity.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, String> {

}
