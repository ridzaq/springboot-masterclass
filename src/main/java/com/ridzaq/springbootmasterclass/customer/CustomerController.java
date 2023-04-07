package com.ridzaq.springbootmasterclass.customer;

import com.ridzaq.springbootmasterclass.exception.ApiRequestException;
import jakarta.validation.Valid;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/customer")
@AllArgsConstructor
public class CustomerController {

  private final CustomerService customerService;

  @GetMapping(value="all")
  List<Customer> getCustomer(){
    return customerService.getCustomer();
  }

  @GetMapping(path= "{customerId}")
  Customer getCustomer(@PathVariable("customerId") Long id){
    return customerService.getCustomer(id);
  }

  @GetMapping(path= "{customerId}/exception")
  Customer getCustomerException(@PathVariable("customerId") Long id){
    throw new ApiRequestException("ApiRequestException for customer " + id);
  }

  @PostMapping
  void createNewCustomer(@Valid @RequestBody Customer customer){
    System.out.println("POST REQUEST");
    System.out.println(customer);
  }

  @PutMapping
  void updateCustomer(@RequestBody Customer customer){
    System.out.println("UPDATE REQUEST...");
    System.out.println(customer);
  }

  @DeleteMapping(path= "{customerId}")
  void deleteCustomer(@PathVariable("customerId") Long id){
    System.out.println("DELETE REQUEST FOR CUSTOMER WITH ID " + id);
  }
}
