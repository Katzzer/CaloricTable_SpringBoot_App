package com.pavelkostal.Caloric.Tables.service;

import com.pavelkostal.Caloric.Tables.entity.Customer;
import com.pavelkostal.Caloric.Tables.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Log
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;

    public void saveCustomer(Customer customer) {
        log.info("Saving new customer" + customer);
        customerRepository.save(customer);
    }
}
