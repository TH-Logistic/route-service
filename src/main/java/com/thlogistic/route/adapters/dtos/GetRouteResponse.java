package com.thlogistic.route.adapters.dtos;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetRouteResponse {
    String id;
    GetLocationResponse fromLocation;
    GetLocationResponse toLocation;
    Double length;
    Double tripBasedCost;
    Double tonBasedLimit;
    Boolean isEnable;
}
