package com.lobster93.spring_boot_demo.dao;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;

@Getter
@Setter
@Builder
public class Customer {

    @Id
    private String id;
    private String name;
    private String email;
}