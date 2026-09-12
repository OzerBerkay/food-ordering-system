package com.berkay.identity.service.handler.address;

import com.berkay.identity.service.domain.entity.Address;
import com.berkay.identity.service.domain.entity.User;
import com.berkay.identity.service.domain.exception.IdentityDomainException;
import com.berkay.identity.service.domain.valueobject.AddressId;
import com.berkay.identity.service.dto.query.UserAddressResponse;
import com.berkay.identity.service.ports.output.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class QueryMyAddressByIdHandler {

    private final AddressRepository addressRepository;

    public UserAddressResponse getMyAddressById(UUID userId, UUID addressId) {
        log.info("Querying address {} for user: {}", addressId, userId);
        
        Address address = addressRepository.findById(new AddressId(addressId))
                .orElseThrow(() -> new IdentityDomainException("Address not found or does not belong to user"));

        if (!address.getUserId().getValue().equals(userId)) {
            throw new IdentityDomainException("Address not found or does not belong to user");
        }

        return UserAddressResponse.builder()
                .id(address.getId().getValue())
                .userId(address.getUserId().getValue())
                .name(address.getName())
                .city(address.getCity())
                .district(address.getDistrict())
                .neighborhood(address.getNeighborhood())
                .street(address.getStreet())
                .buildingNumber(address.getBuildingNumber())
                .doorNumber(address.getDoorNumber())
                .floor(address.getFloor())
                .addressInstructions(address.getAddressInstructions())
                .contactFirstName(address.getContactFirstName())
                .contactLastName(address.getContactLastName())
                .contactPhone(address.getContactPhone())
                .isDefault(address.isDefault())
                .build();
    }
}
