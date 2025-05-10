package com.midominio.customer_service.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.midominio.customer_service.model.Customer;
import com.midominio.customer_service.model.CustomerResponse;
import com.midominio.customer_service.repository.CustomerRepository;
import com.midominio.customer_service.service.CustomerService;

@Service
public class CustomerServiceImp implements CustomerService {

    @Autowired
    private CustomerRepository repo;

    Function<Customer, CustomerResponse> mapper = this::cutomerMapper;

    @Override
    public List<CustomerResponse> getCustomers(Character status) {
        List<Customer> customers = null;

        if (Objects.isNull(status)) customers = repo.findAll();
        else customers = repo.findByStatus(status);

        if(Objects.isNull(customers)) return null;
        else return customers.stream().map(mapper).toList();
    }

    @Override
    public CustomerResponse getCustomer(String customerNumber) {
        Customer customer = repo.findById(customerNumber).orElseThrow();
        return this.mapper.apply(customer);
    }

    private CustomerResponse cutomerMapper(Customer customer) {
        CustomerResponse response = new CustomerResponse();
        response.setName(customer.getName());
        response.setLastName(customer.getLastName());
        response.setEmail(customer.getEmail());

        return response;
    }

}
