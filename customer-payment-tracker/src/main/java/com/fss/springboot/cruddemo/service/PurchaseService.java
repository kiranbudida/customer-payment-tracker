package com.fss.springboot.cruddemo.service;

import java.util.List;

import com.fss.springboot.cruddemo.entity.Purchase;

public interface PurchaseService {

	public List<Purchase> findAll();
	
	public Purchase findById(int theId);
	
	public void save(Purchase thePurchase);
	
	public void deleteById(int theId);

	public List<Purchase> findAllByCustomerId(int id);
	
}
