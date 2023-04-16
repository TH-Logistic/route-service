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
    public String insert(LocationEntity location) {
        return repository.insert(location).getId();
    }

    @Override
    public String save(LocationEntity location) {
        return repository.save(location).getId();
    }

    @Override
    public Optional<LocationEntity> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public BasePagingQueryResult<List<LocationEntity>> paging(String keyword, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<LocationEntity> locations;
        if (keyword == null || keyword.isEmpty()) {
            locations = repository.findAll(pageable);
        } else {
            locations = repository.findByNameContainingIgnoreCaseOrAddressContainingIgnoreCase(keyword, keyword, pageable);
        }

        BasePagingQueryResult<List<LocationEntity>> result = new BasePagingQueryResult<>();
        result.data = locations.getContent();
        result.total = locations.getTotalElements();
        result.totalPage = locations.getTotalPages();
        return result;
    }

    @Override
    public List<LocationEntity> findByKeyword(String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            throw new RuntimeException("Invalid keyword");
        }
        return repository.findByNameContainingIgnoreCaseOrAddressContainingIgnoreCase(keyword, keyword);
    }
}
