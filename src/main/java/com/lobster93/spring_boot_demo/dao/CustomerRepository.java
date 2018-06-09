package com.lobster93.spring_boot_demo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    Customer getById(String customerId);
}