package com.thlogistic.route.core.usecases;

import com.thlogistic.route.adapters.dtos.BasePagingResponse;
import com.thlogistic.route.adapters.dtos.GetLocationResponse;
import com.thlogistic.route.adapters.dtos.PagingLocationRequest;
import com.thlogistic.route.adapters.repositories.BasePagingQueryResult;
import com.thlogistic.route.core.ports.LocationRepository;
import com.thlogistic.route.entities.LocationEntity;
import com.thlogistic.route.mapper.LocationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PagingLocationUseCaseImpl implements PagingLocationUseCase {

    private final LocationRepository repository;

    @Override
    public BasePagingResponse<GetLocationResponse> execute(PagingLocationRequest request) {
        BasePagingQueryResult<List<LocationEntity>> queryResult =
                repository.paging(request.getKeyword(), request.getPage(), request.getSize());

        BasePagingResponse<GetLocationResponse> response = new BasePagingResponse<>();
        response.setContent(queryResult.getData().stream().map(LocationMapper::fromLocationEntityToResponse).toList());
        response.setTotal(queryResult.getTotal());
        response.setTotalPage(queryResult.getTotalPage());
        return response;
    }
}
