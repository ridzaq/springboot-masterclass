package com.ridzaq.springbootmasterclass.customer;

import java.util.Arrays;
import java.util.List;

public class CustomerFakeRepository implements CustomerRepo{

  @Override
  public List<Customer> getCustomer() {
    return Arrays.asList(
        new Customer(1L, "James Bond", "123", "email@gmail.com"),
        new Customer(2L, "John Doe", "123password", "email@gmail.com")
    );
  }
}
