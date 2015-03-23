package org.amitthakur.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "ContactsAppTB")
public class Contact {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int contactId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String emailId;
	
	@Column(name = "phone")
	private String phoneNo;
	
	@Column(name = "address")
	private String address;
	
	public Contact() {}
	
	public Contact(int contactId, String name, String emailId, String phoneNo,
			String address) {
		super();
		this.contactId = contactId;
		this.name = name;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
		this.address = address;
	}
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
