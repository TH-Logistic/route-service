package com.thlogistic.route.core.usecases;

import com.thlogistic.route.adapters.dtos.BaseTokenRequest;
import com.thlogistic.route.adapters.dtos.GetLocationDetailResponse;
import com.thlogistic.route.adapters.dtos.GetRouteDetailResponse;
import org.springframework.stereotype.Service;

@Service
public interface GetLocationDetailUseCase extends BaseUseCase<BaseTokenRequest<String>, GetLocationDetailResponse> {
}
