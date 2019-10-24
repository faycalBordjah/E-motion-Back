package com.motus.emotion.controller;

import com.motus.emotion.model.Vehicle;
import com.motus.emotion.model.api.ApiResponse;
import com.motus.emotion.service.VehicleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/emotion/api/vehicles")
@Api(description = "vehicle api for anonymous")
public class VehicleController {


    private VehicleService vehicleService;

    private final static Logger logger = LoggerFactory.getLogger(VehicleController.class);

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    @ApiOperation(value = "get all vehicle for anonymous")
    public ApiResponse<List<Vehicle>> getAllVehicles() {
        logger.info("Fetching all Vehicles");
        List<Vehicle> vehicleList = vehicleService.getAll();
        if (vehicleList.isEmpty()) {
            logger.error("Unable to fetch an empty list");
            return new ApiResponse<>(HttpStatus.NO_CONTENT.value(), "No vehicles on the DB.", vehicleService.getAll());
        }
        return new ApiResponse<>(HttpStatus.OK.value(), "User list fetched successfully.", vehicleService.getAll());
    }

    @GetMapping(value = "/{type}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    @ApiOperation(value = "get a vehicle by it id")
    public ApiResponse<List<Vehicle>> findByType(@PathVariable @ApiParam("The vehicle type: 'SCOOTER','CAR'") String type) {
        return new ApiResponse<>(HttpStatus.OK.value(), "Vehicles fetched with success", vehicleService.getByType(type));
    }

    @GetMapping(value = "/dispo/{available}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    @ApiOperation(value = "get a vehicle by it id")
    public ApiResponse<List<Vehicle>> findAvailable(@PathVariable @ApiParam("available true or false") boolean available) {
        return new ApiResponse<>(HttpStatus.OK.value(), "Vehicles fetched with success", vehicleService.getAvailable(available));
    }


}
