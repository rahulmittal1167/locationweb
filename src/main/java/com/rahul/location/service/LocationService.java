package com.rahul.location.service;

import java.util.List;

import com.rahul.location.entities.Location;

public interface LocationService {
	
	Location saveLocation(Location location);
	Location updateLocation(Location location);
	void deleteLocation(Location location);
	Location getLocationById(int Id);
	List<Location> getAllLocations();

}
