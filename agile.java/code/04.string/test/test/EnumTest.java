package test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import stringtools.Gender;
import stringtools.Color;

/**
 * @author morgan
 * 
 */
public class EnumTest {

	@Test
	public void testGender() {
		Gender g = Gender.male;
		assertEquals("male", g.toString());
		assertEquals(g, Gender.valueOf("male"));
	}

	@Test
	public void testColor() {
		Color c = Color.RED;
		assertEquals("RED(255,0,0)", c.toString());
		assertEquals(Color.RED, c.valueOf("RED"));
	}

}
