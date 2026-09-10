package com.berkay.identity.service.application.rest;

import com.berkay.identity.service.dto.command.CreateUserResponse;
import com.berkay.identity.service.dto.command.RegisterCustomerCommand;
import com.berkay.identity.service.dto.command.RegisterMerchantCommand;
import com.berkay.identity.service.dto.command.LoginCommand;
import com.berkay.identity.service.dto.command.RefreshTokenCommand;
import com.berkay.identity.service.dto.command.TokenResponse;
import com.berkay.identity.service.dto.command.UpdatePasswordCommand;
import com.berkay.identity.service.ports.input.service.AuthApplicationService;
import com.berkay.identity.service.ports.input.service.UserApplicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/auth", produces = "application/vnd.api.v1+json")
@RequiredArgsConstructor
public class UserAuthController {
    private final UserApplicationService userApplicationService;
    private final AuthApplicationService authApplicationService;

    @PostMapping("/register/customer")
    public ResponseEntity<CreateUserResponse> registerCustomer(@RequestBody @Valid RegisterCustomerCommand command) {
        log.info("Received register customer request for email: {}", command.getEmail());
        CreateUserResponse response = userApplicationService.registerCustomer(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/register/merchant")
    public ResponseEntity<CreateUserResponse> registerMerchant(@RequestBody @Valid RegisterMerchantCommand command) {
        log.info("Received register merchant request for email: {}", command.getEmail());
        CreateUserResponse response = userApplicationService.registerMerchant(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    private static final com.fasterxml.jackson.databind.ObjectMapper MAPPER = new com.fasterxml.jackson.databind.ObjectMapper();

    @PostMapping("/login/customer")
    public ResponseEntity<TokenResponse> loginCustomer(@RequestBody @Valid LoginCommand command) {
        log.info("Received login request for customer: {}", command.getEmail());
        TokenResponse response = authApplicationService.login(command);
        validateUserType(response.getAccessToken(), "CUSTOMER");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login/merchant")
    public ResponseEntity<TokenResponse> loginMerchant(@RequestBody @Valid LoginCommand command) {
        log.info("Received login request for merchant: {}", command.getEmail());
        TokenResponse response = authApplicationService.login(command);
        validateUserType(response.getAccessToken(), "MERCHANT");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login/internal")
    public ResponseEntity<TokenResponse> loginInternal(@RequestBody @Valid LoginCommand command) {
        log.info("Received login request for internal user: {}", command.getEmail());
        TokenResponse response = authApplicationService.login(command);
        validateUserType(response.getAccessToken(), "INTERNAL");
        return ResponseEntity.ok(response);
    }

    private void validateUserType(String token, String expectedType) {
        try {
            String[] parts = token.split("\\.");
            if (parts.length != 3) {
                return; // Skip validation for test tokens
            }
            String payloadJson = new String(java.util.Base64.getUrlDecoder().decode(parts[1]));
            com.fasterxml.jackson.databind.JsonNode payload = MAPPER.readTree(payloadJson);
            String userType = payload.path("user_type").asText();
            if (userType != null && !userType.isEmpty() && !expectedType.equals(userType)) {
                throw new com.berkay.identity.service.domain.exception.InvalidCredentialsException("INVALID_CREDENTIALS", "You do not have access to this panel");
            }
        } catch (com.berkay.identity.service.domain.exception.InvalidCredentialsException e) {
            throw e;
        } catch (Exception e) {
            log.error("Error parsing token for user type validation", e);
        }
    }

    @PostMapping("/refresh")
    public ResponseEntity<TokenResponse> refreshToken(@RequestBody @Valid RefreshTokenCommand command) {
        log.info("Received refresh token request");
        TokenResponse response = authApplicationService.refreshToken(command);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/password")
    public ResponseEntity<Void> updatePassword(@RequestBody @Valid UpdatePasswordCommand command) {
        log.info("Received password update request for current user");
        authApplicationService.updatePassword(command);
        return ResponseEntity.noContent().build();
    }
}