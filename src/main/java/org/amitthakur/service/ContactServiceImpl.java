package org.amitthakur.service;

import java.util.List;

import org.amitthakur.dao.ContactDao;
import org.amitthakur.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactDao contactDao;

	@Transactional
	public void addContact(Contact contact) {
		contactDao.addContact(contact);
	}

	@Transactional
	public void editContact(Contact contact) {
		contactDao.editContact(contact);
	}

	@Transactional
	public void deleteContact(int contactId) {
		contactDao.deleteContact(contactId);
	}

	@Transactional
	public Contact getContact(int contactId) {
		return contactDao.getContact(contactId);
	}

	@Transactional
	public List<Contact> getAllContacts() {
		return contactDao.getAllContacts();
	}

}
