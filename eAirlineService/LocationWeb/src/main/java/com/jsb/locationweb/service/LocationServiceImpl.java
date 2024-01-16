package com.jsb.locationweb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsb.locationweb.dao.LocationDao;
import com.jsb.locationweb.entity.Locations;
import com.jsb.locationweb.repository.LocationRepository;

@Service
public class LocationServiceImpl implements ILocationService {

	@Autowired
	private LocationRepository locationRepository;

	@Override
	public Locations createLocation(LocationDao locationDao) {
		Locations locations = new Locations();
		locations.setCode(locationDao.getCode());
		locations.setName(locationDao.getName());
		locations.setType(locationDao.getType());
		locationRepository.save(locations);
		System.out.println("Location Created");
		return locations;
	}

	@Override
	public List<Locations> getAllLocation() {
		return locationRepository.findAll();
	}

	@Override
	public Optional<Locations> getLocationById(Long id) {
		return locationRepository.findById(id);
	}

	@Override
	public void updateLocation(Long id, LocationDao locationDao) {
		Optional<Locations> findById = locationRepository.findById(id);
		if (findById.isPresent()) {
			Locations locations = findById.get();
			locations.setName(locationDao.getName());
			locationRepository.save(locations);

		}

	}

	@Override
	public List<Locations> deleteLocation(Long id) {
		locationRepository.deleteById(id);
		List<Locations> findAll = locationRepository.findAll();
		return findAll;
	}

}
