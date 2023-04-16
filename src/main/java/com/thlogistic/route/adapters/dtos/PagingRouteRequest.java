package com.thlogistic.route.adapters.dtos;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PagingRouteRequest extends BasePagingRequest {
    String keyword;

    @DecimalMin(value = "0.0", message = "Invalid min length")
    Double minLength;

    @DecimalMin(value = "0.0", message = "Invalid max length")
    Double maxLength;
}
