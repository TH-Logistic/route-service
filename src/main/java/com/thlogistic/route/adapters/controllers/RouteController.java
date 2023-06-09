package com.thlogistic.route.adapters.controllers;

import com.thlogistic.route.adapters.dtos.*;
import com.thlogistic.route.core.usecases.*;
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
    private final GetRouteUseCase getRouteUseCase;
    private final GetTotalRouteUseCase getTotalRouteUseCase;
    private final GetRouteDetailUseCase getRouteDetailUseCase;

    @Override
    public ResponseEntity<Object> getRoute(String id) {
        GetRouteResponse result = getRouteUseCase.execute(id);
        return successResponse(result, null);
    }

    @Override
    public ResponseEntity<Object> getRouteDetail(String token, String id) {
        GetRouteDetailResponse result = getRouteDetailUseCase.execute(
                new BaseTokenRequest<>(
                        token,
                        id
                )
        );
        return successResponse(result, null);
    }

    @Override
    public ResponseEntity<Object> listRoute(PagingRouteRequest request) {
        BasePagingResponse<GetRouteResponse> result = pagingRouteUseCase.execute(request);
        return successResponse(result, null);
    }

    @Override
    public ResponseEntity<Object> getTotalRoutes(String token) {
        Integer result = getTotalRouteUseCase.execute(token);
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
