package com.fss.springboot.cruddemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.fss.springboot.cruddemo.entity.Customer;
import com.fss.springboot.cruddemo.entity.CustomerPurchase;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query(value="SELECT getTotalOutstanding(?1)",nativeQuery=true)
	int getTotalOutstanding(int id);

	@Procedure(procedureName="getPurchasePaymentDetails")
	void getPurchasePaymentDetails(@Param("customer_id") int id);

	/*@Query(value="CALL getPurchasePaymentDetails(?1)",nativeQuery=true)
	void getPurchasePaymentDetails(int id);
*/
	
	// that's it ... no need to write any code LOL!
	
}
