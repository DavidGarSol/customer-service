package com.midominio.customer_service.controller;

import org.springframework.web.bind.annotation.RestController;

import com.midominio.customer_service.model.CustomerResponse;
import com.midominio.customer_service.service.CustomerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(path = "/api")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

    @GetMapping("/customers")
    public List<CustomerResponse> getCustomers(@RequestParam(required = false) Character status) {
        return customerService.getCustomers(status);
    }

    @GetMapping("/customer/{customerNumber}")
    public CustomerResponse getCustomer(@PathVariable String customerNumber) {
        return customerService.getCustomer(customerNumber);
    }

}
