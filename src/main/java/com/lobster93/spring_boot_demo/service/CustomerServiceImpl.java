package com.lobster93.spring_boot_demo.service;

import com.lobster93.spring_boot_demo.dao.Customer;
import com.lobster93.spring_boot_demo.dao.CustomerRepository;
import com.lobster93.spring_boot_demo.dto.CustomerDTO;
import com.lobster93.spring_boot_demo.dto.DaoToDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<CustomerDTO> findAll() {
        return customerRepository.findAll().stream()
                .map(DaoToDtoMapper::mapDaoToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);

    }

    @Override
    public void delete(long customerId) {

    }

    @Override
    public CustomerDTO getByName(String customerName) {
        Customer customer = customerRepository.getByName(customerName);
        return DaoToDtoMapper.mapDaoToDto(customer);
    }

    @Override
    public void edit(String name, String email, long id) {

    }
}
