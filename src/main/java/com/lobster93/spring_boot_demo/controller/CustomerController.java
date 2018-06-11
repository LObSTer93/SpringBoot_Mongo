package com.lobster93.spring_boot_demo.controller;

import com.lobster93.spring_boot_demo.dto.CustomerDTO;
import com.lobster93.spring_boot_demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<CustomerDTO> getCustomers(){
        return customerService.findAll();
    }

    @GetMapping("/{customerId}")
    public CustomerDTO getCustomer(@PathVariable("customerId") String customerId){
        return customerService.getById(customerId);
    }
}