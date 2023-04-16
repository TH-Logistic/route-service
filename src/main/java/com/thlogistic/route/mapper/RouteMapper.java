package com.thlogistic.route.mapper;

import com.thlogistic.route.adapters.dtos.GetLocationResponse;
import com.thlogistic.route.adapters.dtos.GetRouteResponse;
import com.thlogistic.route.adapters.dtos.GetSimpleLocationResponse;
import com.thlogistic.route.core.entities.Location;
import com.thlogistic.route.entities.RouteEntity;

public class RouteMapper {
    public static GetRouteResponse fromRouteEntityAndLocationToResponse(RouteEntity entity, Location fromLocation, Location toLocation) {
        return new GetRouteResponse(
                entity.getId(),
                LocationMapper.fromLocationToSimpleResponse(fromLocation),
                LocationMapper.fromLocationToSimpleResponse(toLocation),
                entity.getLength(),
                entity.getTripBasedCost(),
                entity.getTonBasedLimit(),
                entity.getIsEnable()
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

    public static GetSimpleLocationResponse fromLocationToSimpleResponse(Location Location) {
        return new GetSimpleLocationResponse(
                Location.getId(),
                Location.getName(),
                Location.getAddress()
        );
    }
}
