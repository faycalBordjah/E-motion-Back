package com.motus.emotion.service.impl;

import com.motus.emotion.dto.LocationDto;
import com.motus.emotion.exception.NotFoundException;
import com.motus.emotion.model.Location;
import com.motus.emotion.repository.LocationRepository;
import com.motus.emotion.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "LocationService")
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public Location create(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public List<Location> findByUser(Long userId) {
        return locationRepository.findByUser(userId);
    }

    @Override
    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    @Override
    public Location update(Long id, LocationDto locationInput) {
        Location locationInData = locationRepository.findById(id).orElseThrow(() -> new NotFoundException("Location " + id));
        locationInData.setStatus(locationInput.getStatus());
        return locationRepository.save(locationInData);
    }
}
