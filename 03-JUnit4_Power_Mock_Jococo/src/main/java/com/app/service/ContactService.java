package com.app.service;

import java.util.List;

import com.app.Contact;

public interface ContactService {
	Long findMobileByName(String name);

	List<Contact> findAll();
}
