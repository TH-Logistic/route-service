package com.thlogistic.route.core.usecases;

import com.thlogistic.route.adapters.dtos.CreateRouteRequest;
import com.thlogistic.route.adapters.dtos.CreateRouteResponse;
import com.thlogistic.route.aop.exception.BadRequestException;
import com.thlogistic.route.aop.exception.DataNotFoundException;
import com.thlogistic.route.core.entities.Location;
import com.thlogistic.route.core.ports.LocationRepository;
import com.thlogistic.route.core.ports.RouteRepository;
import com.thlogistic.route.entities.RouteEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateRouteUseCaseImpl implements CreateRouteUseCase {

    private final RouteRepository repository;
    private final LocationRepository locationRepository;

    @Override
    public CreateRouteResponse execute(CreateRouteRequest request) {
        String fromId = request.getStartLocationId();
        String toId = request.getEndLocationId();

        // Locations cannot be the same
        if (fromId.equals(toId)) {
            throw new BadRequestException("Locations cannot be the same");
        }

        // Location cannot be empty
        if (locationRepository.findById(fromId).isEmpty() || locationRepository.findById(toId).isEmpty()) {
            throw new DataNotFoundException(Location.class.getSimpleName());
        }
        RouteEntity entity = new RouteEntity(
                request.getStartLocationId(),
                request.getEndLocationId(),
                request.getLength(),
                request.getTripBasedCost(),
                request.getTonBasedLimit(),
                true
        );
        String id = repository.insert(entity);
        return new CreateRouteResponse(id);
    }
}
