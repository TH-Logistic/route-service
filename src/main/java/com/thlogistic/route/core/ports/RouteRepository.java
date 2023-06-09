package com.thlogistic.route.core.ports;


import com.thlogistic.route.adapters.repositories.BasePagingQueryResult;
import com.thlogistic.route.entities.RouteEntity;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface RouteRepository {
    String insert(RouteEntity Route);

    String save(RouteEntity Route);

    List<RouteEntity> findAll();
    Optional<RouteEntity> findById(String id);
    List<RouteEntity> findByLocationId(String locationId);

    BasePagingQueryResult<List<RouteEntity>> paging(Integer page, Integer size);
    BasePagingQueryResult<List<RouteEntity>> pagingByLocationIds(Collection<String> locationIds, Double minLength, Double maxLength, Integer page, Integer size);

}
