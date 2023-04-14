package com.thlogistic.route.entities;

import com.thlogistic.route.core.entities.Location;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document("location")
public class LocationEntity {
    @Id
    String id;
    String name;
    String address;
    Double latitude;
    Double longitude;

    public LocationEntity(String name, String address, Double latitude, Double longitude) {
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Location toLocation() {
        return new Location(
                this.id,
                this.name,
                this.address,
                this.latitude,
                this.longitude
        );
    }
}
