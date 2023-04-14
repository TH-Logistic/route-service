package com.thlogistic.route.core.usecases;

import com.thlogistic.route.core.entities.Location;
import org.springframework.stereotype.Service;

@Service
public interface GetLocationUseCase extends BaseUseCase<String, Location> {
}
