package com.thlogistic.route.adapters.repositories;

import com.thlogistic.route.core.ports.RouteRepository;
import com.thlogistic.route.entities.RouteEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RouteRepositoryImpl implements RouteRepository {
    private final MongoRouteRepository repository;

    @Override
    public String insert(RouteEntity route) {
        return repository.insert(route).getId();
    }

    @Override
    public String save(RouteEntity route) {
        return repository.save(route).getId();
    }

    @Override
    public List<RouteEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<RouteEntity> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<RouteEntity> findByLocationId(String locationId) {
        return repository.findByStartLocationIdOrEndLocationId(locationId, locationId);
    }

    @Override
    public BasePagingQueryResult<List<RouteEntity>> paging(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<RouteEntity> locations = repository.findAll(pageable);
        BasePagingQueryResult<List<RouteEntity>> result = new BasePagingQueryResult<>();
        result.data = locations.getContent();
        result.total = locations.getTotalElements();
        result.totalPage = locations.getTotalPages();
        return result;
    }

    @Override
    public BasePagingQueryResult<List<RouteEntity>> pagingByLocationIds(Collection<String> locationIds, Double minLength, Double maxLength, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<RouteEntity> locations = repository.findByStartLocationIdInOrEndLocationIdInAndLengthBetween(locationIds, locationIds, minLength, maxLength, pageable);
        BasePagingQueryResult<List<RouteEntity>> result = new BasePagingQueryResult<>();
        result.data = locations.getContent();
        result.total = locations.getTotalElements();
        result.totalPage = locations.getTotalPages();
        return result;
    }
}
