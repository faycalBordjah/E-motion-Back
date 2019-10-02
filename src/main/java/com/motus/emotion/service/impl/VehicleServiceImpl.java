package com.motus.emotion.service.impl;

import com.motus.emotion.model.Vehicle;
import com.motus.emotion.repository.VehicleRepository;
import com.motus.emotion.service.VehicleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service(value = "vehicleService")
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<Vehicle> getAll() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle getById(Long id){
        return vehicleRepository.findById(id).orElse(null);
    }

    @Override
    public Vehicle getByType(String type) {
        return vehicleRepository.findByType(type);
    }

    @Override
    public Vehicle getBySerialNumber(int serialNumber) {
        return vehicleRepository.findBySerialNumber(serialNumber);
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public void delete(Long id) {
        vehicleRepository.deleteById(id);
    }

    @Override
    public void updateVehicle(Vehicle vehicle) {
        Optional<Vehicle> vehicleUpdated = vehicleRepository.findById(vehicle.getId());
        if (vehicleUpdated.isPresent()) {
            BeanUtils.copyProperties(vehicle, vehicleUpdated);
        }
        vehicleRepository.save(vehicle);
    }

    @Override
    public boolean isVehicleExist(Vehicle vehicle) {
        return getBySerialNumber(vehicle.getSerialNumber()) != null;
    }
}
