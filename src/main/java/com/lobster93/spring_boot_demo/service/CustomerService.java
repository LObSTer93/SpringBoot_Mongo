package com.lobster93.spring_boot_demo.service;

import com.lobster93.spring_boot_demo.dao.Customer;
import com.lobster93.spring_boot_demo.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    List<CustomerDTO> findAll();

    void save(Customer customer);

    void delete(long customerId);

    CustomerDTO getById(String customerId);

    void edit(String name, String email, long id);
}