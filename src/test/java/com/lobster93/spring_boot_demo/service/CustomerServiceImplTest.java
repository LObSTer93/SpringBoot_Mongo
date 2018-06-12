package com.lobster93.spring_boot_demo.service;

import com.lobster93.spring_boot_demo.dao.Customer;
import com.lobster93.spring_boot_demo.dao.CustomerRepository;
import com.lobster93.spring_boot_demo.dto.CustomerDTO;
import com.lobster93.spring_boot_demo.dto.DaoToDtoMapper;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CustomerServiceImplTest {

    private CustomerRepository CUSTOMER_REPOSITORY;
    private CustomerService CUSTOMER_SERVICE;

    private String CUSTOMER_NAME = "BILL";
    private Customer CUSTOMER = Customer.builder()
            .name(CUSTOMER_NAME)
            .email("Bill@mail.ru")
            .build();
    private List<Customer> CUSTOMERS = Collections.singletonList(CUSTOMER);

    @Before
    public void beforeClass(){
        CUSTOMER_REPOSITORY = Mockito.mock(CustomerRepository.class);
        CUSTOMER_SERVICE = new CustomerServiceImpl(CUSTOMER_REPOSITORY);

        when(CUSTOMER_REPOSITORY.findAll()).thenReturn(CUSTOMERS);
        when(CUSTOMER_REPOSITORY.getByName(CUSTOMER_NAME)).thenReturn(CUSTOMERS);
    }

    @Test
    public void findAll() {
        List<CustomerDTO> customerDTOs = CUSTOMER_SERVICE.findAll();
        assertEquals(customerDTOs.size(), 1);
    }

    @Test
    public void delete() {
        CUSTOMER_SERVICE.delete(CUSTOMER_NAME);
        verify(CUSTOMER_REPOSITORY, times(1)).deleteAll(CUSTOMERS);
    }

    @Test
    public void getByName() {
        CUSTOMER_SERVICE.getByName(CUSTOMER_NAME);
        verify(CUSTOMER_REPOSITORY, times(1)).getByName(CUSTOMER_NAME);
    }
}