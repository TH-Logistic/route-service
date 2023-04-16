package com.thlogistic.route.entities;

import com.thlogistic.route.core.entities.Route;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document("route")
public class RouteEntity {
    @Id
    String id;
    String startLocationId;
    String endLocationId;
    Double length;
    Double tripBasedCost;
    Double tonBasedLimit;
    Boolean isEnable;

    public RouteEntity(String startLocationId, String endLocationId, Double length, Double tripBasedCost, Double tonBasedLimit, Boolean isEnable) {
        this.startLocationId = startLocationId;
        this.endLocationId = endLocationId;
        this.length = length;
        this.tripBasedCost = tripBasedCost;
        this.tonBasedLimit = tonBasedLimit;
        this.isEnable = isEnable;
    }

    public Route toRoute() {
        return new Route(
                this.id,
                this.startLocationId,
                this.endLocationId,
                this.length,
                this.tripBasedCost,
                this.tonBasedLimit,
                this.isEnable
        );
    }
}
