package com.motus.emotion.controller.user;

import com.motus.emotion.model.Location;
import com.motus.emotion.model.User;
import com.motus.emotion.model.api.ApiResponse;
import com.motus.emotion.service.LocationService;
import com.motus.emotion.service.UserService;
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

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping(value = "/emotion/api/user/locations")
@Validated
@Api("Api for simple user locations")
public class LocationRestController {

    private final static Logger logger = LoggerFactory.getLogger(LocationRestController.class);

    private LocationService locationService;

    private UserService userService;

    @Autowired
    public LocationRestController(LocationService locationService, UserService userService) {
        this.locationService = locationService;
        this.userService = userService;
    }

    @PostMapping(value = "/{userId}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE
            })
    @ResponseBody
    @ApiOperation(value = "register a user")
    public ApiResponse<Location> create(@PathVariable @NotNull @ApiParam Long userId,
                                        @RequestBody @Valid Location location) {
        logger.info("fetching the actor of location");
        User user = userService.getById(userId);
        location.setUser(user);
        return new ApiResponse<>(HttpStatus.OK.value(),
                "Location created successfully",
                locationService.create(location));
    }

    @GetMapping(value = "/{userId}", consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE
            })
    @ResponseBody
    public ApiResponse<List<Location>> getLocationByUser(@PathVariable @NotNull @ApiParam Long userId
    ) {
        logger.info("fetch a location by his user actor");
        return new ApiResponse<>(HttpStatus.OK.value(),
                "Locations fetched successfully",
                locationService.findByUser(userId));
    }
}
