package com.motus.emotion.controller.admin;

import com.motus.emotion.model.Location;
import com.motus.emotion.model.api.ApiResponse;
import com.motus.emotion.service.LocationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/emotion/api/admin/locations")
@Validated
@Api("Api for locations crud operations")
public class RentalRestController {

    Logger LOGGER = LoggerFactory.getLogger(RentalRestController.class);

    @Autowired
    private LocationService locationService;

    @GetMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "get All the existing locations")
    public ApiResponse<List<Location>> getAll() {
        LOGGER.info("fetching for all locations");
        List<Location> locations = locationService.findAll();
        if (locations.isEmpty()) {
            return new ApiResponse<>(HttpStatus.NO_CONTENT.value(), "There is no locations ", locations);
        }
        return new ApiResponse<>(HttpStatus.OK.value(), "Locations fetched successfully ", locations);
    }

}
