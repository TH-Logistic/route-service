package com.thlogistic.route.adapters.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimpleGetLocationResponse {
    String id;
    String name;
    String address;
}
