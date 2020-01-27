package com.app.dao;

import java.util.List;

import com.app.Contact;

public interface ContactDao {
	Long findMobileByName(String name);

	List<Contact> findAll();
}
