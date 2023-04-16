package com.thlogistic.route.core.usecases;

import com.thlogistic.route.adapters.dtos.BasePagingResponse;
import com.thlogistic.route.adapters.dtos.GetRouteResponse;
import com.thlogistic.route.adapters.dtos.ListRoutePagingRequest;
import org.springframework.stereotype.Service;

@Service
public interface PagingRouteUseCase extends BaseUseCase<ListRoutePagingRequest, BasePagingResponse<GetRouteResponse>> {
}
