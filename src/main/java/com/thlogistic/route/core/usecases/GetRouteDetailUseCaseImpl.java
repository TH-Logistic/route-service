package com.thlogistic.route.core.usecases;

import com.thlogistic.route.adapters.dtos.*;
import com.thlogistic.route.aop.exception.CustomRuntimeException;
import com.thlogistic.route.aop.exception.DataNotFoundException;
import com.thlogistic.route.client.job.GetJobListNoRouteDto;
import com.thlogistic.route.client.job.GetJobStatisticResponse;
import com.thlogistic.route.client.job.JobClient;
import com.thlogistic.route.client.job.JobStatisticDto;
import com.thlogistic.route.core.entities.Location;
import com.thlogistic.route.core.entities.Route;
import com.thlogistic.route.core.ports.RouteRepository;
import com.thlogistic.route.entities.RouteEntity;
import com.thlogistic.route.mapper.RouteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetRouteDetailUseCaseImpl implements GetRouteDetailUseCase {

    private final GetRouteUseCase getRouteUseCase;
    private final JobClient jobClient;

    @Override
    public GetRouteDetailResponse execute(BaseTokenRequest<String> baseTokenRequest) {
        String token = baseTokenRequest.getToken();
        String routeId = baseTokenRequest.getRequestContent();

        GetRouteResponse getRouteResponse = getRouteUseCase.execute(routeId);

        GetRouteSimpleResponse routeSimpleResponse = GetRouteSimpleResponse.builder()
                .id(getRouteResponse.getId())
                .fromLocation(getRouteResponse.getFromLocation().getName())
                .toLocation(getRouteResponse.getToLocation().getName())
                .length(getRouteResponse.getLength())
                .tripBasedCost(getRouteResponse.getTripBasedCost())
                .tonBasedLimit(getRouteResponse.getTonBasedLimit())
                .isEnable(getRouteResponse.getIsEnable())
                .build();

        BaseResponse<GetJobStatisticResponse<GetJobListNoRouteDto>> getJobStatisticResponse;

        try {
            getJobStatisticResponse = jobClient.getJobStatisticForRoute(token, routeId);
        } catch (Exception e) {
            throw new CustomRuntimeException("An error occurred when loading statistic for route detail");
        }

        JobStatisticDto jobStatisticDto = getJobStatisticResponse.getData().getStatistic();
        List<GetJobListNoRouteDto> jobListDtos = getJobStatisticResponse.getData().getJobs();

        return new GetRouteDetailResponse(
                routeSimpleResponse,
                jobStatisticDto,
                jobListDtos
        );
    }
}
