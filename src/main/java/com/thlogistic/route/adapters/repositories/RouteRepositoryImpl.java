package com.thlogistic.route.adapters.repositories;

import com.thlogistic.route.core.ports.RouteRepository;
import com.thlogistic.route.entities.RouteEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RouteRepositoryImpl implements RouteRepository {
    private final MongoRouteRepository repository;

    @Override
    public String insert(RouteEntity Route) {
        return null;
    }

    @Override
    public String save(RouteEntity Route) {
        return null;
    }

    @Override
    public Optional<RouteEntity> findById(String id) {
        return Optional.empty();
    }

    @Override
    public BasePagingQueryResult<List<RouteEntity>> list(String keyword, Integer page, Integer size) {
        return null;
    }
}
