package com.thlogistic.route.core.usecases;

import com.thlogistic.route.adapters.dtos.UpdateLocationRequest;
import com.thlogistic.route.aop.exception.DataNotFoundException;
import com.thlogistic.route.core.entities.Location;
import com.thlogistic.route.core.ports.LocationRepository;
import com.thlogistic.route.entities.LocationEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdateLocationUseCaseImpl implements UpdateLocationUseCase {

    private final LocationRepository repository;

    @Override
    public Object execute(Pair<String, UpdateLocationRequest> requestPair) {
        Optional<LocationEntity> entity = repository.findById(requestPair.getFirst());
        if (entity.isEmpty()) {
            throw new DataNotFoundException(Location.class.getSimpleName());
        }
        UpdateLocationRequest request = requestPair.getSecond();
        LocationEntity result = entity.get();
        result.setName(request.getName());
        result.setAddress(request.getAddress());
        result.setLatitude(request.getLatitude());
        result.setLongitude(request.getLongitude());
        repository.save(result);
        return null;
    }
}
