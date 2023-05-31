package com.thlogistic.route.core.usecases;

import com.thlogistic.route.core.ports.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetTotalRouteUseCaseImpl implements GetTotalRouteUseCase {

    private final RouteRepository repository;

    @Override
    public Integer execute(String id) {
        return repository.findAll().size();
    }
}
