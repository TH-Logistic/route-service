package com.thlogistic.route.adapters.repositories;

import com.thlogistic.route.entities.RouteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;
import java.util.List;

public interface MongoRouteRepository extends MongoRepository<RouteEntity, String> {
    Page<RouteEntity> findByStartLocationIdInOrEndLocationIdInAndLengthBetween(Collection<String> fromId, Collection<String> toId, Double minLength, Double maxLength, Pageable pageable);
    Page<RouteEntity> findAll(Pageable pageable);
    List<RouteEntity> findByStartLocationIdOrEndLocationId(String startLocationId, String endLocationId);
}
