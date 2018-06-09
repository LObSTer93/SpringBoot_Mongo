package com.lobster93.spring_boot_demo.dto;

import com.lobster93.spring_boot_demo.dao.Customer;

public class DaoToDtoMapper {

    public static CustomerDTO mapDaoToDto(Customer customer){
        return CustomerDTO.builder()
                .name(customer.getName())
                .email(customer.getEmail())
                .build();
    }
}