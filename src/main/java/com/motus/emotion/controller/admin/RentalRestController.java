package com.motus.emotion.controller.admin;

import com.motus.emotion.dto.LocationDto;
import com.motus.emotion.model.Location;
import com.motus.emotion.model.api.ApiResponse;
import com.motus.emotion.service.LocationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/emotion/api/admin/locations")
@Validated
@Api("Api for locations crud operations")
public class RentalRestController {

    private final static Logger LOGGER = LoggerFactory.getLogger(RentalRestController.class);

    private LocationService locationService;

    @Autowired
    public RentalRestController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "get All the existing locations")
    public ApiResponse<List<Location>> getAll() {
        LOGGER.info("fetching for all locations");
        List<Location> locations = locationService.findAll();
        if (locations.isEmpty()) {
            return new ApiResponse<>(HttpStatus.NO_CONTENT.value(), "There is no locations ", locations);
        }
        return new ApiResponse<>(HttpStatus.OK.value(), "Locations fetched successfully ", locations);
    }

    @PutMapping(value = "/{locationId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "update the status of a location")
    public ApiResponse<Location> updateStatus(@PathVariable @ApiParam Long locationId,
                                              @RequestBody @ApiParam("The location dto that contains the new infos") LocationDto locationDto) {
        return new ApiResponse<>(HttpStatus.OK.value(), "Location status changed with success ", locationService.update(locationId, locationDto));
    }

}
