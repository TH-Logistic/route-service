package com.thlogistic.route.adapters.controllers;

import com.thlogistic.route.adapters.dtos.*;
import com.thlogistic.route.core.usecases.CreateRouteUseCase;
import com.thlogistic.route.core.usecases.PagingRouteUseCase;
import com.thlogistic.route.core.usecases.UpdateRouteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RouteController extends BaseController implements RouteResource {

    private final CreateRouteUseCase createRouteUseCase;
    private final UpdateRouteUseCase updateRouteUseCase;
    private final PagingRouteUseCase pagingRouteUseCase;

    @Override
    public ResponseEntity<Object> listRoute(ListRoutePagingRequest request) {
        BasePagingResponse<GetRouteResponse> result = pagingRouteUseCase.execute(request);
        return successResponse(result, null);
    }

    @Override
    public ResponseEntity<Object> createRoute(CreateRouteRequest request) {
        CreateRouteResponse result = createRouteUseCase.execute(request);
        return successResponse(result, null);
    }

    @Override
    public ResponseEntity<Object> updateRoute(UpdateRouteRequest request, String id) {
        updateRouteUseCase.execute(Pair.of(id, request));
        return successResponse(true, null);
    }
}
