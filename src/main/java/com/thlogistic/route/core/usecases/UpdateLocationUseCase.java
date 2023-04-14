package com.thlogistic.route.core.usecases;

import com.thlogistic.route.adapters.dtos.UpdateLocationRequest;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

@Service
public interface UpdateLocationUseCase extends BaseUseCase<Pair<String, UpdateLocationRequest>, Object> {
}
