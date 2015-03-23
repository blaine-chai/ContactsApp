package org.amitthakur.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.amitthakur.entity.Contact;
import org.amitthakur.service.ContactService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ContactController {
	private final Logger LOGGER = Logger.getLogger(ContactController.class);
	
	@Autowired
	private ContactService contactService;
	
	@RequestMapping(value = { "/", "/listContacts", "/index"}, method = RequestMethod.GET)
	public String setupForm(Map<String, Object> map) {
		Contact contact = new Contact();
		map.put("contact", contact);
		map.put("contactList", contactService.getAllContacts());
		map.put("actionString", "add");
		return "contact";
	}
	
	 @RequestMapping("/get/{contactId}")
     public String getContact(@PathVariable int contactId, Map<String, Object> map) {

            Contact contact = contactService.getContact(contactId);

            map.put("contact", contact);
            map.put("actionString", "edit");

            return "/contactForm";
     }
	 
	 @RequestMapping("/getNewForm")
     public String getNewForm(Map<String, Object> map) {

		 Contact contact = new Contact();
         map.put("contact", contact);
         return "/contactForm";
     }
	 
	 @RequestMapping("/getUpdatedList")
     public String getUpdatedList(Map<String, Object> map) {

		 map.put("contactList", contactService.getAllContacts());
         return "/contactList";
     }
	 

	 
	 @RequestMapping(value = "/add", method = RequestMethod.POST)
	 public  @ResponseBody String addContact(@ModelAttribute("contact") Contact contact, BindingResult result) {
		 LOGGER.info("Inside addContact");
		 
		 contactService.addContact(contact);
		return "successfully added";
     }
	 
	 @RequestMapping(value = "/edit", method = RequestMethod.POST)
	 public  @ResponseBody String editContact(@ModelAttribute("contact") Contact contact, BindingResult result) {
		contactService.editContact(contact);
		return "successfully edited";
     }
	 
	 @RequestMapping("/delete/{contactId}")
	 public @ResponseBody String deleteContact(@PathVariable int contactId) {
		 contactService.deleteContact(contactId);
         return "deleted successfully";
     }
	
	/*@RequestMapping(value="/contact.do", method=RequestMethod.POST)
	public String doActions(@ModelAttribute Contact contact, BindingResult result, @RequestParam String actionUrl, Map<String, Object> map){
		Contact contactResult = new Contact();
		switch(actionUrl.toLowerCase()){	
		case "add":
			contactService.addContact(contact);
			contactResult = contact;
			break;
		case "edit":
			contactService.editContact(contact);
			contactResult = contact;
			break;
		case "delete":
			contactService.deleteContact(contact.getContactId());
			contactResult = new Contact();
			break;
		case "search":
			Contact searchedContact = contactService.getContact(contact.getContactId());
			contactResult = searchedContact!=null ? searchedContact : new Contact();
			break;
		}
		map.put("contact", contactResult);
		map.put("contactList", contactService.getAllContacts());
		return "contact";
	}*/
}
