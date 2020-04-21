package com.rahul.location.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.location.entities.Location;
import com.rahul.location.repository.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	private LocationRepository repository;

	@Override
	public Location saveLocation(Location location) {
		return repository.save(location);
	}

	@Override
	public Location updateLocation(Location location) {
		return repository.save(location); 
	}

	@Override
	public void deleteLocation(Location location) {
		
		repository.delete(location);
	}

	@Override
	public Location getLocationById(int Id) {
		
		return repository.findById(Id).get();
		
	}

	@Override
	public List<Location> getAllLocations() {
		
		return repository.findAll();
	}

}
