package com.thlogistic.route.client.job;

import com.thlogistic.route.adapters.dtos.BaseResponse;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface JobClient {
    @RequestLine("GET api/v1/job/statistic/route/{routeId}")
    @Headers({
            "Content-Type: application/json",
            "Authorization: {token}"
    })
    BaseResponse<GetJobStatisticResponse<GetJobListNoRouteDto>> getJobStatisticForRoute(@Param("token") String token, @Param("routeId") String routeId);
}
