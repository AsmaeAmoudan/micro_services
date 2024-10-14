package org.micro_services;

import org.micro_services.Entities.Customer;
import org.micro_services.Repository.CustomerRepository;
import org.micro_services.Web.CustomerRestController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableJpaRepositories(basePackages="com.customer.repository")
//@EntityScan(basePackages="com.customer.entities")
@SpringBootApplication
public class MicroServicesApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroServicesApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository, CustomerRestController customerRestController) {
        return args -> {
           // customerRepository.save(Customer.builder().name("X").email("X@gmail.com").build());
           // customerRepository.save(Customer.builder().name("Y").email("Y@gmail.com").build());

            Customer customer= new Customer(1, "fatima","fatima@gmail.com");
            customerRestController.saveCustomer(customer);
            System.out.println(customerRestController.customerById(1L).getName());


        };
    }
}
