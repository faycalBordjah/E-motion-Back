package com.motus.emotion.controller;

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

import java.util.List;

@RestController
@RequestMapping(value = "/emotion/api/vehicles")
public class VehicleController {


    private VehicleService vehicleService;

    Logger logger = LoggerFactory.getLogger(VehicleController.class);

    @Autowired
    public VehicleController(VehicleService vehicleService) { this.vehicleService = vehicleService; }
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public ApiResponse<List<Vehicle>> getAllVehicles() {
        logger.info("Fetching all Vehicles");
        List<Vehicle> vehicleList = vehicleService.getAll();
        if(vehicleList.isEmpty()){
            logger.error("Unable to fetch an empty list");
            return new ApiResponse<>(HttpStatus.NOT_FOUND.value(),"Unable to fetch an empty list.", vehicleService.getAll());
        }
        return new ApiResponse<>(HttpStatus.OK.value(),"User list fetched successfully.", vehicleService.getAll());
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public ApiResponse<Vehicle> getVehicleById(@PathVariable final Long id)  {
        logger.info("Fetching Vehicle with id {}", id);
        Vehicle vehicle = vehicleService.getById(id);
        if(vehicle == null) {
            logger.error("Vehicle with id {} not found.", id);
            return new ApiResponse<>(HttpStatus.NOT_FOUND.value(),"Vehicle with id " + id
                    + " not found.", vehicleService.getById(id));
        }
        return new ApiResponse<>(HttpStatus.OK.value(),"Vehicle with id " + id
                + "fetched successfully.", vehicleService.getById(id));

    }

    @PostMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public ApiResponse<Vehicle> create(@RequestBody Vehicle vehicle) {
        logger.info("Creating Vehicle : {}", vehicle);
        if(vehicleService.isVehicleExist(vehicle)) {
            logger.error("Unable to create. A Vehicle with serialNumber {} already exist", vehicle.getSerialNumber());
            return new ApiResponse<Vehicle>(HttpStatus.CONFLICT.value(), "Unable to create. A Vehicle with serialNumber " +
                    vehicle.getSerialNumber() + " already exist.", vehicleService.save(vehicle));

        } else if( vehicle == null ) {
            return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Unable to create. Vehicle undefined.", vehicleService.save(vehicle));
        } else {
            vehicleService.save(vehicle);
            return new ApiResponse<>(HttpStatus.OK.value(), "Vehicle saved successfully.", vehicleService.save(vehicle));

        }
    }

    @PutMapping(value= "/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public ApiResponse<Vehicle> updateVehicle(@PathVariable final Long id, @RequestBody Vehicle vehicle) {
        logger.info("Updating Vehicle with id {}", id);
        Vehicle currentVehicle = vehicleService.getById(id);

        if(currentVehicle == null) {
            logger.error("Unable to update. Vehicle with id {} not found", id);
            return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Unable to update. Vehicle with id " + id + " not found.", vehicleService.getById(id));
        }

        BeanUtils.copyProperties(vehicle, currentVehicle);
        vehicleService.updateVehicle(currentVehicle);

        return new ApiResponse<>(HttpStatus.OK.value(), "Vehicle updated successfully.", vehicleService.getById(id));
    }

    @DeleteMapping(value= "/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public ApiResponse<Vehicle> delete(@PathVariable final Long id) {
        logger.info("Fetching & Deleting Vehicle with id {}", id);
        Vehicle vehicle = vehicleService.getById(id);

        if(vehicle == null) {
            logger.error("Unable to delete. Vehicle with id {} not found.", id);
            return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Unable to delete. UsVehicleer with id " + id + " not found.", vehicleService.getById(id));
        }
        vehicleService.delete(id);
        return new ApiResponse<>(HttpStatus.NO_CONTENT.value(), "Vehicle deleted successfully.", vehicleService.getById(id));

    }
}
