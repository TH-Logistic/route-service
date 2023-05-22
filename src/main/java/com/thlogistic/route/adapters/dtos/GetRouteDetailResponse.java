
package com.thlogistic.route.adapters.dtos;

import com.thlogistic.route.client.job.GetJobListNoRouteDto;
import com.thlogistic.route.client.job.JobStatisticDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetRouteDetailResponse {
    GetRouteSimpleResponse route;
    JobStatisticDto statistic;
    List<GetJobListNoRouteDto> jobs;
}
