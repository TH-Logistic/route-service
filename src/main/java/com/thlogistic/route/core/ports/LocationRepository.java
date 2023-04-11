package com.thlogistic.route.core.ports;


import com.thlogistic.route.adapters.repositories.BasePagingQueryResult;
import com.thlogistic.route.entities.LocationEntity;

import java.util.List;
import java.util.Optional;

public interface LocationRepository {
    String insert(LocationEntity Location);

    String save(LocationEntity Location);

    Optional<LocationEntity> findById(String id);

    BasePagingQueryResult<List<LocationEntity>> list(String keyword, Integer page, Integer size);

}
