package com.thlogistic.route.adapters.dtos;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class GetRouteResponse {
    String id;
    GetSimpleLocationResponse fromLocation;
    GetSimpleLocationResponse toLocation;
    Double length;
    Double tripBasedCost;
    Double tonBasedLimit;
    Boolean isEnable;
}
