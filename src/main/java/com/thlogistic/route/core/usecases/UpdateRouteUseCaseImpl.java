package com.thlogistic.route.core.usecases;

import com.thlogistic.route.adapters.dtos.UpdateRouteRequest;
import com.thlogistic.route.aop.exception.DataNotFoundException;
import com.thlogistic.route.core.entities.Location;
import com.thlogistic.route.core.entities.Route;
import com.thlogistic.route.core.ports.LocationRepository;
import com.thlogistic.route.core.ports.RouteRepository;
import com.thlogistic.route.entities.RouteEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdateRouteUseCaseImpl implements UpdateRouteUseCase {

    private final RouteRepository repository;
    private final LocationRepository locationRepository;

    @Override
    public Object execute(Pair<String, UpdateRouteRequest> requestPair) {
        Optional<RouteEntity> entity = repository.findById(requestPair.getFirst());
        if (entity.isEmpty()) {
            throw new DataNotFoundException(Route.class.getSimpleName());
        }

        String fromId = requestPair.getSecond().getStartLocationId();
        String toId = requestPair.getSecond().getEndLocationId();
        if (locationRepository.findById(fromId).isEmpty() || locationRepository.findById(toId).isEmpty()) {
            throw new DataNotFoundException(Location.class.getSimpleName());
        }

        UpdateRouteRequest request = requestPair.getSecond();
        RouteEntity result = entity.get();
        result.setStartLocationId(request.getStartLocationId());
        result.setEndLocationId(request.getEndLocationId());
        result.setLength(request.getLength());
        result.setTripBasedCost(request.getTripBasedCost());
        result.setTonBasedLimit(request.getTonBasedLimit());
        result.setIsEnable(request.getIsEnable());
        repository.save(result);
        return null;
    }
}
