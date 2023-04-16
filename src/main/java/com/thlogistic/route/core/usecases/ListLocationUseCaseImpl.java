package com.thlogistic.route.core.usecases;

import com.thlogistic.route.core.entities.Location;
import com.thlogistic.route.core.ports.LocationRepository;
import com.thlogistic.route.entities.LocationEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListLocationUseCaseImpl implements ListLocationUseCase {

    private final LocationRepository locationRepository;

    @Override
    public List<Location> execute(String keyword) {
        List<LocationEntity> entities = locationRepository.findByKeyword(keyword);
        return entities.stream().map(LocationEntity::toLocation).toList();
    }
}
