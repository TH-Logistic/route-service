package com.thlogistic.route.adapters.repositories;

import com.thlogistic.route.entities.LocationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoLocationRepository extends MongoRepository<LocationEntity, String> {
    Page<LocationEntity> findByNameContainingIgnoreCaseOrAddressContainingIgnoreCase(String name, String address, Pageable pageable);
}
