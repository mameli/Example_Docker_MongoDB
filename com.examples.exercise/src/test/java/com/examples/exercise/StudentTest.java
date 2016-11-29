package com.examples.exercise;

import static org.junit.Assert.*;

import org.junit.Test;

// TODO: remove this when there are other tests in the project
public class StudentTest {

	@Test
	public void test() {
		// test only for checking jacoco report
		Student student = new Student();
		student.setId("id");
		student.setName("name");
		assertEquals("id", student.getId());
		assertEquals("name", student.getName());
	}

}
