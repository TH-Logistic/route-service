package com.thlogistic.route.core.usecases;

import com.thlogistic.route.adapters.dtos.GetRouteResponse;
import com.thlogistic.route.adapters.dtos.UpdateRouteRequest;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

@Service
public interface GetRouteUseCase extends BaseUseCase<String, GetRouteResponse> {
}
