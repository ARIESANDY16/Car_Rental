package com.MiniProject.Car_Rental_JDT7.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class User {
	
	@Id
	private int id_customer;
	private String fullname_customer;
	private String username;
	private String password;
	private String email_customer;
	private long contactno_customer;
	
	
	
	public User() {
		
	}
	
	
	public User(String username, long contactno_customer, String email_customer, String fullname_customer, String password) {
		super();
		this.fullname_customer = fullname_customer;
		this.username = username;
		this.password = password;
		this.email_customer = email_customer;
		this.contactno_customer = contactno_customer;
		
	}
	public int getId_customer() {
		return id_customer;
	}
	public void setId_customer(int id_customer) {
		this.id_customer = id_customer;
	}
	public String getFullname_customer() {
		return fullname_customer;
	}
	public void setFullname_customer(String fullname_customer) {
		this.fullname_customer = fullname_customer;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail_customer() {
		return email_customer;
	}
	public void setEmail_customer(String email_customer) {
		this.email_customer = email_customer;
	}
	public long getContactno_customer() {
		return contactno_customer;
	}
	public void setContactno_customer(long contactno_customer) {
		this.contactno_customer = contactno_customer;
	}	
	
	@Override
	public String toString() {
		return "User [id_customer=" + id_customer + ", fullname_customer=" + fullname_customer + ", username="
				+ username + ", password=" + password + ", email_customer=" + email_customer + ", contactno_customer="
				+ contactno_customer + "]";
	}
}
