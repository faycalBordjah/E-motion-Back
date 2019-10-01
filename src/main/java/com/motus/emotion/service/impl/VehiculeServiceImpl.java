package com.motus.emotion.service.impl;

import com.motus.emotion.model.Vehicule;
import com.motus.emotion.repository.VehiculeRepository;
import com.motus.emotion.service.VehiculeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service(value="vehiculeService")
public class VehiculeServiceImpl implements VehiculeService {

    @Autowired
    private VehiculeRepository vehiculeRepository;

    @Autowired
    public VehiculeServiceImpl(VehiculeRepository vehiculeRepository) { this.vehiculeRepository = vehiculeRepository; }

    @Override
    public List<Vehicule> getAll() {
        List<Vehicule> vehiculeList = new ArrayList();
        vehiculeRepository.findAll().iterator().forEachRemaining(vehiculeList::add);
        return vehiculeList;
    }

    @Override
    public Vehicule getById(Long id) {
        Optional<Vehicule> optionalVehicule = vehiculeRepository.findById(id);
        return optionalVehicule.isPresent() ? optionalVehicule.get() : null;
    }

    @Override
    public Vehicule getByType(String type) {
        return vehiculeRepository.findByType(type);
    }

    @Override
    public Vehicule getBySerialNumber(int serialNumber) {
        return vehiculeRepository.findBySerialNumber(serialNumber);
    }

    @Override
    public Vehicule save(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public void delete(Long id) {
        vehiculeRepository.deleteById(id);
    }

    @Override
    public void updateVehicule(Vehicule vehicule) {
        Optional<Vehicule> vehiculeUpdated = vehiculeRepository.findById(vehicule.getId());
        if(vehiculeUpdated != null) {
            BeanUtils.copyProperties(vehicule, vehiculeUpdated);
        }
        vehiculeRepository.save(vehicule);
    }

    @Override
    public boolean isVehiculeExist(Vehicule vehicule) {
        return getBySerialNumber(vehicule.getSerialNumber()) != null;
    }
}
