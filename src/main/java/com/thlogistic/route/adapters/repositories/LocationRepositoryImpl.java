package com.thlogistic.route.adapters.repositories;

import com.thlogistic.route.core.ports.LocationRepository;
import com.thlogistic.route.entities.LocationEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class LocationRepositoryImpl implements LocationRepository {
    private final MongoLocationRepository repository;

    @Override
    public String insert(LocationEntity Location) {
        return repository.insert(Location).getId();
    }

    @Override
    public String save(LocationEntity Location) {
        return repository.save(Location).getId();
    }

    @Override
    public Optional<LocationEntity> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public BasePagingQueryResult<List<LocationEntity>> list(String keyword, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<LocationEntity> Locations;
        if (keyword == null || keyword.isEmpty()) {
            Locations = repository.findAll(pageable);
        } else {
            Locations = repository.findByNameContainingIgnoreCaseOrAddressContainingIgnoreCase(keyword, keyword, pageable);
        }

        BasePagingQueryResult<List<LocationEntity>> result = new BasePagingQueryResult<>();
        result.data = Locations.getContent();
        result.total = Locations.getTotalElements();
        result.totalPage = Locations.getTotalPages();
        return result;
    }
}
