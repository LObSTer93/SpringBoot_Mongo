package com.lobster93.spring_boot_demo.dto;

import com.lobster93.spring_boot_demo.dao.Customer;

public class DaoToDtoMapper {

    public static CustomerDTO mapDaoToDto(Customer customer){
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName(customer.getName());
        customerDTO.setEmail(customer.getEmail());
        return customerDTO;
    }
}