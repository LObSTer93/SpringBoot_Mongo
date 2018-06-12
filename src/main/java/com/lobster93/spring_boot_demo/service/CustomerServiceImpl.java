package com.lobster93.spring_boot_demo.service;

import com.lobster93.spring_boot_demo.dao.Customer;
import com.lobster93.spring_boot_demo.dao.CustomerRepository;
import com.lobster93.spring_boot_demo.dto.CustomerDTO;
import com.lobster93.spring_boot_demo.dto.DaoToDtoMapper;
import com.lobster93.spring_boot_demo.exceptions.CustomerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDTO> findAll() {
        return customerRepository.findAll().stream()
                .map(DaoToDtoMapper::mapDaoToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void save(CustomerDTO customerDTO) {
        Customer customer = Customer.builder()
                .name(customerDTO.getName())
                .email(customerDTO.getEmail())
                .build();
        customerRepository.save(customer);

    }

    @Override
    public void delete(String customerName) {
        List<Customer> customerEntities = getCustomerEntities(customerName);
        customerRepository.deleteAll(customerEntities);
    }

    @Override
    public List<CustomerDTO> getByName(String customerName) {
        return getCustomerEntities(customerName).stream()
                .map(DaoToDtoMapper::mapDaoToDto)
                .collect(Collectors.toList());
    }

    private List<Customer> getCustomerEntities(String customerName){
        List<Customer> customers = customerRepository.getByName(customerName);
        if(customers.isEmpty()){
            throw new CustomerException("No such customers");
        }
        return customers;
    }
}
