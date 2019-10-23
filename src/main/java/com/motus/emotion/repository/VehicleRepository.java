package com.motus.emotion.repository;

import com.motus.emotion.model.Vehicle;
import com.motus.emotion.model.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    List<Vehicle> findByType(@NotNull(message = "type must be set ") VehicleType type);

    List<Vehicle> findVehicleByAvailable (boolean available);

    Vehicle findBySerialNumber(int serialNumber);
}
