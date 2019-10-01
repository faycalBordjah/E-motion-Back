package com.motus.emotion.repository.impl;

import com.motus.emotion.model.Vehicule;
import com.motus.emotion.repository.VehiculeRepository;

import java.util.ArrayList;
import java.util.List;

abstract class VehiculeRepositoryImpl implements VehiculeRepository {

    private VehiculeRepository vehiculeRepository;

    @Override
    public Vehicule findByType(String type) {
        List<Vehicule> vehiculeList = new ArrayList();
        vehiculeRepository.findAll().forEach((e -> vehiculeList.add(e)));
        for(Vehicule u : vehiculeList) {
            if( u.getType() == type ) return u;
        }
        return null;
    }

    @Override
    public Vehicule findBySerialNumber(int serialNumber) {
        List<Vehicule> vehiculeList = new ArrayList();
        vehiculeRepository.findAll().forEach((e -> vehiculeList.add(e)));
        for(Vehicule u : vehiculeList) {
            if( u.getSerialNumber() == serialNumber ) return u;
        }
        return null;
    }
}
