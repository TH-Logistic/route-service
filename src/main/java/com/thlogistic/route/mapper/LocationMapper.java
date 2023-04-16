package com.thlogistic.route.mapper;

import com.thlogistic.route.adapters.dtos.GetLocationResponse;
import com.thlogistic.route.adapters.dtos.GetSimpleLocationResponse;
import com.thlogistic.route.core.entities.Location;
import com.thlogistic.route.entities.LocationEntity;

public class LocationMapper {
    public static GetLocationResponse fromLocationEntityToResponse(LocationEntity entity) {
        return new GetLocationResponse(
                entity.getId(),
                entity.getName(),
                entity.getAddress(),
                entity.getLatitude(),
                entity.getLongitude()
        );
    }

    public static GetLocationResponse fromLocationToResponse(Location location) {
        return new GetLocationResponse(
                location.getId(),
                location.getName(),
                location.getAddress(),
                location.getLatitude(),
                location.getLongitude()
        );
    }

    public static GetSimpleLocationResponse fromLocationToSimpleResponse(Location location) {
        return new GetSimpleLocationResponse(
                location.getId(),
                location.getName(),
                location.getAddress()
        );
    }
}
