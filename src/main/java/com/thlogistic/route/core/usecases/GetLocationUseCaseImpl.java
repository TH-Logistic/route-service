package com.thlogistic.route.core.usecases;

import com.thlogistic.route.aop.exception.DataNotFoundException;
import com.thlogistic.route.core.entities.Location;
import com.thlogistic.route.core.ports.LocationRepository;
import com.thlogistic.route.entities.LocationEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetLocationUseCaseImpl implements GetLocationUseCase {

    private final LocationRepository locationRepository;

    @Override
    public Location execute(String id) {
        Optional<LocationEntity> entity = locationRepository.findById(id);
        if (entity.isEmpty()) {
            throw new DataNotFoundException(Location.class.getSimpleName());
        }
        return entity.get().toLocation();
    }
}
