package com.thlogistic.route.client.job;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetJobListNoRouteDto {
    String id;
    String licensePlate;
    String driverInCharge;
    List<String> products;
    String createdAt;
    Double orderFee;
    Integer status;
}
