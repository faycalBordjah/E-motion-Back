package com.motus.emotion.service.impl;

import com.motus.emotion.model.Vehicle;
import com.motus.emotion.repository.VehiculeRepository;
import com.motus.emotion.service.VehicleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service(value="vehiculeService")
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehiculeRepository vehiculeRepository;

    @Autowired
    public VehicleServiceImpl(VehiculeRepository vehiculeRepository) { this.vehiculeRepository = vehiculeRepository; }

    @Override
    public List<Vehicle> getAll() {
        List<Vehicle> vehicleList = new ArrayList();
        vehiculeRepository.findAll().iterator().forEachRemaining(vehicleList::add);
        return vehicleList;
    }

    @Override
    public Vehicle getById(Long id) {
        Optional<Vehicle> optionalVehicule = vehiculeRepository.findById(id);
        return optionalVehicule.isPresent() ? optionalVehicule.get() : null;
    }

    @Override
    public Vehicle getByType(String type) {
        return vehiculeRepository.findByType(type);
    }

    @Override
    public Vehicle getBySerialNumber(int serialNumber) {
        return vehiculeRepository.findBySerialNumber(serialNumber);
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        return vehiculeRepository.save(vehicle);
    }

    @Override
    public void delete(Long id) {
        vehiculeRepository.deleteById(id);
    }

    @Override
    public void updateVehicule(Vehicle vehicle) {
        Optional<Vehicle> vehiculeUpdated = vehiculeRepository.findById(vehicle.getId());
        if(vehiculeUpdated != null) {
            BeanUtils.copyProperties(vehicle, vehiculeUpdated);
        }
        vehiculeRepository.save(vehicle);
    }

    @Override
    public boolean isVehiculeExist(Vehicle vehicle) {
        return getBySerialNumber(vehicle.getSerialNumber()) != null;
    }
}
