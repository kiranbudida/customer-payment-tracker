package com.fss.springboot.cruddemo.service;

import java.util.List;

import com.fss.springboot.cruddemo.entity.Customer;

public interface CustomerService {

	public List<Customer> findAll();
	
	public Customer findById(int theId);
	
	public void save(Customer theEmployee);
	
	public void deleteById(int theId);
	
}
