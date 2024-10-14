package org.micro_services.Web;

import org.micro_services.Entities.Customer;
import org.micro_services.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CustomerRestController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customerList")
    public List<Customer> customerList(){
        return customerRepository.findAll();

    }

    @GetMapping("/customerById")
    public Customer customerById(Long id){
        return customerRepository.findById(id).get();
    }

    @PostMapping("/saveCustomer")
    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }
}
