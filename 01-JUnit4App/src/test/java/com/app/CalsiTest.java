package com.app;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class CalsiTest {

	private static Calsi c = null;

	@BeforeClass
	public static void setUp() {
		c = new Calsi();
	}

	@Test
	@Ignore
	public void testAddCalsi() {
		Integer actualResult = c.addCalsi(10, 20);
		Integer expectedResult = 30;
		assertEquals(expectedResult, actualResult);
	}

	@Test(expected = ArithmeticException.class)
	public void testSubCalsi() {
		c.subCalsi(10, 0);
	}

	@AfterClass
	public static void cleanUp() {
		c = null;
	}
}
