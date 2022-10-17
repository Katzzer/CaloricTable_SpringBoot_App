package com.pavelkostal.Caloric.Tables.service;

import com.pavelkostal.Caloric.Tables.entity.Customer;
import com.pavelkostal.Caloric.Tables.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Log
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;

    public void saveNewCustomer(Customer customer) {
        log.info("Saving new customer" + customer);
        customerRepository.save(customer);
    }

    public void updateExistingCustomer(Customer customer) {
        log.info("Updating existing customer" + customer);
        customerRepository.save(customer);
    }

    public Optional<Customer> getCustomerFromDb(String email) {
        return customerRepository.findCustomerByEmail(email);
    }
}
