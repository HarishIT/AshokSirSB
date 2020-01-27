package com.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class CalculatorTest {
	private static Calculator calculator = null;

	@BeforeClass
	public static void setUp() {
		calculator = new Calculator();
	}

	@Test
	public void testAddPossitive01() {
		Integer actualResult = calculator.add(10, 10);
		Integer expectedResult = 20;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testAddNegative01() {
		Integer actualResult = calculator.add(10, 20);
		Integer unExpectedResult = 30;
		assertEquals(unExpectedResult, actualResult);
	}

	@Test(expected = ArithmeticException.class)
	public void testDivNegative01() {
		calculator.div(10, 0);
	}

	@Ignore
	@Test(timeout = 1000)
	public void testDivGegative02() {
		calculator.div(10, 20);
	}

	@AfterClass
	public static void tearDown() {
		calculator = null;
	}
}
