package com.jsb.locationweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsb.locationweb.entity.Locations;

public interface LocationRepository extends JpaRepository<Locations, Long> {

}
