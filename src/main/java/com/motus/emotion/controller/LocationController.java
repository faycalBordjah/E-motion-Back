package com.motus.emotion.controller;

import com.motus.emotion.model.Location;
import com.motus.emotion.model.User;
import com.motus.emotion.model.api.ApiResponse;
import com.motus.emotion.service.LocationService;
import com.motus.emotion.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping(value = "/emotion/api/location/{userId}")
@Validated
public class LocationController {

    Logger logger = LoggerFactory.getLogger(LocationController.class);

    private LocationService locationService;

    private UserService userService;

    @Autowired
    public LocationController(LocationService locationService, UserService userService) {
        this.locationService = locationService;
        this.userService = userService;
    }

    @PostMapping(value = "",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE
            })
    @ResponseBody
    public ApiResponse<Location> create(@PathVariable @NotNull Long userId,
                                        @RequestBody @Valid Location location) {
        logger.info("fetching the actor of location");
        User user = userService.getById(userId);
        location.setUser(user);
        return new ApiResponse<>(HttpStatus.OK.value(),
                "Location created successfully",
                locationService.create(location));
    }

    @GetMapping(value = "", consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE
            })
    @ResponseBody
    public ApiResponse<List<Location>> getLocationByUser(@PathVariable @NotNull Long userId
    ) {
        return new ApiResponse<>(HttpStatus.OK.value(),
                "Locations fetched successfully",
                locationService.findByUser(userId));
    }
}
