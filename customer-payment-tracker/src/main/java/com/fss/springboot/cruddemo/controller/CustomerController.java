package com.fss.springboot.cruddemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fss.springboot.cruddemo.dao.CustomerPurchaseRepository;
import com.fss.springboot.cruddemo.dao.CustomerRepository;
import com.fss.springboot.cruddemo.dao.PurchaseRepository;
import com.fss.springboot.cruddemo.entity.Customer;
import com.fss.springboot.cruddemo.entity.CustomerPurchase;
import com.fss.springboot.cruddemo.service.CustomerService;
import com.fss.springboot.cruddemo.service.PaymentService;
import com.fss.springboot.cruddemo.service.PurchaseService;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	private CustomerService customerService;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	CustomerPurchaseRepository customerPurchaseRepository;
	
	@Autowired
	PurchaseRepository purchaseRepository;
	
	@Autowired
	private PurchaseService purchaseService;
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	public CustomerController(CustomerService theCustomerService) {
		customerService = theCustomerService;
	}
	
	
	// expose "/customers" and return list of customers
	@GetMapping("/list")
	public String findAll(Model theModel) {
		
		List<Customer> theCustomers=customerService.findAll();
		theModel.addAttribute("customers", theCustomers);
		return "/customers/list-customers";
	}

	@GetMapping("/show-form-for-add")
	public String showFormForAdd(Model theModel) {
		
		Customer customer=new Customer();
		
		theModel.addAttribute("customer",customer);
		
		return "/customers/customer-form";
	}
	
	@GetMapping("/{id}/outstanding-details")
	public  String showCustomerOutstanding(@PathVariable int id, Model theModel) {
			
		int outstanding=customerRepository.getTotalOutstanding(id);
		theModel.addAttribute("outstanding", outstanding);
		return "/customers/outstanding-form";
	}
	
	
	@GetMapping("/{id}/purchase-payment-details")
	public String showFormForPay(@PathVariable int id, Model theModel) {
		

		customerRepository.getPurchasePaymentDetails(id);
		
		List<CustomerPurchase> custpurchase=customerPurchaseRepository.findAll();
		
		theModel.addAttribute("custPurchasePayment", custpurchase);
		return "/customers/purchase-payment-details-form";
			
	}
	
	
	/*
	@GetMapping("/{id}/purchase-details")
	public String showPurchaseDetails(@PathVariable int id, Model theModel) {
		
		Purchase purchase=new Purchase();
		Customer customer=customerService.findById(id);
		purchase.setCustomer(customer);
		
		//List<Purchase> thePurchases=purchaseService.findAll(id);
		
		List<Purchase> thePurchases=purchaseService.findAllByCustomerId(id);
		theModel.addAttribute("purchases", thePurchases);
		
		//theModel.addAttribute("purchase",purchase);
		
		return "/customers/list-purchases";
	}
	
	
	
	
	// add mapping for POST /customers - add new customer
	

	@GetMapping("/show-form-for-pay/{id}")
	public String showFormForPay(@PathVariable int id, Model theModel) {
		
		Payment payment=new Payment();
		//Customer customer=customerService.findById(id);
		//purchase.setCustomer(customer);
		
		Purchase purchase=purchaseService.findById(id);
		payment.setPurchase(purchase);
		theModel.addAttribute("payment",payment);
		
		return "/customers/payment-form";
	}
	
	
*/	
	@PostMapping("/save-customer")
	public String addCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		customerService.save(theCustomer);
		
		return "redirect:/customers/list";
	}
	
	
	/*@GetMapping("/{id}/outstanding-details")
	public ResponseEntity<?> showCustomerOutstanding(@PathVariable int id, Model theModel) {
			
		int outstanding=customerRepository.getTotalOutstanding(id);
		//theModel.addAttribute("outstanding", total_outstanding);
		//return ResponseEntity.ok(outstanding);
	}*/
	
	
	/*
	@PostMapping("/save-purchase")
	public String savePurchase(@ModelAttribute("purchase") Purchase thePurchase) {
		
		
		purchaseService.save(thePurchase);
		
		return "redirect:/customers/list";
	}
	
	
	@PostMapping("/purchase/{id}")
    public void createPurchase(@PathVariable (value = "id") int custId,
                                 @Valid @RequestBody Purchase purchase) {
        
		customerRepository.findById(custId).map(customer -> {
            purchase.setCustomer(customer);
            purchaseRepository.save(purchase);
        });
		
    }
	
	
	@PostMapping("/save-payment")
	public String savePayment(@ModelAttribute("payment") Payment thePayment) {
		
		
		paymentService.save(thePayment);
		
		return "redirect:/customers/list";
	}
	*/
	
	@GetMapping("/{id}/update-customer")
	public String updateCustomer(@PathVariable int id,Model model) {
		
		Customer customer=customerService.findById(id);
	
		model.addAttribute("customer", customer);
		
		return "/customers/customer-form";
	}
	
	
	@GetMapping("/delete-customer/{id}")
	public String deleteCustomer(@PathVariable 
			int id) {
		
		//Customer customer=customerService.findById(id);
	
		customerService.deleteById(id);
		
		return "redirect:/customers/list";
	}
}










