package com.motus.emotion.service.impl;

import com.motus.emotion.model.Location;
import com.motus.emotion.repository.LocationRepository;
import com.motus.emotion.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "LocationService")
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public Location create(Location location) {
        return locationRepository.save(location);
    }
}
