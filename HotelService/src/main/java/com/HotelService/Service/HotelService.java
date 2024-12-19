package com.HotelService.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HotelService.Entity.Hotel;
import com.HotelService.Repository.HotelRepository;


@Service
public class HotelService {
	
	@Autowired
	private HotelRepository hotelRepository;
	
	public Hotel createhotel(Hotel hotel) {
//		String randomid = UUID.randomUUID().toString();
//		hotel.setId(randomid);
		return this.hotelRepository.save(hotel);
	}

	
	public List<Hotel> getAllhotels() {
		return this.hotelRepository.findAll();
	}

	
	public Optional<Hotel> gethotel(String id) {
		return this.hotelRepository.findById(id);
	}

}
