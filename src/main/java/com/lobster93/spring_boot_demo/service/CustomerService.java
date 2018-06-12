package com.lobster93.spring_boot_demo.service;

import com.lobster93.spring_boot_demo.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    List<CustomerDTO> findAll();

    void save(CustomerDTO customerDTO);

    void delete(String customerName);

    List<CustomerDTO> getByName(String customerName);
}