package test;

import static org.junit.Assert.*;
import org.junit.Test;
import junit.framework.JUnit4TestAdapter;

import java.util.*;
import java.lang.reflect.*;
import example.*;

public class ClassRefTest {

	@Test
	public void testClassInstance() {
		assertTrue("aaa" instanceof String);
		assertTrue(String.class.isInstance("aaa"));
	}

	public void testClassType() {
		assertTrue(List.class.isInterface());
		assertEquals(Modifier.PUBLIC, String.class.getModifiers());
		assertEquals(Modifier.FINAL,  String.class.getModifiers());
	}


	@Test 
	public void testClassRef() {
		Class clazz = RefectClassExp.createClass("java.sql.Date"); 
		assertEquals("java.sql.Date", clazz.getName());
		assertFalse(clazz.isAssignableFrom(Date.class));
		assertTrue(Date.class.isAssignableFrom(clazz));
	}

	@Test 
	public void testClassInfo() {
		Class clazz = RefectClassExp.createClass("java.sql.Date"); 
		System.out.println(clazz.getMethods());
		System.out.println(clazz.getConstructors());
		System.out.println(clazz.getFields());
	}

}
