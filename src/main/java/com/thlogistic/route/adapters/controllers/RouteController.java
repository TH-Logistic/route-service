package com.thlogistic.route.adapters.controllers;

import com.thlogistic.route.adapters.dtos.CreateRouteRequest;
import com.thlogistic.route.adapters.dtos.ListRoutePagingRequest;
import com.thlogistic.route.adapters.dtos.UpdateRouteRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RouteController extends BaseController implements RouteResource {

    @Override
    public ResponseEntity<Object> listRoute(ListRoutePagingRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Object> createRoute(CreateRouteRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Object> updateRoute(UpdateRouteRequest request, String id) {
        return null;
    }
}
