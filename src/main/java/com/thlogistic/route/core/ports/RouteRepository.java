package com.thlogistic.route.core.ports;


import com.thlogistic.route.adapters.repositories.BasePagingQueryResult;
import com.thlogistic.route.entities.RouteEntity;

import java.util.List;
import java.util.Optional;

public interface RouteRepository {
    String insert(RouteEntity Route);

    String save(RouteEntity Route);

    Optional<RouteEntity> findById(String id);

    BasePagingQueryResult<List<RouteEntity>> list(String keyword, Integer page, Integer size);

}
