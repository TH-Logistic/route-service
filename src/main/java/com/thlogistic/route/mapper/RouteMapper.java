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
                LocationMapper.fromLocationToResponse(fromLocation),
                LocationMapper.fromLocationToResponse(toLocation),
                entity.getLength(),
                entity.getTripBasedCost(),
                entity.getTonBasedLimit(),
                entity.getIsEnable()
        );
    }
}
