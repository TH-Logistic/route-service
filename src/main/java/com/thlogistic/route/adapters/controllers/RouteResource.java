package com.thlogistic.route.adapters.controllers;

import com.thlogistic.route.adapters.dtos.CreateRouteRequest;
import com.thlogistic.route.adapters.dtos.PagingRouteRequest;
import com.thlogistic.route.adapters.dtos.UpdateRouteRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/route")
interface RouteResource {

    @GetMapping("/{id}")
    ResponseEntity<Object> getRoute(@PathVariable String id);

    @GetMapping("detail/{id}")
    ResponseEntity<Object> getRouteDetail(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @PathVariable String id);

    @GetMapping("/list")
    ResponseEntity<Object> listRoute(@Valid PagingRouteRequest request);

    @GetMapping("/total")
    ResponseEntity<Object> getTotalRoutes(@RequestHeader(HttpHeaders.AUTHORIZATION) String token);

    @PostMapping
    ResponseEntity<Object> createRoute(@Valid @RequestBody CreateRouteRequest request);

    @PutMapping("/{id}")
    ResponseEntity<Object> updateRoute(@Valid @RequestBody UpdateRouteRequest request, @PathVariable String id);
}
