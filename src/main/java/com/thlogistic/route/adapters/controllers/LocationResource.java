package com.thlogistic.route.adapters.controllers;

import com.thlogistic.route.adapters.dtos.CreateLocationRequest;
import com.thlogistic.route.adapters.dtos.ListLocationPagingRequest;
import com.thlogistic.route.adapters.dtos.UpdateLocationRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/location")
interface LocationResource {
    @GetMapping("/list")
    ResponseEntity<Object> listLocation(@Valid ListLocationPagingRequest request);

    @PostMapping
    ResponseEntity<Object> createLocation(@Valid @RequestBody CreateLocationRequest request);

    @PutMapping("/{id}")
    ResponseEntity<Object> updateLocation(@Valid @RequestBody UpdateLocationRequest request, @PathVariable String id);
}
