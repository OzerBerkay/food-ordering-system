package com.berkay.identity.service.dto.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotBlank;

@Getter
@Builder
@AllArgsConstructor
@lombok.extern.jackson.Jacksonized
public class UpdateUserProfileCommand {
    
    @NotBlank(message = "First name must not be blank")
    private final String firstName;
    
    @NotBlank(message = "Last name must not be blank")
    private final String lastName;
    private final String imageUrl;

    @com.fasterxml.jackson.annotation.JsonProperty("dateOfBirth")
    @com.fasterxml.jackson.annotation.JsonFormat(shape = com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer.class)
    private final java.time.LocalDate dateOfBirth;
}

