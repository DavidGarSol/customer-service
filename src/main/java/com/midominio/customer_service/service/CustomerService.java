package com.midominio.customer_service.service;

import java.util.List;

import com.midominio.customer_service.model.CustomerResponse;

public interface CustomerService {

    List<CustomerResponse> getCustomers(Character status);
    CustomerResponse getCustomer(String customerNumber);

}
