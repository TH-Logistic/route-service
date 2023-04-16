package com.thlogistic.route.adapters.dtos;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class GetRouteResponse {
    String id;
    SimpleGetLocationResponse fromLocation;
    SimpleGetLocationResponse toLocation;
    Double length;
    Double tripBasedCost;
    Double tonBasedLimit;
    Boolean isEnable;
}
