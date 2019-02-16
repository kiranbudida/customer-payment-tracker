package com.fss.springboot.cruddemo.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="payment")
public class Payment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	/*@Temporal(TemporalType.DATE)
	@Column(name="payment_date")
	private Date paymentDate;
	*/
	
	@Column(name="payment_date")
	private String paymentDate;
	
	@Column(name="amount")
	private int paidAmount;
	
	@ManyToOne(cascade= {CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="purchase_id")
	private Purchase purchase;
	
	/*@ManyToOne(cascade= {CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="customer_id")
	private Customer customer;
*/
	public Payment() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	/*public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		
		this.paymentDate = paymentDate;
	}
*/
	public int getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(int paidAmount) {
		this.paidAmount = paidAmount;
	}

	
	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}
/*
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
*/
	
	
	@Override
	public String toString() {
		return "Payment [id=" + id + ", paymentDate=" + paymentDate + ", paidAmount=" + paidAmount + ", purchase="
				+ purchase + "]";
	}
	
}
