package com.fss.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fss.springboot.cruddemo.entity.Payment;
import com.fss.springboot.cruddemo.entity.Purchase;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

	
}
