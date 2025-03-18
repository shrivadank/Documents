package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.pojo.Customer;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	public Customer getCustomerById(int id) {
		return customerRepository.findById(id).get();
	}

	
	public void addCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	public void deleteCustomer(int id) {
		customerRepository.deleteById(id);
	}
}
