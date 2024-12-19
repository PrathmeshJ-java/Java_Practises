package com.HotelService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HotelService.Entity.Hotel;
import com.HotelService.Service.HotelService;


@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired(required = true)
	private HotelService hotelService;
	
	@PostMapping
	public ResponseEntity<Hotel> saveUser(@RequestBody Hotel hotel){
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.createhotel(hotel));
	}
	
	
	@GetMapping
	public ResponseEntity<List<Hotel>> AllHotel(){
		List hotel1 = hotelService.getAllhotels();
		return ResponseEntity.ok(hotel1);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Hotel> Alluser(@PathVariable String id){
		Optional<Hotel> optionalhotel = hotelService.gethotel(id);

	    if (optionalhotel.isPresent()) {
	        Hotel hotel = optionalhotel.get();
	        return ResponseEntity.ok(hotel);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	    
	    
	

}
