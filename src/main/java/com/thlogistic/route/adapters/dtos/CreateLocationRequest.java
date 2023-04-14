package com.thlogistic.route.adapters.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateLocationRequest {
    @NotBlank(message = "Invalid name")
    String name;
    @NotBlank(message = "Invalid address")
    String address;
    @NotNull(message = "Invalid latitude")
    Double latitude;
    @NotNull(message = "Invalid longitude")
    Double longitude;
}
