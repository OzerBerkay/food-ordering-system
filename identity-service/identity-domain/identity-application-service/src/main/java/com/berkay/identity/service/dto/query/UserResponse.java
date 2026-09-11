package com.berkay.identity.service.dto.query;

import com.berkay.identity.service.domain.valueobject.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@lombok.extern.jackson.Jacksonized
public class UserResponse {
    private final java.util.UUID id;
    private final String externalId;
    private final String email;
    private final String firstName;
    private final String lastName;
    private final String phoneNumber;
    private final UserType userType;
    private final com.berkay.identity.service.domain.valueobject.AccountStatus status;
    private final com.berkay.identity.service.domain.valueobject.AuthProvider authProvider;
    private final boolean isEmailVerified;
    private final boolean isPhoneVerified;
    private final String imageUrl;

    @com.fasterxml.jackson.annotation.JsonProperty("dateOfBirth")
    @com.fasterxml.jackson.annotation.JsonFormat(shape = com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer.class)
    private final java.time.LocalDate dateOfBirth;
    private final java.time.ZonedDateTime createdAt;
    private final java.time.ZonedDateTime updatedAt;
    private final List<java.util.UUID> organizationalUnitIds;
    private final List<RoleResponse> roles;
}
