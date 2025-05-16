package com.berkay.order.service.domain.ports.output.repository;

import com.berkay.order.service.domain.entity.Customer;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {

    Optional<Customer> findCustomerByCustomerId(UUID customerId);
}
