package com.app;

import java.util.List;

import org.junit.internal.runners.statements.Fail;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(CalculatorTest.class, CalsiTest.class);
		int failureCount = result.getFailureCount();
		System.out.println(failureCount);
		int ignoreCount = result.getIgnoreCount();
		System.out.println(ignoreCount);
		int runCount = result.getRunCount();
		System.out.println(runCount);
		List<Failure> failures = result.getFailures();
		if (!failures.isEmpty()) {
			failures.forEach(failure -> {
				System.out.println(failure.getMessage());
			});

		}
	}
}
