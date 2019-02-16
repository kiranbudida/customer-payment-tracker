package com.fss.springboot.cruddemo.entity;

import java.util.ArrayList;
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


@Entity
@Table(name="customer")
public class Customer {

	// define fields
	
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
	
	@OneToMany(mappedBy="customer",
			//fetch=FetchType.EAGER,
			//cascade=CascadeType.ALL)
			cascade={CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	private List<Purchase> purchase;
	
	// define constructors
	
	public Customer() {
		
	}

	public Customer(String firstName, String lastName, String fatherName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.fatherName = fatherName;
	
	}
	

	/*public Customer(int id, String firstName, String lastName, String fatherName, List<Purchase> purchase) {

		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fatherName = fatherName;
		this.purchase = purchase;
	}

*/	// define getter/setter
	
	public void add(Purchase tmpPurchase){
		
		if(purchase==null) {
			purchase=new ArrayList<>();
		}
		
			purchase.add(tmpPurchase);
			
			tmpPurchase.setCustomer(this);
		
	}
	
	public List<Purchase> getPurchase() {
		return purchase;
	}

	public void setPurchase(List<Purchase> purchase) {
		this.purchase = purchase;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", fatherName="
				+ fatherName + "]";
	}

		// define tostring
	
	/*@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", fatherName="
				+ fatherName + ", purchase=" + purchase + "]";
	}*/
	
	
	
}











