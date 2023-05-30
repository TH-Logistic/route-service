package com.thlogistic.route.core.usecases;

import com.thlogistic.route.adapters.dtos.*;
import com.thlogistic.route.aop.exception.CustomRuntimeException;
import com.thlogistic.route.client.job.GetJobListDto;
import com.thlogistic.route.client.job.GetJobStatisticResponse;
import com.thlogistic.route.client.job.JobClient;
import com.thlogistic.route.client.job.JobStatisticDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

        BaseResponse<GetJobStatisticResponse<GetJobListDto>> getJobStatisticResponse;

        try {
            getJobStatisticResponse = jobClient.getJobStatisticForRoute(token, routeId);
        } catch (Exception e) {
            throw new CustomRuntimeException("An error occurred when loading statistic for route detail");
        }

        JobStatisticDto jobStatisticDto = getJobStatisticResponse.getData().getStatistic();
        List<GetJobListDto> jobListDtos = getJobStatisticResponse.getData().getJobs();

        for (GetJobListDto dto: jobListDtos) {
            dto.setPickUpAt(getRouteResponse.getFromLocation().getName());
            dto.setUnloadAt(getRouteResponse.getToLocation().getName());
        }

        return new GetRouteDetailResponse(
                routeSimpleResponse,
                jobStatisticDto,
                jobListDtos
        );
    }
}
