package com.thlogistic.route.adapters.repositories;

import com.thlogistic.route.core.ports.LocationRepository;
import com.thlogistic.route.entities.LocationEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class LocationRepositoryImpl implements LocationRepository {
    private final MongoLocationRepository repository;


    @Override
    public String insert(LocationEntity Location) {
        return null;
    }

    @Override
    public String save(LocationEntity Location) {
        return null;
    }

    @Override
    public Optional<LocationEntity> findById(String id) {
        return Optional.empty();
    }

    @Override
    public BasePagingQueryResult<List<LocationEntity>> list(String keyword, Integer page, Integer size) {
        return null;
    }
}
