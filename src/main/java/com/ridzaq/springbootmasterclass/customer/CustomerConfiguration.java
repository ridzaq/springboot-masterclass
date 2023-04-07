package com.ridzaq.springbootmasterclass.customer;

import com.ridzaq.springbootmasterclass.infoapp.InfoApp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfiguration {

  @Value("${app.useFakeCustomerRepo:false}")
  private Boolean useFakeCustomerRepo;

  @Value("${info.app.company}")
  private String companyName;

  @Bean
  CommandLineRunner commandLineRunner(InfoApp infoApp) {
    return args -> {
      System.out.println("Command line runner horray!");
      System.out.println(companyName);
      System.out.println(infoApp);
    };
  }

  @Bean
  CustomerRepo customerRepo(){
    System.out.println("useFakeCustomerRepo = " + useFakeCustomerRepo);
    return new CustomerFakeRepository();

  }
}
