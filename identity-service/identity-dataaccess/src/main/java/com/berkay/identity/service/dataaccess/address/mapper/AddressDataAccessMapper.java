package com.berkay.identity.service.dataaccess.address.mapper;

import com.berkay.identity.service.dataaccess.address.entity.AddressEntity;
import com.berkay.identity.service.domain.entity.Address;
import com.berkay.identity.service.domain.valueobject.AddressId;
import com.berkay.identity.service.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

@Component
public class AddressDataAccessMapper {

    public AddressEntity addressToAddressEntity(Address address) {
        return AddressEntity.builder()
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
                .country(address.getCountry())
                .latitude(address.getLatitude())
                .longitude(address.getLongitude())
                .isDefault(address.isDefault())
                .build();
    }

    public Address addressEntityToAddress(AddressEntity entity) {
        return Address.builder()
                .addressId(new AddressId(entity.getId()))
                .userId(new UserId(entity.getUserId()))
                .name(entity.getName())
                .city(entity.getCity())
                .district(entity.getDistrict())
                .neighborhood(entity.getNeighborhood())
                .street(entity.getStreet())
                .buildingNumber(entity.getBuildingNumber())
                .doorNumber(entity.getDoorNumber())
                .floor(entity.getFloor())
                .addressInstructions(entity.getAddressInstructions())
                .contactFirstName(entity.getContactFirstName())
                .contactLastName(entity.getContactLastName())
                .contactPhone(entity.getContactPhone())
                .country(entity.getCountry())
                .latitude(entity.getLatitude())
                .longitude(entity.getLongitude())
                .isDefault(entity.isDefault())
                .build();
    }
}
