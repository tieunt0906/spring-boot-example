package com.tieunt.spring_boot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tieunt.spring_boot.model.Contact;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class AddressBookController {
	ConcurrentMap<String, Contact> contacts = new ConcurrentHashMap<String, Contact>();
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Finds Contacts by id",
				notes = "Provide an id to look up specific contact from the address book",
				response = Contact.class)
	public Contact getContat(@PathVariable String id) {
		return contacts.get(id);
	}
	
	@GetMapping("/")
	public List<Contact> getAllContacts() {
		return new ArrayList<Contact>(contacts.values());
	}
	
	@PostMapping("/")
	public Contact addContact(@RequestBody Contact contact) {
		contacts.put(contact.getId(), contact);
		return contact;
	}
}
