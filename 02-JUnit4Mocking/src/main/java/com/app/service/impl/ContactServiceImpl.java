package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Contact;
import com.app.dao.ContactDao;
import com.app.exception.NoDataFoundException;
import com.app.service.ContactService;

public class ContactServiceImpl implements ContactService {
	private ContactDao dao;

	public void setDao(ContactDao dao) {
		this.dao = dao;
	}

	public Long findMobileByName(String name) {
		Long mobileNo = dao.findMobileByName(name);

		if (mobileNo == null) {
			throw new NoDataFoundException("No Data Found");
		}
		return mobileNo;
	}

	public List<Contact> findAll() {
		List<Contact> contacts = dao.findAll();

		if (contacts == null || contacts.isEmpty()) {
			throw new NoDataFoundException("No Data Found");
		}
		return contacts;
	}

	private void doWork() {
		System.out.println("DO WORK");
	}
}
