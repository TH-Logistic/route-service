package com.thlogistic.route.core.usecases;

import com.thlogistic.route.adapters.dtos.GetRouteResponse;
import com.thlogistic.route.aop.exception.DataNotFoundException;
import com.thlogistic.route.core.entities.Location;
import com.thlogistic.route.core.entities.Route;
import com.thlogistic.route.core.ports.LocationRepository;
import com.thlogistic.route.core.ports.RouteRepository;
import com.thlogistic.route.entities.LocationEntity;
import com.thlogistic.route.entities.RouteEntity;
import com.thlogistic.route.mapper.RouteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetRouteUseCaseImpl implements GetRouteUseCase {

    private final RouteRepository repository;
    private final GetLocationUseCase getLocationUseCase;

    @Override
    public GetRouteResponse execute(String id) {
        Optional<RouteEntity> entity = repository.findById(id);
        if (entity.isEmpty()) {
            throw new DataNotFoundException(Route.class.getSimpleName());
        }

        String startLocationId = entity.get().getStartLocationId();
        String endLocationId = entity.get().getEndLocationId();

        Location startLocation = getLocationUseCase.execute(startLocationId);
        Location endLocation = getLocationUseCase.execute(endLocationId);

        return RouteMapper.fromRouteEntityAndLocationToResponse(
                entity.get(),
                startLocation,
                endLocation
        );
    }
}
