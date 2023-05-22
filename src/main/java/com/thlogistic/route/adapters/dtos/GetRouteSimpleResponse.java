package com.thlogistic.route.adapters.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetRouteSimpleResponse {
    String id;
    String fromLocation;
    String toLocation;
    Double length;
    Double tripBasedCost;
    Double tonBasedLimit;
    Boolean isEnable;
}
