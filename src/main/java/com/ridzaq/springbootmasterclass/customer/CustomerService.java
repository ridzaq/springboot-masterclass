package com.ridzaq.springbootmasterclass.customer;

import com.ridzaq.springbootmasterclass.exception.NotFoundException;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerService {
  //no need this if put @Sl4J annotation (lombok feature)
  //private final static Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

  private final CustomerRepository customerRepository;

  List<Customer> getCustomer() {
    //LOGGER.info("getCustomers was called");
    log.info("getCustomers was called");
    return customerRepository.findAll();
  }

  Customer getCustomer(Long id) {

    return customerRepository.findById(id)
        //getCustomer().stream().filter(customer -> customer.getId().equals(id)).findFirst()
        .orElseThrow(
            () -> {
              NotFoundException notFoundException = new NotFoundException("customer with id " + id + " not found");
              //LOGGER.error("error in getting customer {}", id, notFoundException);
              log.error("error in getting customer {}", id, notFoundException);
              return notFoundException;
            });
  }
}

