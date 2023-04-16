package com.thlogistic.route.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Route {
    String id;
    String startLocationId;
    String endLocationId;
    Double length;
    Double tripBasedCost;
    Double tonBasedLimit;
    Boolean isEnable;
}
