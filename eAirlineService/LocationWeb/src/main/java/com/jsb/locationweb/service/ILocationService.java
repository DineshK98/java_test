package com.jsb.locationweb.service;

import java.util.List;
import java.util.Optional;

import com.jsb.locationweb.dao.LocationDao;
import com.jsb.locationweb.entity.Locations;

public interface ILocationService {
	public Locations createLocation(LocationDao locationsDao);

	public List<Locations> getAllLocation();

	public Optional<Locations> getLocationById(Long id);

	public void updateLocation(Long id, LocationDao locationDao);

	public List<Locations> deleteLocation(Long id);

}
