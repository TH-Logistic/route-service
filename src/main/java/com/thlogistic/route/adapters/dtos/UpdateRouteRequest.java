package com.thlogistic.route.adapters.dtos;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRouteRequest {
    @NotBlank(message = "Invalid start location ID ")
    String startLocationId;
    @NotBlank(message = "Invalid end location ID ")
    String endLocationId;
    @Min(value = 0, message = "Invalid length")
    Double length;
    @Min(value = 0, message = "Invalid trip-based cost")
    Double tripBasedCost;
    @Min(value = 0, message = "Invalid ton-based limit")
    Double tonBasedLimit;
    @NotNull(message = "Enable value must not be null")
    Boolean isEnable;
}
