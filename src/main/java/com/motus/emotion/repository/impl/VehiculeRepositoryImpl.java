package com.motus.emotion.repository.impl;

import com.motus.emotion.model.Vehicle;
import com.motus.emotion.repository.VehiculeRepository;

import java.util.ArrayList;
import java.util.List;

abstract class VehiculeRepositoryImpl implements VehiculeRepository {

    private VehiculeRepository vehiculeRepository;

    @Override
    public Vehicle findByType(String type) {
        List<Vehicle> vehicleList = new ArrayList();
        vehiculeRepository.findAll().forEach((e -> vehicleList.add(e)));
        for(Vehicle u : vehicleList) {
            if( u.getType() == type ) return u;
        }
        return null;
    }

    @Override
    public Vehicle findBySerialNumber(int serialNumber) {
        List<Vehicle> vehicleList = new ArrayList();
        vehiculeRepository.findAll().forEach((e -> vehicleList.add(e)));
        for(Vehicle u : vehicleList) {
            if( u.getSerialNumber() == serialNumber ) return u;
        }
        return null;
    }
}
