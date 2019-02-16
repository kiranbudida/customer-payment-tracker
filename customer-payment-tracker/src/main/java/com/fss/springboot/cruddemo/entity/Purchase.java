package com.fss.springboot.cruddemo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="purchase")
public class Purchase {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	//@DateTimeFormat(pattern="yyyy-mm-dd")
	//@Temporal(TemporalType.DATE)
	@Column(name="purchase_date")
	private String purchaseDate;
	
	@Column(name="quantity")
	private float quantity;
	
	@Column(name="amount")
	private int amount;
	
	@ManyToOne(
			//cascade=CascadeType.ALL,
			cascade={CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH}
			//fetch=FetchType.EAGER
			)
	@JoinColumn(name="customer_id")
	private Customer customer;

	@OneToMany(mappedBy="purchase",
			cascade={CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	private List<Payment> payments;
	
	public Purchase() {
		
	}

	public Purchase(String purchaseDate, float quantity, int amount) {

		this.purchaseDate = purchaseDate;
		this.quantity = quantity;
		this.amount = amount;
	}
	
	/*public Purchase(String purchaseDate, int quantity, int amount, Customer customer) {

		this.purchaseDate = purchaseDate;
		this.quantity = quantity;
		this.amount = amount;
		this.customer = customer;
	}
*/
	
	
	
	public int getId() {
		return id;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public float getQuantity() {
		return quantity;
	}


	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	public void add(Payment tmpPayment) {
		
		if(payments==null) {
			payments=new ArrayList<>();
		}
		
			
			payments.add(tmpPayment);
			tmpPayment.setPurchase(this);
		
	}
	
	@Override
	public String toString() {
		return "Purchase [id=" + id + ", purchaseDate=" + purchaseDate + ", quantity=" + quantity + ", amount=" + amount
				 + "]";
	}
	
}
