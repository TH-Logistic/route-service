package com.thlogistic.route.core.usecases;

import com.thlogistic.route.adapters.dtos.BasePagingResponse;
import com.thlogistic.route.adapters.dtos.GetLocationResponse;
import com.thlogistic.route.adapters.dtos.PagingLocationRequest;
import org.springframework.stereotype.Service;

@Service
public
interface PagingLocationUseCase extends BaseUseCase<PagingLocationRequest, BasePagingResponse<GetLocationResponse>> {
}
