package com.rahul.location.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.location.entities.Location;
import com.rahul.location.repository.LocationRepository;

@RestController
@RequestMapping("/locations")
public class LocationRestController {
	
	@Autowired
	LocationRepository locationRepository;                 // If we have some business Logic the we can autowired service layer
	
	@GetMapping                                      //@GetMapping binds the http get method to this method  in restful endpoints
	public List<Location> getLocations()
	{
		return locationRepository.findAll();
	}

	
	@PostMapping
	public Location createLocation(@RequestBody Location location)   //@RequestBody will serialize or deserialize the request
	{
		return locationRepository.save(location);
	}
	
	@PutMapping
	public Location updateLocation(@RequestBody Location location)
	{
		return locationRepository.save(location);
	}
	
	@DeleteMapping("/{id}")         //{id} path variable
	public void deleteLocation(@PathVariable("id") int id)
	{
		locationRepository.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public Location getLocation(@PathVariable("id") int id)
	{
		return locationRepository.findById(id).get();
		
	}
}
