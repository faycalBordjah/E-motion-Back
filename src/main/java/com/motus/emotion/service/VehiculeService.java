package com.motus.emotion.service;

import com.motus.emotion.model.Vehicule;

import java.util.List;

public interface VehiculeService {

    Vehicule getById(Long id);

    Vehicule getByType(String type);

    Vehicule getBySerialNumber(int serialNumber);

    List<Vehicule> getAll();

    Vehicule save(Vehicule vehicule);

    void delete(Long id);

    void updateVehicule(Vehicule vehicule);

    boolean isVehiculeExist(Vehicule vehicule);
}
