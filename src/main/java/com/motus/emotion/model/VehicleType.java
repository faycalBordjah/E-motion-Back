package com.motus.emotion.model;

import com.motus.emotion.exception.NotFoundException;

/**
 * Available type of vehicles
 */
public enum VehicleType {
    SCOOTER("scooter"),
    CAR("car");
    private String type;

    private VehicleType(String type) {
        this.type = type;
    }

    public static VehicleType getType(String value) {
        for (VehicleType re : VehicleType.values()) {
            if (re.type.compareTo(value) == 0) {
                return re;
            }
        }
        throw new NotFoundException("Invalid Vehicle Type value: " + value);
    }
}
