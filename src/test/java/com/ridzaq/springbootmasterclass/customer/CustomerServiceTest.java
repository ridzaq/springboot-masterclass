package com.ridzaq.springbootmasterclass.customer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class CustomerServiceTest {

  @Autowired
  private CustomerRepository customerRepository;

  private CustomerService underTest;

  @BeforeEach
  void setUp() {
    underTest = new CustomerService(customerRepository);
  }

  @AfterEach
  void tearDown() {
    customerRepository.deleteAll();
  }

  @Test
  void getCustomer() {
    // given
    Customer jamila = new Customer(1L, "jamila", "hello", "jamila@gmail.com");
    Customer ali = new Customer(2L, "ali", "hello", "ali@gmail.com");

    customerRepository.saveAll(Arrays.asList(jamila,ali));

    // when
    List<Customer> customers = underTest.getCustomer();

    //then
    assertEquals(2, customers.size());
  }

  @Test
  void testGetCustomer() {
    // given
    Customer jamila = new Customer(1L, "jamila", "hello", "jamila@gmail.com");
    customerRepository.save(jamila);

    // when
    Customer actual = underTest.getCustomer(1L);

    // then
    assertEquals(1l, actual.getId());
    assertEquals("jamila", actual.getName());
    assertEquals("hello",actual.getPassword());

  }
}