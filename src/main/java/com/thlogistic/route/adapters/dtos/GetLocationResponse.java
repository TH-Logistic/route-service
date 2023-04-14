package com.thlogistic.route.adapters.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetLocationResponse {
    String id;
    String name;
    String address;
    Double latitude;
    Double longitude;
}
