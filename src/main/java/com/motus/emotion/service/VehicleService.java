package com.motus.emotion.service;

import com.motus.emotion.model.Vehicle;

import java.util.List;

public interface VehicleService {

    Vehicle getById(Long id);

    Vehicle getByType(String type);

    Vehicle getBySerialNumber(int serialNumber);

    List<Vehicle> getAll();

    Vehicle save(Vehicle vehicle);

    void delete(Long id);

    void updateVehicule(Vehicle vehicle);

    boolean isVehiculeExist(Vehicle vehicle);
}
