package com.thlogistic.route.adapters.controllers;

import com.thlogistic.route.adapters.dtos.CreateLocationRequest;
import com.thlogistic.route.adapters.dtos.ListLocationPagingRequest;
import com.thlogistic.route.adapters.dtos.UpdateLocationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LocationController extends BaseController implements LocationResource {


    @Override
    public ResponseEntity<Object> listLocation(ListLocationPagingRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Object> createLocation(CreateLocationRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Object> updateLocation(UpdateLocationRequest request, String id) {
        return null;
    }
}
