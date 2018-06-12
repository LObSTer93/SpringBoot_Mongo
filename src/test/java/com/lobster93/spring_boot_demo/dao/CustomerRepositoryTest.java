package com.lobster93.spring_boot_demo.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
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
        List<Customer> customers = customerRepository.getByName("Bill");
        assertEquals(customers.size(), 1);
    }

    @Test
    public void nullTest() {
        List<Customer> customers = customerRepository.getByName("Bill1");
        assertEquals(customers.size(), 0);

        customers = customerRepository.getByName(null);
        assertEquals(customers.size(), 0);
    }
}