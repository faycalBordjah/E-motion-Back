package com.motus.emotion.dto;

import com.motus.emotion.model.LocationStatus;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

public class LocationDto {

    private Long id;

    @NotNull
    private LocationStatus status;

    public LocationDto(Long id, LocationStatus status) {
        this.id = id;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocationStatus getStatus() {
        return status;
    }

    public void setStatus(LocationStatus status) {
        this.status = status;
    }
}
