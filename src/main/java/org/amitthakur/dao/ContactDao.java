package org.amitthakur.dao;

import java.util.List;

import org.amitthakur.entity.Contact;

public interface ContactDao {
	
	public void addContact(Contact contact);
	public void editContact(Contact contact);
	public void deleteContact(int contactId);
	public Contact getContact(int contactId);
	public List<Contact> getAllContacts();
	
}
