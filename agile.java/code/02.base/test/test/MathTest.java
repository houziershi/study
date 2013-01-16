package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.Double;

public class MathTest {

	@Test
	public void testNaN() {
		// boolean express alway return false
		assertFalse(Double.NaN > 0.0);
		assertFalse(Double.NaN < 0.0);
		assertFalse(Double.NaN == 0.0);
	}

	@Test
	public void testInfinity() {
		double x = 1.0;
		double tolerance = 0.5;

		assertEquals( Double.POSITIVE_INFINITY,
			Double.POSITIVE_INFINITY * 100, tolerance );
		assertEquals( Double.NEGATIVE_INFINITY,
			Double.POSITIVE_INFINITY * -1, tolerance );

		assertEquals( Double.POSITIVE_INFINITY, x / 0.0, tolerance );
		assertEquals( Double.NEGATIVE_INFINITY, x /-0.0, tolerance );

		assertEquals(  0.0, x / Double.POSITIVE_INFINITY, tolerance );
		assertEquals( -0.0, x / Double.NEGATIVE_INFINITY, tolerance );
		assertEquals(   x , x % Double.POSITIVE_INFINITY, tolerance );

		assertTrue( Double.isNaN( x  % 0.0) );
		assertTrue( Double.isNaN(0.0 / 0.0) );
		assertTrue( Double.isNaN(0.0 % 0.0) );

		assertEquals( Double.POSITIVE_INFINITY,
			Double.POSITIVE_INFINITY / x, tolerance );
		assertEquals( Double.NEGATIVE_INFINITY,
			Double.NEGATIVE_INFINITY / x, tolerance );

		assertTrue( Double.isNaN(Double.POSITIVE_INFINITY % x) );

		assertTrue( 
				Double.isNaN(Double.POSITIVE_INFINITY /Double.POSITIVE_INFINITY) );
		assertTrue( 
				Double.isNaN(Double.POSITIVE_INFINITY %Double.POSITIVE_INFINITY) );
		assertTrue( 
				Double.isNaN(Double.POSITIVE_INFINITY /Double.NEGATIVE_INFINITY) );
		assertTrue( 
				Double.isNaN(Double.POSITIVE_INFINITY %Double.NEGATIVE_INFINITY) );
		assertTrue( 
				Double.isNaN(Double.POSITIVE_INFINITY /Double.POSITIVE_INFINITY) );
		assertTrue( 
				Double.isNaN(Double.POSITIVE_INFINITY %Double.POSITIVE_INFINITY) );
		assertTrue( 
				Double.isNaN(Double.POSITIVE_INFINITY /Double.NEGATIVE_INFINITY) );
		assertTrue( 
				Double.isNaN(Double.POSITIVE_INFINITY %Double.NEGATIVE_INFINITY) );

	}

}
