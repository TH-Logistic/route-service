package com.thlogistic.route.adapters.controllers;

import com.thlogistic.route.adapters.dtos.*;
import com.thlogistic.route.core.entities.Location;
import com.thlogistic.route.core.usecases.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LocationController extends BaseController implements LocationResource {

    private final CreateLocationUseCase createLocationUseCase;
    private final GetLocationUseCase getLocationUseCase;
    private final GetLocationDetailUseCase getLocationDetailUseCase;
    private final UpdateLocationUseCase updateLocationUseCase;
    private final PagingLocationUseCase pagingLocationUseCase;

    @Override
    public ResponseEntity<Object> listLocation(PagingLocationRequest request) {
        BasePagingResponse<GetLocationResponse> result = pagingLocationUseCase.execute(request);
        return successResponse(result, null);
    }

    @Override
    public ResponseEntity<Object> getLocationDetail(String token, String id) {
        GetLocationDetailResponse result = getLocationDetailUseCase.execute(
                new BaseTokenRequest<>(token, id)
        );
        return successResponse(result, null);
    }

    @Override
    public ResponseEntity<Object> getLocation(String id) {
        Location result = getLocationUseCase.execute(id);
        return successResponse(result, null);
    }

    @Override
    public ResponseEntity<Object> createLocation(CreateLocationRequest request) {
        CreateLocationResponse result = createLocationUseCase.execute(request);
        return successResponse(result, null);
    }

    @Override
    public ResponseEntity<Object> updateLocation(UpdateLocationRequest request, String id) {
        updateLocationUseCase.execute(Pair.of(id, request));
        return successResponse(true, null);
    }
}
