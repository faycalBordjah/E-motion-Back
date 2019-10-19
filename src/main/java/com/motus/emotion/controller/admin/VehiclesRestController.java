package com.motus.emotion.controller.admin;

import com.motus.emotion.model.Vehicle;
import com.motus.emotion.model.api.ApiResponse;
import com.motus.emotion.service.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController("emotion/api/admin/vehicles")
public class VehiclesRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(VehiclesRestController.class);

    @Autowired
    private VehicleService vehicleService;


    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ApiResponse<Vehicle> getVehicleById(@PathVariable final Long id) {
        LOGGER.info("Fetching Vehicle with id {}", id);
        Vehicle vehicle = vehicleService.getById(id);
        if (vehicle == null) {
            LOGGER.error("Vehicle with id {} not found.", id);
            return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Vehicle with id " + id
                    + " not found.", vehicleService.getById(id));
        }
        return new ApiResponse<>(HttpStatus.OK.value(), "Vehicle with id " + id
                + "fetched successfully.", vehicleService.getById(id));

    }

    @PostMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ApiResponse<Vehicle> create(@RequestBody Vehicle vehicle) {
        LOGGER.info("Creating Vehicle : {}", vehicle);
        if (vehicleService.isVehicleExist(vehicle)) {
            LOGGER.error("Unable to create. A Vehicle with serialNumber {} already exist", vehicle.getSerialNumber());
            return new ApiResponse<Vehicle>(HttpStatus.CONFLICT.value(), "Unable to create. A Vehicle with serialNumber " +
                    vehicle.getSerialNumber() + " already exist.", vehicleService.save(vehicle));

        } else if (vehicle == null) {
            return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Unable to create. Vehicle undefined.", vehicleService.save(vehicle));
        } else {
            vehicleService.save(vehicle);
            return new ApiResponse<>(HttpStatus.OK.value(), "Vehicle saved successfully.", vehicleService.save(vehicle));

        }
    }

    @PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ApiResponse<Vehicle> updateVehicle(@PathVariable final Long id, @RequestBody Vehicle vehicle) {
        LOGGER.info("Updating Vehicle with id {}", id);
        Vehicle currentVehicle = vehicleService.getById(id);

        if (currentVehicle == null) {
            LOGGER.error("Unable to update. Vehicle with id {} not found", id);
            return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Unable to update. Vehicle with id " + id + " not found.", vehicleService.getById(id));
        }

        BeanUtils.copyProperties(vehicle, currentVehicle);
        vehicleService.updateVehicle(currentVehicle);

        return new ApiResponse<>(HttpStatus.OK.value(), "Vehicle updated successfully.", vehicleService.getById(id));
    }

    @DeleteMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ApiResponse<Vehicle> delete(@PathVariable final Long id) {
        LOGGER.info("Fetching & Deleting Vehicle with id {}", id);
        Vehicle vehicle = vehicleService.getById(id);

        if (vehicle == null) {
            LOGGER.error("Unable to delete. Vehicle with id {} not found.", id);
            return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Unable to delete. UsVehicleer with id " + id + " not found.", vehicleService.getById(id));
        }
        vehicleService.delete(id);
        return new ApiResponse<>(HttpStatus.NO_CONTENT.value(), "Vehicle deleted successfully.", vehicleService.getById(id));

    }
}