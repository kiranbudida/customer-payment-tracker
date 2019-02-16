package com.fss.springboot.cruddemo.service;

import java.util.List;

import com.fss.springboot.cruddemo.entity.Payment;

public interface PaymentService {

	public List<Payment> findAll();
	
	public Payment findById(int theId);
	
	public void save(Payment thePayment);
	
	public void deleteById(int theId);
	
}
