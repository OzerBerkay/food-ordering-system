package com.berkay.identity.service.handler;

import com.berkay.identity.service.domain.entity.Address;
import com.berkay.identity.service.domain.exception.IdentityDomainException;
import com.berkay.identity.service.domain.valueobject.AddressId;
import com.berkay.identity.service.domain.valueobject.UserId;
import com.berkay.identity.service.dto.command.AddAddressCommand;
import com.berkay.identity.service.dto.command.AddressResponse;
import com.berkay.identity.service.dto.command.UpdateAddressCommand;
import com.berkay.identity.service.ports.output.repository.AddressRepository;
import com.berkay.identity.service.ports.output.security.SecurityContextPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class AddressCommandHandler {

    private final AddressRepository addressRepository;
    private final SecurityContextPort securityContextPort;

    @Transactional
    public AddressResponse addAddress(AddAddressCommand command) {
        UUID currentUserId = securityContextPort.getCurrentInternalUserId();
        log.info("Adding address for user id: {}", currentUserId);

        if (command.isDefault()) {
            addressRepository.makeAllAddressesNonDefault(new UserId(currentUserId));
        }

        Address address = Address.create(
                new UserId(currentUserId),
                command.getName(),
                command.getCity(),
                command.getDistrict(),
                command.getNeighborhood(),
                command.getStreet(),
                command.getBuildingNumber(),
                command.getDoorNumber(),
                command.getFloor(),
                command.getAddressInstructions(),
                command.getContactFirstName(),
                command.getContactLastName(),
                command.getContactPhone(),
                command.isDefault()
        );

        address = addressRepository.save(address);

        return AddressResponse.builder()
                .addressId(address.getId().getValue())
                .message("Address created successfully")
                .build();
    }

    @Transactional
    public AddressResponse updateAddress(UUID addressId, UpdateAddressCommand command) {
        UUID currentUserId = securityContextPort.getCurrentInternalUserId();
        log.info("Updating address id: {} for user id: {}", addressId, currentUserId);

        Address address = addressRepository.findById(new AddressId(addressId))
                .orElseThrow(() -> new IdentityDomainException("Address not found!"));

        if (!address.getUserId().getValue().equals(currentUserId)) {
            log.error("IDOR Attempt! User {} tried to update address {} belonging to user {}", currentUserId, addressId, address.getUserId().getValue());
            throw new IdentityDomainException("You are not authorized to update this address!");
        }

        if (command.isDefault() && !address.isDefault()) {
            addressRepository.makeAllAddressesNonDefault(new UserId(currentUserId));
        }

        Address updatedAddress = Address.builder()
                .addressId(address.getId())
                .userId(address.getUserId())
                .name(command.getName())
                .city(command.getCity())
                .district(command.getDistrict())
                .neighborhood(command.getNeighborhood())
                .street(command.getStreet())
                .buildingNumber(command.getBuildingNumber())
                .doorNumber(command.getDoorNumber())
                .floor(command.getFloor())
                .addressInstructions(command.getAddressInstructions())
                .contactFirstName(command.getContactFirstName())
                .contactLastName(command.getContactLastName())
                .contactPhone(command.getContactPhone())
                .isDefault(command.isDefault())
                .build();

        updatedAddress = addressRepository.save(updatedAddress);

        return AddressResponse.builder()
                .addressId(updatedAddress.getId().getValue())
                .message("Address updated successfully")
                .build();
    }
}
