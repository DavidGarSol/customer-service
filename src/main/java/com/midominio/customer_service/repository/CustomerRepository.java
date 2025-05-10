package com.midominio.customer_service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.midominio.customer_service.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

    List<Customer> findByStatus(Character status);
    Optional<Customer> findByEmailAndPassword(String email, String password);

}
