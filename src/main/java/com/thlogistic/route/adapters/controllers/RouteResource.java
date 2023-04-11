package com.thlogistic.route.adapters.controllers;

import com.thlogistic.route.adapters.dtos.CreateRouteRequest;
import com.thlogistic.route.adapters.dtos.ListRoutePagingRequest;
import com.thlogistic.route.adapters.dtos.UpdateRouteRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/route")
interface RouteResource {
    @GetMapping("/list")
    ResponseEntity<Object> listRoute(@Valid ListRoutePagingRequest request);

    @PostMapping
    ResponseEntity<Object> createRoute(@Valid @RequestBody CreateRouteRequest request);

    @PutMapping("/{id}")
    ResponseEntity<Object> updateRoute(@Valid @RequestBody UpdateRouteRequest request, @PathVariable String id);
}
