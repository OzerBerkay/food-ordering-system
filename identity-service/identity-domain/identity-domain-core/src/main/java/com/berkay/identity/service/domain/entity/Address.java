package com.berkay.identity.service.domain.entity;

import com.berkay.domain.entity.AggregateRoot;
import com.berkay.identity.service.domain.valueobject.AddressId;
import com.berkay.identity.service.domain.valueobject.UserId;

import java.util.UUID;

public class Address extends AggregateRoot<AddressId> {
    private final UserId userId;
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
    
    private final String country;
    private final Double latitude;
    private final Double longitude;
    
    private boolean isDefault;

    // Private Constructor: Sadece içeriden (create veya builder) erişilebilir
    private Address(Builder builder) {
        super.setId(builder.addressId);
        this.userId = builder.userId;
        this.name = builder.name;
        this.city = builder.city;
        this.district = builder.district;
        this.neighborhood = builder.neighborhood;
        this.street = builder.street;
        this.buildingNumber = builder.buildingNumber;
        this.doorNumber = builder.doorNumber;
        this.floor = builder.floor;
        this.addressInstructions = builder.addressInstructions;
        this.contactFirstName = builder.contactFirstName;
        this.contactLastName = builder.contactLastName;
        this.contactPhone = builder.contactPhone;
        this.country = builder.country != null ? builder.country : "Turkey"; // Default Turkey
        this.latitude = builder.latitude;
        this.longitude = builder.longitude;
        this.isDefault = builder.isDefault;
    }

    public static Builder builder() {
        return new Builder();
    }

    // FACTORY METHOD: ID üretimini ve nesne oluşturmayı garanti altına alır.
    public static Address create(UserId userId, String name, String city, String district, String neighborhood, String street, String buildingNumber, String doorNumber, Integer floor, String addressInstructions, String contactFirstName, String contactLastName, String contactPhone, boolean isDefault) {
        return new Builder()
                .addressId(new AddressId(UUID.randomUUID()))
                .userId(userId)
                .name(name)
                .city(city)
                .district(district)
                .neighborhood(neighborhood)
                .street(street)
                .buildingNumber(buildingNumber)
                .doorNumber(doorNumber)
                .floor(floor)
                .addressInstructions(addressInstructions)
                .contactFirstName(contactFirstName)
                .contactLastName(contactLastName)
                .contactPhone(contactPhone)
                .isDefault(isDefault)
                .build();
    }

    public void removeDefault() {
        this.isDefault = false;
    }

    public void makeDefault() {
        this.isDefault = true;
    }

    public UserId getUserId() { return userId; }
    public String getName() { return name; }
    public String getCity() { return city; }
    public String getDistrict() { return district; }
    public String getNeighborhood() { return neighborhood; }
    public String getStreet() { return street; }
    public String getBuildingNumber() { return buildingNumber; }
    public String getDoorNumber() { return doorNumber; }
    public Integer getFloor() { return floor; }
    public String getAddressInstructions() { return addressInstructions; }
    public String getContactFirstName() { return contactFirstName; }
    public String getContactLastName() { return contactLastName; }
    public String getContactPhone() { return contactPhone; }
    public String getCountry() { return country; }
    public Double getLatitude() { return latitude; }
    public Double getLongitude() { return longitude; }
    public boolean isDefault() { return isDefault; }

    public static final class Builder {
        private AddressId addressId;
        private UserId userId;
        private String name;
        private String city;
        private String district;
        private String neighborhood;
        private String street;
        private String buildingNumber;
        private String doorNumber;
        private Integer floor;
        private String addressInstructions;
        private String contactFirstName;
        private String contactLastName;
        private String contactPhone;
        private String country;
        private Double latitude;
        private Double longitude;
        private boolean isDefault;

        private Builder() {}

        public Builder addressId(AddressId val) { addressId = val; return this; }
        public Builder userId(UserId val) { userId = val; return this; }
        public Builder name(String val) { name = val; return this; }
        public Builder city(String val) { city = val; return this; }
        public Builder district(String val) { district = val; return this; }
        public Builder neighborhood(String val) { neighborhood = val; return this; }
        public Builder street(String val) { street = val; return this; }
        public Builder buildingNumber(String val) { buildingNumber = val; return this; }
        public Builder doorNumber(String val) { doorNumber = val; return this; }
        public Builder floor(Integer val) { floor = val; return this; }
        public Builder addressInstructions(String val) { addressInstructions = val; return this; }
        public Builder contactFirstName(String val) { contactFirstName = val; return this; }
        public Builder contactLastName(String val) { contactLastName = val; return this; }
        public Builder contactPhone(String val) { contactPhone = val; return this; }
        public Builder country(String val) { country = val; return this; }
        public Builder latitude(Double val) { latitude = val; return this; }
        public Builder longitude(Double val) { longitude = val; return this; }
        public Builder isDefault(boolean val) { isDefault = val; return this; }

        public Address build() { return new Address(this); }
    }
}