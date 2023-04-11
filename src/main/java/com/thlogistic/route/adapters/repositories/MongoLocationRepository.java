package com.thlogistic.route.adapters.repositories;

import com.thlogistic.route.entities.LocationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoLocationRepository extends MongoRepository<LocationEntity, String> {
}
