package org.amitthakur.dao;

import java.util.List;

import org.amitthakur.entity.Contact;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ContactDaoImpl implements ContactDao {
	
	@Autowired
	private SessionFactory session;
	
	@Override
	public void addContact(Contact contact) {
		session.getCurrentSession().save(contact);
	}

	@Override
	public void editContact(Contact contact) {
		session.getCurrentSession().update(contact);
	}

	@Override
	public void deleteContact(int contactId) {
		session.getCurrentSession().delete(getContact(contactId));
	}

	@Override
	public Contact getContact(int contactId) {
		return (Contact)session.getCurrentSession().get(Contact.class, contactId);
	}

	@Override
	public List<Contact> getAllContacts() {
		return session.getCurrentSession().createQuery("from ContactsAppTB").list();
	}

}
