package com.thlogistic.route.core.usecases;

import com.thlogistic.route.adapters.dtos.CreateLocationRequest;
import com.thlogistic.route.adapters.dtos.CreateLocationResponse;
import com.thlogistic.route.core.ports.LocationRepository;
import com.thlogistic.route.entities.LocationEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateLocationUseCaseImpl implements CreateLocationUseCase {

    private final LocationRepository repository;

    @Override
    public CreateLocationResponse execute(CreateLocationRequest request) {
        LocationEntity entity = new LocationEntity(
                request.getName(),
                request.getAddress(),
                request.getLatitude(),
                request.getLongitude());
        String id = repository.insert(entity);
        return new CreateLocationResponse(id);
    }
}
