package com.berkay.identity.service.dataaccess.address.repository;

import com.berkay.identity.service.dataaccess.address.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AddressJpaRepository extends JpaRepository<AddressEntity, UUID> {
    java.util.List<AddressEntity> findByUserId(UUID userId);

    @Modifying
    @Query("UPDATE AddressEntity a SET a.isDefault = false WHERE a.userId = :userId")
    void makeAllAddressesNonDefault(@Param("userId") UUID userId);
}
