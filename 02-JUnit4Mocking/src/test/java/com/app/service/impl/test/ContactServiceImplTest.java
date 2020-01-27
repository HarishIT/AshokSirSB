package com.app.service.impl.test;

import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.app.Contact;
import com.app.dao.ContactDao;
import com.app.exception.NoDataFoundException;
import com.app.service.impl.ContactServiceImpl;

public class ContactServiceImplTest {



	private static ContactServiceImpl contactServiceImpl;

	@BeforeClass
	public static void setUp() {
		contactServiceImpl = new ContactServiceImpl();
		ContactDao dao = EasyMock.createMock(ContactDao.class);

		EasyMock.expect(dao.findMobileByName("Harish")).andReturn(9876543210L);
		EasyMock.expect(dao.findMobileByName("Raju")).andReturn(null);

		List<Contact> contacts = new ArrayList<Contact>();
		contacts.add(new Contact(101, "A", 99L));
		contacts.add(new Contact(102, "B", 88L));
		EasyMock.expect(dao.findAll()).andReturn(contacts);


		EasyMock.replay(dao);
		contactServiceImpl.setDao(dao);
	}
	@Test
	public void testFindMobileByNamePositive01() {
		Long mobileNo = contactServiceImpl.findMobileByName("Harish");
		assertNotNull(mobileNo);
		//assertNull(mobileNo);//failed
	}

	@Test(expected = NoDataFoundException.class)
	public void testFindMobileByNameNegative01() {
		contactServiceImpl.findMobileByName("Raju");
	}

	@Test
	public void testFindAllPositive01() {
		List<Contact> list = contactServiceImpl.findAll();
		assertNotNull(list);
	}


	@Test(expected = NoDataFoundException.class)
	public void testFindAllNegative01() {
		ContactServiceImpl impl = new ContactServiceImpl();
		ContactDao dao = EasyMock.createMock(ContactDao.class);
		EasyMock.expect(dao.findAll()).andReturn(null); EasyMock.replay(dao);

		impl.setDao(dao);
		impl.findAll(); }
	@Test
	public void testDoWork() throws Exception {
		Class<?> clz = Class.forName("com.app.service.impl.ContactServiceImpl");
		Object object = clz.newInstance();
		Method m=clz.getDeclaredMethod("doWork", null);
		m.setAccessible(true);
		m.invoke(object, null);
	}
	@AfterClass
	public static void cleanUp() {
		contactServiceImpl = null;
	}
	/*
	private static ContactServiceImpl contactServiceImpl;

	@BeforeClass
	public static void setUp() {
		contactServiceImpl = new ContactServiceImpl();
		ContactDao dao = EasyMock.createMock(ContactDao.class);

		EasyMock.expect(dao.findMobileByName("Harish")).andReturn(9876543210L);
		EasyMock.expect(dao.findMobileByName("Raju")).andReturn(null);

		List<Contact> contacts = new ArrayList<Contact>();
		contacts.add(new Contact(101, "A", 99L));
		contacts.add(new Contact(102, "B", 88L));
		EasyMock.expect(dao.findAll()).andReturn(contacts);


		EasyMock.replay(dao);
		contactServiceImpl.setDao(dao);
	}
		@Test
	public void testFindMobileByNamePositive01() {

		// ContactServiceImpl contactServiceImpl = new ContactServiceImpl();
		// ContactDao dao = EasyMock.createMock(ContactDao.class);
		// EasyMock.expect(dao.findMobileByName("Harish")).andReturn(9876543210L);
		// EasyMock.replay(dao);
		// contactServiceImpl.setDao(dao);

		Long mobileNo = contactServiceImpl.findMobileByName("Harish");
		assertNotNull(mobileNo);
	}

	@Test(expected = NoDataFoundException.class)
	public void testFindMobileByNameNegative01() {
		// ContactServiceImpl contactServiceImpl = new ContactServiceImpl();
		// ContactDao dao = EasyMock.createMock(ContactDao.class);
		// EasyMock.expect(dao.findMobileByName("Raju")).andReturn(null);
		// EasyMock.replay(dao);
		// contactServiceImpl.setDao(dao);

		Long mobileNo = contactServiceImpl.findMobileByName("Raju");
		//assertNull(mobileNo);
		assertNotNull(mobileNo);
	}

	@Test
	@Ignore
	public void testFindAllPositive01() {
//		ContactServiceImpl contactServiceImpl = new ContactServiceImpl();
//		ContactDao dao = EasyMock.createMock(ContactDao.class);
//		List<Contact> contacts = new ArrayList<Contact>();
//		contacts.add(new Contact(101, "A", 99L));
//		contacts.add(new Contact(102, "B", 88L));
//		EasyMock.expect(dao.findAll()).andReturn(contacts);

//		EasyMock.replay(dao);
//		contactServiceImpl.setDao(dao);

		List<Contact> list = contactServiceImpl.findAll();
		assertNotNull(list);
	}
	@Test(expected = NoDataFoundException.class)
	@Ignore
	public void testFindAllNegative01() {
		ContactDao dao = EasyMock.createMock(ContactDao.class);
		EasyMock.expect(dao.findAll()).andReturn(null);
		EasyMock.replay(dao);

		contactServiceImpl.setDao(dao);

		List<Contact> list2 = contactServiceImpl.findAll();
		assertNotNull(list2);
	}
	 */
}