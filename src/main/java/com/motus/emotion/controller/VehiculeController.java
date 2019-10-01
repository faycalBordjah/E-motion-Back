package com.motus.emotion.controller;

import com.motus.emotion.model.Vehicule;
import com.motus.emotion.model.api.ApiResponse;
import com.motus.emotion.service.VehiculeService;
import com.motus.emotion.service.impl.VehiculeServiceImpl;
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
@CrossOrigin(origins = "*") // http://localhost:4200
public class VehiculeController {


    private VehiculeService vehiculeService;

    Logger logger = LoggerFactory.getLogger(VehiculeController.class);

    @Autowired
    public VehiculeController(VehiculeService vehiculeService) { this.vehiculeService = vehiculeService; }

    // ------------------- Retrieve All Vehicules ---------------------------------------------

    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public ApiResponse<List<Vehicule>> getAllVehicules() {
        logger.info("Fetching all Vehicules");
        List<Vehicule> vehiculeList = new ArrayList<Vehicule>();
        vehiculeList = vehiculeService.getAll();
        if(vehiculeList.isEmpty()){
            logger.error("Unable to fetch an empty list");
            return new ApiResponse<List<Vehicule>>(HttpStatus.OK.value(),"Unable to fetch an empty list.",vehiculeService.getAll());
        }
        return new ApiResponse<List<Vehicule>>(HttpStatus.OK.value(),"User list fetched successfully.",vehiculeService.getAll());
    }

    // ------------------- Retrieve Single Vehicule ------------------------------------------

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public ApiResponse<Vehicule> getVehiculeById(@PathVariable final Long id) {
        logger.info("Fetching Vehicule with id {}", id);
        Vehicule vehicule = vehiculeService.getById(id);
        if(vehicule == null) {
            logger.error("Vehicule with id {} not found.", id);
            return new ApiResponse<Vehicule>(HttpStatus.NOT_FOUND.value(),"Vehicule with id " + id
                    + " not found.",vehiculeService.getById(id));

        }
        return new ApiResponse<Vehicule>(HttpStatus.OK.value(),"Vehicule with id " + id
                + "fetched successfully.",vehiculeService.getById(id));

    }

    // ------------------- Create a Vehicule -------------------------------------------

    @PostMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public ApiResponse<Vehicule> create(@RequestBody Vehicule vehicule) {
        logger.info("Creating Vehicule : {}", vehicule);

        if(vehiculeService.isVehiculeExist(vehicule)) {
            logger.error("Unable to create. A Vehicule with serialNumber {} already exist",vehicule.getSerialNumber());
            return new ApiResponse<Vehicule>(HttpStatus.CONFLICT.value(), "Unable to create. A Vehicule with serialNumber " +
                    vehicule.getSerialNumber() + " already exist.",vehiculeService.save(vehicule));

        } else if( vehicule == null ) {
            return new ApiResponse<Vehicule>(HttpStatus.NOT_FOUND.value(), "Unable to create. Vehicule undefined.",vehiculeService.save(vehicule));
        } else {
            vehiculeService.save(vehicule);
            return new ApiResponse<Vehicule>(HttpStatus.OK.value(), "Vehicule saved successfully.",vehiculeService.save(vehicule));

        }
    }

    // ------------------- Update a Vehicule ------------------------------------------------

    @PutMapping(value= "/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public ApiResponse<Vehicule> updateVehicule(@PathVariable final Long id, @RequestBody Vehicule vehicule) {
        logger.info("Updating Vehicule with id {}", id);
        Vehicule currentVehicule = vehiculeService.getById(id);

        if(currentVehicule == null) {
            logger.error("Unable to update. Vehicule with id {} not found", id);
            return new ApiResponse<Vehicule>(HttpStatus.NOT_FOUND.value(), "Unable to update. Vehicule with id " + id + " not found.",vehiculeService.getById(id));
        }

        BeanUtils.copyProperties(vehicule, currentVehicule);
        vehiculeService.updateVehicule(currentVehicule);

        return new ApiResponse<Vehicule>(HttpStatus.OK.value(), "Vehicule updated successfully.",vehiculeService.getById(id));
    }

    // ------------------- Delete a vehicule -----------------------------------------

    @DeleteMapping(value= "/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public ApiResponse<Vehicule> delete(@PathVariable final Long id) {
        logger.info("Fetching & Deleting Vehicule with id {}", id);
        Vehicule vehicule = vehiculeService.getById(id);

        if(vehicule == null) {
            logger.error("Unable to delete. Vehicule with id {} not found.", id);
            return new ApiResponse<Vehicule>(HttpStatus.NOT_FOUND.value(), "Unable to delete. UsVehiculeer with id " + id + " not found.",vehiculeService.getById(id));
        }
        vehiculeService.delete(id);
        return new ApiResponse<Vehicule>(HttpStatus.NO_CONTENT.value(), "Vehicule delated successfully.",vehiculeService.getById(id));

    }
}
