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

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/emotion/api/vehicule")
@CrossOrigin(origins = "*")
public class VehicleController {


    private VehicleService vehicleService;

    Logger logger = LoggerFactory.getLogger(VehicleController.class);

    @Autowired
    public VehicleController(VehicleService vehicleService) { this.vehicleService = vehicleService; }
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public ApiResponse<List<Vehicle>> getAllVehicules() {
        logger.info("Fetching all Vehicules");
        List<Vehicle> vehicleList = new ArrayList<Vehicle>();
        vehicleList = vehicleService.getAll();
        if(vehicleList.isEmpty()){
            logger.error("Unable to fetch an empty list");
            return new ApiResponse<List<Vehicle>>(HttpStatus.OK.value(),"Unable to fetch an empty list.", vehicleService.getAll());
        }
        return new ApiResponse<List<Vehicle>>(HttpStatus.OK.value(),"User list fetched successfully.", vehicleService.getAll());
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public ApiResponse<Vehicle> getVehiculeById(@PathVariable final Long id) {
        logger.info("Fetching Vehicule with id {}", id);
        Vehicle vehicle = vehicleService.getById(id);
        if(vehicle == null) {
            logger.error("Vehicule with id {} not found.", id);
            return new ApiResponse<Vehicle>(HttpStatus.NOT_FOUND.value(),"Vehicule with id " + id
                    + " not found.", vehicleService.getById(id));

        }
        return new ApiResponse<Vehicle>(HttpStatus.OK.value(),"Vehicule with id " + id
                + "fetched successfully.", vehicleService.getById(id));

    }

    // ------------------- Create a Vehicule -------------------------------------------

    @PostMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public ApiResponse<Vehicle> create(@RequestBody Vehicle vehicle) {
        logger.info("Creating Vehicule : {}", vehicle);

        if(vehicleService.isVehiculeExist(vehicle)) {
            logger.error("Unable to create. A Vehicule with serialNumber {} already exist", vehicle.getSerialNumber());
            return new ApiResponse<Vehicle>(HttpStatus.CONFLICT.value(), "Unable to create. A Vehicule with serialNumber " +
                    vehicle.getSerialNumber() + " already exist.", vehicleService.save(vehicle));

        } else if( vehicle == null ) {
            return new ApiResponse<Vehicle>(HttpStatus.NOT_FOUND.value(), "Unable to create. Vehicule undefined.", vehicleService.save(vehicle));
        } else {
            vehicleService.save(vehicle);
            return new ApiResponse<Vehicle>(HttpStatus.OK.value(), "Vehicule saved successfully.", vehicleService.save(vehicle));

        }
    }

    // ------------------- Update a Vehicule ------------------------------------------------

    @PutMapping(value= "/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public ApiResponse<Vehicle> updateVehicule(@PathVariable final Long id, @RequestBody Vehicle vehicle) {
        logger.info("Updating Vehicule with id {}", id);
        Vehicle currentVehicle = vehicleService.getById(id);

        if(currentVehicle == null) {
            logger.error("Unable to update. Vehicule with id {} not found", id);
            return new ApiResponse<Vehicle>(HttpStatus.NOT_FOUND.value(), "Unable to update. Vehicule with id " + id + " not found.", vehicleService.getById(id));
        }

        BeanUtils.copyProperties(vehicle, currentVehicle);
        vehicleService.updateVehicule(currentVehicle);

        return new ApiResponse<Vehicle>(HttpStatus.OK.value(), "Vehicule updated successfully.", vehicleService.getById(id));
    }

    // ------------------- Delete a vehicule -----------------------------------------

    @DeleteMapping(value= "/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public ApiResponse<Vehicle> delete(@PathVariable final Long id) {
        logger.info("Fetching & Deleting Vehicule with id {}", id);
        Vehicle vehicle = vehicleService.getById(id);

        if(vehicle == null) {
            logger.error("Unable to delete. Vehicule with id {} not found.", id);
            return new ApiResponse<Vehicle>(HttpStatus.NOT_FOUND.value(), "Unable to delete. UsVehiculeer with id " + id + " not found.", vehicleService.getById(id));
        }
        vehicleService.delete(id);
        return new ApiResponse<Vehicle>(HttpStatus.NO_CONTENT.value(), "Vehicule delated successfully.", vehicleService.getById(id));

    }
}
