package com.fss.springboot.cruddemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer_purchase_payment")
public class CustomerPurchase {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="father_name")
	private String fatherName;
	
	@Column(name="purchase_date")
	private String purchaseDate;
	
	@Column(name="purchase_amount")
	private int amount;

	@Column(name="payment_date")
	private String paymentDate;
	
	@Column(name="paid_amount")
	private int paidamount;
	
	public CustomerPurchase() {
		
	}

	public CustomerPurchase(String firstName, String lastName, String fatherName, String purchaseDate, int amount,
			String paymentDate, int paidamount) {
	
		this.firstName = firstName;
		this.lastName = lastName;
		this.fatherName = fatherName;
		this.purchaseDate = purchaseDate;
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.paidamount = paidamount;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public int getPaidamount() {
		return paidamount;
	}
	public void setPaidamount(int paidamount) {
		this.paidamount = paidamount;
	}
	@Override
	public String toString() {
		return "CustomerPurchase [firstName=" + firstName + ", lastName=" + lastName + ", fatherName=" + fatherName
				+ ", purchaseDate=" + purchaseDate + ", amount=" + amount + ", paymentDate=" + paymentDate
				+ ", paidamount=" + paidamount + "]";
	}
			
}
