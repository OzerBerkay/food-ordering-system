package com.berkay.identity.service.dto.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UserAddressResponse {
    private final UUID id;
    private final UUID userId;
    private final String name;
    private final String city;
    private final String district;
    private final String neighborhood;
    private final String street;
    private final String buildingNumber;
    private final String doorNumber;
    private final Integer floor;
    private final String addressInstructions;
    private final String contactFirstName;
    private final String contactLastName;
    private final String contactPhone;
    @com.fasterxml.jackson.annotation.JsonProperty("isDefault")
    private final boolean isDefault;
}
