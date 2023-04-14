package com.thlogistic.route.adapters.controllers;

import com.thlogistic.route.adapters.dtos.*;
import com.thlogistic.route.core.usecases.CreateLocationUseCase;
import com.thlogistic.route.core.usecases.ListLocationUseCase;
import com.thlogistic.route.core.usecases.UpdateLocationUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LocationController extends BaseController implements LocationResource {

    private final CreateLocationUseCase createLocationUseCase;
    private final UpdateLocationUseCase updateLocationUseCase;
    private final ListLocationUseCase listLocationUseCase;

    @Override
    public ResponseEntity<Object> listLocation(ListLocationPagingRequest request) {
        BasePagingResponse<GetLocationResponse> result = listLocationUseCase.execute(request);
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
