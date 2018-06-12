package com.lobster93.spring_boot_demo.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@DataMongoTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Before
    public void before(){
        Customer customer = Customer.builder()
                .name("Bill")
                .email("Bill@mail.ru")
                .build();
        customerRepository.save(customer);
    }

    @After
    public void after(){
        customerRepository.deleteAll();
    }

    @Test
    public void getByNameTest() {
        Customer customer = customerRepository.getByName("Bill");
        assertNotNull(customer);
    }

    @Test
    public void nullTest() {
        Customer customer = customerRepository.getByName("Bill1");
        assertNull(customer);

        customer = customerRepository.getByName(null);
        assertNull(customer);
    }
}