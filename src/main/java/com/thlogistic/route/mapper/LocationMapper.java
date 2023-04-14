package com.thlogistic.route.mapper;

import com.thlogistic.route.adapters.dtos.GetLocationResponse;
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

    public static GetLocationResponse fromLocationToResponse(Location Location) {
        return new GetLocationResponse(
                Location.getId(),
                Location.getName(),
                Location.getAddress(),
                Location.getLatitude(),
                Location.getLongitude()
        );
    }
}
