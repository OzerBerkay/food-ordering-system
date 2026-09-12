package com.berkay.identity.service.dataaccess.address.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

import com.berkay.identity.service.dataaccess.user.entity.BaseEntity;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_addresses")
@Entity
public class AddressEntity extends BaseEntity {

    @Id
    private UUID id;

    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String district;

    @Column(nullable = false)
    private String neighborhood;

    @Column(nullable = false)
    private String street;

    @Column(name = "building_number", nullable = false)
    private String buildingNumber;

    @Column(name = "door_number", nullable = false)
    private String doorNumber;

    @Column
    private Integer floor;

    @Column(name = "address_instructions", length = 500)
    private String addressInstructions;

    @Column(name = "contact_first_name", nullable = false, length = 50)
    private String contactFirstName;

    @Column(name = "contact_last_name", nullable = false, length = 50)
    private String contactLastName;

    @Column(name = "contact_phone", nullable = false, length = 20)
    private String contactPhone;

    @Column(nullable = false)
    private String country;

    @Column
    private Double latitude;

    @Column
    private Double longitude;

    @Column(name = "is_default", nullable = false)
    private boolean isDefault;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressEntity that = (AddressEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
