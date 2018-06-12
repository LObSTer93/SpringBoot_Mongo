package com.lobster93.spring_boot_demo.exceptions;

public class CustomerException extends RuntimeException{

    public CustomerException(String message) {
        super(message);
    }
}