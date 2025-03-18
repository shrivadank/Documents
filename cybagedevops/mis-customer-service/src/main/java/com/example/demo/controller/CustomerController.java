
package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.ProjectRepo;
import com.example.demo.pojo.Customer;
import com.example.demo.pojo.Project;
import com.example.demo.service.CustomerService;

@RestController

@CrossOrigin
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	CustomerRepository cr;
	
	
	
	
	@Autowired
	private ProjectRepo pr;
	
	

    
    @GetMapping("/customers")
	public List<Customer> SaveAllCustomers()
	{

		
		return cr.findAll();
	}
	
    
	@GetMapping("/customers/{id}")
	public Customer getCustomerById(@PathVariable int id) {
		Customer customer = customerService.getCustomerById(id);
		System.out.println(customer);
		
		System.out.println("New : " + customer.getProject());
		return customer;
	}

	@PostMapping("/customers")
	public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {
		
		
		
		
		
		//pr.saveAll(customer.getProject());
		
		customerService.addCustomer(customer);
		
		return new ResponseEntity<String>("Added Customer", HttpStatus.CREATED);
	}
	
	@PutMapping("/customers/{id}")
	public HttpStatus updateCustomer(@PathVariable int id, @RequestBody Customer cust) {
	   
		
		Optional<Customer> cot=cr.findById(id);
		
		Customer cst=cot.get();
		
		
		cst.setContactPersonEmail(cst.getContactPersonEmail());
		
		cst.setContactPersonName(cst.getContactPersonName());
		
		cst.setMobile(cst.getMobile());
		
		cst.setName(cst.getName());
		
		
		cr.save(cst);
		
		
		return HttpStatus.ACCEPTED;
	}

	@DeleteMapping("/customers/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable int id) {
		customerService.deleteCustomer(id);
		return new ResponseEntity<String>("customer deleted", HttpStatus.OK);
	}
}
