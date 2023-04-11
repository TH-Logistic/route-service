package com.thlogistic.route.adapters.repositories;

import com.thlogistic.route.entities.RouteEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoRouteRepository extends MongoRepository<RouteEntity, String> {
}
