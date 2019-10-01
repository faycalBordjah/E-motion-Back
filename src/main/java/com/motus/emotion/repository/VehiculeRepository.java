package com.motus.emotion.repository;

import com.motus.emotion.model.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {

    Vehicule findByType(String type);

    Vehicule findBySerialNumber(int serialNumber);
}
