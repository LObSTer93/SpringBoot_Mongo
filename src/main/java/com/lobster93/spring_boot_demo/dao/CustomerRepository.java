package com.lobster93.spring_boot_demo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    List<Customer> getByName(String customerName);
}