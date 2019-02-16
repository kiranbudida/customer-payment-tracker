package com.fss.springboot.cruddemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fss.springboot.cruddemo.entity.CustomerPurchase;
import com.fss.springboot.cruddemo.entity.Purchase;

public interface CustomerPurchaseRepository extends JpaRepository<CustomerPurchase, Integer> {

	
}
