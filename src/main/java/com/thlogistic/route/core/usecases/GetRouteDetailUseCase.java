package com.thlogistic.route.core.usecases;

import com.thlogistic.route.adapters.dtos.BaseTokenRequest;
import com.thlogistic.route.adapters.dtos.GetRouteDetailResponse;
import com.thlogistic.route.adapters.dtos.GetRouteResponse;
import org.springframework.stereotype.Service;

@Service
public interface GetRouteDetailUseCase extends BaseUseCase<BaseTokenRequest<String>, GetRouteDetailResponse> {
}
