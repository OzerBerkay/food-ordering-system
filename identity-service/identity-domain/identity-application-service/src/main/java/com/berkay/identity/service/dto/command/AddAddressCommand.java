package com.berkay.identity.service.dto.command;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class AddAddressCommand {
    @NotBlank(message = "Address name is required")
    private final String name;
    
    @NotBlank(message = "City is required")
    private final String city;
    
    @NotBlank(message = "District is required")
    private final String district;
    
    @NotBlank(message = "Neighborhood is required")
    private final String neighborhood;
    
    @NotBlank(message = "Street is required")
    private final String street;
    
    @NotBlank(message = "Building number is required")
    private final String buildingNumber;
    
    @NotBlank(message = "Door number is required")
    private final String doorNumber;

    @NotBlank(message = "Contact first name is required")
    private final String contactFirstName;

    @NotBlank(message = "Contact last name is required")
    private final String contactLastName;

    @com.berkay.identity.service.dto.validation.ValidPhoneNumber
    private final String contactPhone;

    // Optional fields
    private final Integer floor;
    private final String addressInstructions;
    @com.fasterxml.jackson.annotation.JsonProperty("isDefault")
    private final boolean isDefault;
}
