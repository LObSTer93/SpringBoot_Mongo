package com.lobster93.spring_boot_demo.controller;

import com.lobster93.spring_boot_demo.dto.CustomerDTO;
import com.lobster93.spring_boot_demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{customerName}")
    public List<CustomerDTO> getCustomer(@PathVariable("customerName") String customerName){
        return customerService.getByName(customerName);
    }

    @PostMapping
    public void saveCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.save(customerDTO);
    }

    @DeleteMapping("/{customerName}")
    public void deleteCustomer(@PathVariable("customerName") String customerName){
        customerService.delete(customerName);
    }

}