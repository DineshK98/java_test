package com.jsb.locationweb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsb.locationweb.dao.LocationDao;
import com.jsb.locationweb.entity.Locations;
import com.jsb.locationweb.service.LocationServiceImpl;

@RestController
public class LocationRestController {

	@Autowired
	private LocationServiceImpl locationServiceImpl;

	@PostMapping(value = "/createLocationDetails")
	public void createLocationDetails(LocationDao locationDao) {
		locationServiceImpl.createLocation(locationDao);
	}

	@GetMapping(value = "/getAllLocationDetails")
	public List<Locations> getAllLocationDetails() {
		return locationServiceImpl.getAllLocation();
	}

	@GetMapping(value = "/getLocationById/{id}")
	public Optional<Locations> getLocationsById(@PathVariable Long id) {
		return locationServiceImpl.getLocationById(id);
	}

	@PostMapping(value = "/deleteLocation/{id}")
	public List<Locations> deletLocation(@PathVariable Long id) {
		return locationServiceImpl.deleteLocation(id);
	}

	@PutMapping(value = "/updateLocation/{id}")
	public void updateLocation(@PathVariable Long id, LocationDao locationDao) {
		locationServiceImpl.updateLocation(id, locationDao);
	}
}
