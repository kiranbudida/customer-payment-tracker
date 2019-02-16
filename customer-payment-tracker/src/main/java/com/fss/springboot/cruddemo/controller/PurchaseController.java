package com.fss.springboot.cruddemo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fss.springboot.cruddemo.dao.CustomerRepository;
import com.fss.springboot.cruddemo.dao.PurchaseRepository;
import com.fss.springboot.cruddemo.entity.Customer;
import com.fss.springboot.cruddemo.entity.CustomerPurchase;
import com.fss.springboot.cruddemo.entity.Payment;
import com.fss.springboot.cruddemo.entity.Purchase;
import com.fss.springboot.cruddemo.service.CustomerService;
import com.fss.springboot.cruddemo.service.PaymentService;
import com.fss.springboot.cruddemo.service.PurchaseService;

@Controller
@RequestMapping("/customers")
public class PurchaseController {

	@Autowired
	private CustomerService customerService;
	
	/*@Autowired
	CustomerRepository customerRepository;
	*/
	/*@Autowired
	PurchaseRepository purchaseRepository;
	*/
	@Autowired
	private PurchaseService purchaseService;
	
	@Autowired
	private PaymentService paymentService;
	
	@GetMapping("/{id}/show-form-for-purchase")
	public String showFormForPurchase(@PathVariable int id, Model theModel) {
		
		Purchase purchase=new Purchase();
		theModel.addAttribute("purchase",purchase);
	
		theModel.addAttribute("custId", id);
		return "/customers/purchase-form";
	}
	
	
	@PostMapping("/save-purchase/{id}")
	public String savePurchase(@ModelAttribute("purchase") Purchase thePurchase, @PathVariable int id) {
		
		 Customer customer=customerService.findById(id);
		 
		 customer.add(thePurchase);
		
		purchaseService.save(thePurchase);
		
		return "redirect:/customers/list";
	}
	
	
	@GetMapping("/{id}/purchase-details")
	public String showPurchaseDetails(@PathVariable int id, Model theModel) {
		
		List<Purchase> thePurchases=purchaseService.findAllByCustomerId(id);
		theModel.addAttribute("purchases", thePurchases);
		return "/customers/list-purchases";
	}
	
	
	@GetMapping("/show-form-for-pay/{id}")
	public String showFormForPay(@PathVariable int id, Model theModel) {
		
		Payment payment=new Payment();
		
		theModel.addAttribute("purchaseId", id);
		theModel.addAttribute("payment",payment);
		return "/customers/payment-form";
	}
	
	
	@PostMapping("/purchase/{pid}/save-payment")
	public String savePayment(@ModelAttribute("payment") Payment thePayment, @PathVariable int pid) {
		
		
		Purchase purchase=purchaseService.findById(pid);
		purchase.add(thePayment);
		paymentService.save(thePayment);
		
		return "redirect:/customers/list";
	}
	
}










