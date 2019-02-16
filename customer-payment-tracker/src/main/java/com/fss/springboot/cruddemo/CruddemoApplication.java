package com.fss.springboot.cruddemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fss.springboot.cruddemo.dao.CustomerRepository;
import com.fss.springboot.cruddemo.dao.PurchaseRepository;
import com.fss.springboot.cruddemo.entity.Customer;
import com.fss.springboot.cruddemo.entity.Purchase;

@SpringBootApplication
public class CruddemoApplication 
//implements CommandLineRunner 
{

	/*@Autowired
	CustomerRepository customerRepository;
	@Autowired
	PurchaseRepository purchaseRepository;
	@Autowired
	EntityManager entityManager;
*/
	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);

	}

	/*@Override
	public void run(String... arg0) throws Exception {

		//saveData();
		// showData();
	}
*/
	/*@Transactional
	private void saveData() {

		Customer c=new Customer("kumar22", "babu2", "david2");
		
		Purchase purchase=new Purchase("2019-02-10", 2, 320);
		Purchase p1=new Purchase("2019-02-11", 3, 480);
		//int theId=37;
		 //Customer customer=customerRepository.findById(theId).get();
		//customerRepository.save(c); 
		//c.add(purchase);
		purchase.setCustomer(c);
		p1.setCustomer(c);
		//purchase.setCustomer(c);
			//ustomerRepository.findById(theId).get());
			//purchaseRepository.save(purchase);
			//purchaseRepository.save(p1);
	
	}
*/
	//private void saveDataWithApproach2() {
		
			

		//Customer customer = new Customer("kumar2", "babu2", "david2");
		//customerRepository.save(customer);
		//int theId=28;
		//Customer customer=customerRepository.getOne(theId);
		
		//Purchase purchase0=new Purchase();
		//Purchase purchase1=new Purchase("2019-02-10", 2, 320);
		//Purchase purchase2=new Purchase("2019-02-11", 1, 160);
		//Purchase purchase3=new Purchase("2019-02-12", 0.5f, 80);
		
	
		//customer.add(purchase1);
		//purchase1.setCustomer(customer);
		//purchase2.setCustomer(customer);
		//purchase3.setCustomer(customer);
		//customer.add(purchase2);
		//customer.add(purchase3);
		//.add(purchase3);
		
		//customerRepository.save(customer);
		//customerRepository.save(customer);
		//customer.setPurchase(purchases);
		
		//purchaseRepository.save(purchase0);
		//customerRepository.saveAndFlush(customer);
		//purchaseRepository.save(purchase1);
		//purchaseRepository.save(purchase2);
		//purchaseRepository.save(purchase3);
		//purchaseRepository.save(purchase2);
		//purchaseRepository.save(purchase3);
		
		
		
		/*
		 * Firstly persist companies (not include product list)
		 */
		//Customer customer = new Customer("kumar", "babu", "david");
		// Company samsung = new Company("Samsung");

		// save companies
		//customerRepository.save(customer);
		// companyRepository.save(samsung);

		/*
		 * Then store products with had persisted companies.
		 */
		//int theId=7;
		//customerRepository.
		//Customer customer=customerRepository.getOne(theId);
		//Customer customer=customerRepository.findById(theId);
		//Customer customer=customerRepository.findById(theId).get();
		//System.out.println(">>>>>>>>>>"+customerRepository.findById(theId).get()+"<<<<<<<<<<<<<<");
		
		//customer.add
		
		//Purchase purchase1 = new Purchase("2019-02-10", 2, 320, customerRepository.findById(theId).get());
		//Purchase purchase2 = new Purchase("2019-02-03", 3, 480, customer);
		
		//System.out.println(">>>>>>>>>>"+purchase1+">>>>>>>>>>");
		//purchase1.setCustomer(customer);
		//purchase2.setCustomer(customer);
		// save products
		//purchaseRepository.save(new Purchase("2019-02-10", 2, 320, customerRepository.getOne(theId)));
		//entityManager..merge(purchase1);
		//purchaseRepository.
		//purchaseRepository.saveAndFlush(purchase2);
		

//	}

	/*
	 * @Transactional private void showData(){ // get All data List<Company>
	 * companyLst = companyRepository.findAll(); List<Product> productLst =
	 * productRepository.findAll();
	 * 
	 * System.out.println("===================Product List:==================");
	 * productLst.forEach(System.out::println);
	 * 
	 * System.out.println("===================Company List:==================");
	 * companyLst.forEach(System.out::println); }
	 * 
	 */
}
