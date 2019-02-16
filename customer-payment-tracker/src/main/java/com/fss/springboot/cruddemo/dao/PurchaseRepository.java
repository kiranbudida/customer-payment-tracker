package com.fss.springboot.cruddemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fss.springboot.cruddemo.entity.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {

	@Query(value="SELECT * FROM purchase p where p.customer_id=:id",nativeQuery=true)
	List<Purchase> findAllByCustomerId(int id);

	
}
