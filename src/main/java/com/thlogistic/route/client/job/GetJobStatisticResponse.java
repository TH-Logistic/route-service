package com.thlogistic.route.client.job;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetJobStatisticResponse<T> {
    JobStatisticDto statistic;
    List<T> jobs;
}
