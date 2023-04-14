package com.thlogistic.route.core.usecases;

import com.thlogistic.route.adapters.dtos.BasePagingResponse;
import com.thlogistic.route.adapters.dtos.GetLocationResponse;
import com.thlogistic.route.adapters.dtos.ListLocationPagingRequest;
import org.springframework.stereotype.Service;

@Service
public
interface ListLocationUseCase extends BaseUseCase<ListLocationPagingRequest, BasePagingResponse<GetLocationResponse>> {
}
