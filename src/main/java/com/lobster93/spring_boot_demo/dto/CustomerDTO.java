package com.lobster93.spring_boot_demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CustomerDTO {
    private String name;
    private String email;
}