package com.thlogistic.route.core.usecases;

import com.thlogistic.route.adapters.dtos.*;
import com.thlogistic.route.aop.exception.CustomRuntimeException;
import com.thlogistic.route.client.job.GetJobListDto;
import com.thlogistic.route.client.job.GetJobStatisticResponse;
import com.thlogistic.route.client.job.JobClient;
import com.thlogistic.route.client.job.JobStatisticDto;
import com.thlogistic.route.core.entities.Location;
import com.thlogistic.route.core.ports.RouteRepository;
import com.thlogistic.route.entities.RouteEntity;
import com.thlogistic.route.mapper.LocationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class GetLocationDetailUseCaseImpl implements GetLocationDetailUseCase {

    private final GetLocationUseCase getLocationUseCase;
    private final GetRouteDetailUseCase getRouteDetailUseCase;
    private final RouteRepository routeRepository;

    @Override
    public GetLocationDetailResponse execute(BaseTokenRequest<String> baseTokenRequest) {
        String token = baseTokenRequest.getToken();
        String locationId = baseTokenRequest.getRequestContent();

        Location location = getLocationUseCase.execute(locationId);

        List<RouteEntity> routeEntities = routeRepository.findByLocationId(locationId);

        List<GetRouteDetailResponse> routeDetailResponseList = new LinkedList<>();

        try {
            for (RouteEntity entity : routeEntities) {
                GetRouteDetailResponse response = getRouteDetailUseCase.execute(new BaseTokenRequest<>(token, entity.getId()));
                routeDetailResponseList.add(response);
            }
        } catch (Exception e) {
            System.out.println("justin: " + e.getMessage());
            throw new CustomRuntimeException("An error occurred when loading statistic for location detail");
        }

        JobStatisticDto jobStatisticDto = new JobStatisticDto(0, 0, 0.0, 0.0);
        Set<GetJobListDto> jobListDtos = new LinkedHashSet<>();

        for (GetRouteDetailResponse routeDetailResponse: routeDetailResponseList) {
            jobStatisticDto.setTotalTripBasedJob(
                    jobStatisticDto.getTotalTripBasedJob() + routeDetailResponse.getStatistic().getTotalTripBasedJob()
            );
            jobStatisticDto.setTotalTonBasedJob(
                    jobStatisticDto.getTotalTonBasedJob() + routeDetailResponse.getStatistic().getTotalTonBasedJob()
            );
            // TODO: Update this
//            jobStatisticDto.setTotalDistance(
//                    jobStatisticDto.getTotalDistance() + routeDetailResponse.getStatistic().getTotalDistance()
//            );
            jobStatisticDto.setTotalWeight(
                    jobStatisticDto.getTotalWeight() + routeDetailResponse.getStatistic().getTotalWeight()
            );
            jobListDtos.addAll(routeDetailResponse.getJobs());
        }
        GetLocationDetailResponse response = new GetLocationDetailResponse();
        response.setLocation(LocationMapper.fromLocationToResponse(location));
        response.setStatistic(jobStatisticDto);
        response.setJobs(jobListDtos.stream().toList());

        return response;
    }
}
