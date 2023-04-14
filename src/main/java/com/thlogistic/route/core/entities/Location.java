package com.thlogistic.route.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    String id;
    String name;
    String address;
    Double latitude;
    Double longitude;
}
