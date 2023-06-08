package com.thlogistic.route.core.usecases;

import com.thlogistic.route.adapters.dtos.CreateRouteRequest;
import com.thlogistic.route.adapters.dtos.CreateRouteResponse;
import com.thlogistic.route.aop.exception.BadRequestException;
import com.thlogistic.route.aop.exception.CustomRuntimeException;
import com.thlogistic.route.aop.exception.DataNotFoundException;
import com.thlogistic.route.client.google_map.DistanceMatrixDto;
import com.thlogistic.route.client.google_map.GoogleMapClient;
import com.thlogistic.route.config.ClientConfig;
import com.thlogistic.route.core.entities.Location;
import com.thlogistic.route.core.ports.LocationRepository;
import com.thlogistic.route.core.ports.RouteRepository;
import com.thlogistic.route.entities.LocationEntity;
import com.thlogistic.route.entities.RouteEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateRouteUseCaseImpl implements CreateRouteUseCase {

    private final RouteRepository repository;
    private final LocationRepository locationRepository;
    private final GoogleMapClient googleMapClient;

    @Override
    public CreateRouteResponse execute(CreateRouteRequest request) {
        String fromId = request.getStartLocationId();
        String toId = request.getEndLocationId();

        // Locations cannot be the same
        if (fromId.equals(toId)) {
            throw new BadRequestException("Locations cannot be the same");
        }

        // Location cannot be empty
        LocationEntity fromLocation = locationRepository.findById(fromId).orElse(null);
        LocationEntity toLocation = locationRepository.findById(toId).orElse(null);
        if (fromLocation == null || toLocation == null) {
            throw new DataNotFoundException(Location.class.getSimpleName());
        }

        // Calculate length
        DistanceMatrixDto distanceMatrix;
        try {
            String origins = String.join(
                    ",",
                    fromLocation.getLatitude().toString(),
                    fromLocation.getLongitude().toString()
            );
            String destinations = String.join(
                    ",",
                    toLocation.getLatitude().toString(),
                    toLocation.getLongitude().toString()
            );
            distanceMatrix = googleMapClient.getDistanceBetweenTwoLocation(origins, destinations, ClientConfig.GOOGLE_MAP_API_KEY);
        } catch (Exception e) {
            throw new CustomRuntimeException("An error occurred when calculating distance");
        }

        RouteEntity entity = new RouteEntity(
                request.getStartLocationId(),
                request.getEndLocationId(),
                distanceMatrix.getDistance(),
                request.getTripBasedCost(),
                request.getTonBasedLimit(),
                true
        );
        String id = repository.insert(entity);
        return new CreateRouteResponse(id);
    }
}
