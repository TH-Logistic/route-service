package com.thlogistic.route.core.usecases;

import com.thlogistic.route.adapters.dtos.BaseTokenRequest;
import com.thlogistic.route.adapters.dtos.GetRouteResponse;
import org.springframework.stereotype.Service;

@Service
public interface GetTotalRouteUseCase extends BaseUseCase<String, Integer> {
}
