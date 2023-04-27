package com.thlogistic.route.core.usecases;

import com.thlogistic.route.adapters.dtos.BasePagingResponse;
import com.thlogistic.route.adapters.dtos.GetRouteResponse;
import com.thlogistic.route.adapters.dtos.PagingRouteRequest;
import com.thlogistic.route.adapters.repositories.BasePagingQueryResult;
import com.thlogistic.route.core.entities.Location;
import com.thlogistic.route.core.ports.RouteRepository;
import com.thlogistic.route.entities.RouteEntity;
import com.thlogistic.route.mapper.RouteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PagingRouteUseCaseImpl implements PagingRouteUseCase {

    private final RouteRepository repository;
    private final ListLocationUseCase listLocationUseCase;
    private final GetLocationUseCase getLocationUseCase;

    @Override
    public BasePagingResponse<GetRouteResponse> execute(PagingRouteRequest request) {
        String keywordQuery = request.getKeyword();

        BasePagingQueryResult<List<RouteEntity>> queryResult;

        if (keywordQuery == null || keywordQuery.isEmpty()) {
            queryResult = repository.paging(request.getPage(), request.getSize());
        } else {
            List<Location> locationContainsKeywordList = listLocationUseCase.execute(keywordQuery);
            List<String> locationContainsKeywordIdList = locationContainsKeywordList.stream().map(Location::getId).toList();
            queryResult = repository.pagingByLocationIds(locationContainsKeywordIdList,
                    request.getMinLength(),
                    request.getMaxLength(),
                    request.getPage(),
                    request.getSize());
        }

        Map<String, Location> locationMap = new HashMap<>();
        queryResult.getData().forEach(routeEntity -> {
            String startLocationId = routeEntity.getStartLocationId();
            String endLocationId = routeEntity.getEndLocationId();
            if (!locationMap.containsKey(startLocationId)) {
                locationMap.put(startLocationId, getLocationUseCase.execute(startLocationId));
            }
            if (!locationMap.containsKey(endLocationId)) {
                locationMap.put(endLocationId, getLocationUseCase.execute(endLocationId));
            }
        });

        BasePagingResponse<GetRouteResponse> response = new BasePagingResponse<>();
        List<GetRouteResponse> content = queryResult.getData().stream().map(routeEntity ->
                RouteMapper.fromRouteEntityAndLocationToResponse(
                        routeEntity,
                        locationMap.get(routeEntity.getStartLocationId()),
                        locationMap.get(routeEntity.getEndLocationId())
                )
        ).toList();

        response.setContent(content);
        response.setTotal(queryResult.getTotal());
        response.setTotalPage(queryResult.getTotalPage());
        return response;
    }
}
