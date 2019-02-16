package com.fss.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fss.springboot.cruddemo.dao.PurchaseRepository;
import com.fss.springboot.cruddemo.entity.Purchase;

@Service
public class PurchaseServiceImpl implements PurchaseService {

	private PurchaseRepository purchaseRepository;
	
	@Autowired
	public PurchaseServiceImpl(PurchaseRepository thePurchaseRepository) {
		purchaseRepository = thePurchaseRepository;
	}
	
	@Override
	public List<Purchase> findAll() {
		return purchaseRepository.findAll();
	}

	@Override
	public Purchase findById(int theId) {
		Optional<Purchase> result = purchaseRepository.findById(theId);
		
		Purchase thePurchase = null;
		
		if (result.isPresent()) {
			thePurchase = result.get();
		}
		else {
			// we didn't find the Purchase
			throw new RuntimeException("Did not find Purchase id - " + theId);
		}
		
		return thePurchase;
	}

	@Override
	public void save(Purchase thePurchase) {
		purchaseRepository.save(thePurchase);
	
	}

	@Override
	public void deleteById(int theId) {
		purchaseRepository.deleteById(theId);
	}

	@Override
	public List<Purchase> findAllByCustomerId(int id) {
		// TODO Auto-generated method stub
		return purchaseRepository.findAllByCustomerId(id);
	}

}






