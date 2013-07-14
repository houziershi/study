package net.jade;

import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.Ignore;
import junit.framework.JUnit4TestAdapter;

public class HelloTest {

	/**
	 * class setup must be static
	 */
	@BeforeClass
	public static void runBeforeClass() {
		System.out.println("class setUp... ");
	}  

	/**
	 * class tearDown must be static
	 */
	@AfterClass
	public static void runAfterClass() {  
		System.out.println("class tearDown... ");
	}  

	@Before
	public void setUp() {
		System.out.println("func setUp... ");
	}

	@After
	public void tearDown() {
		System.out.println("func tearDown... ");
	}

	@Test 
	public void func01() {
		System.out.println("func01... ");
		assertTrue("hello".equals("hello"));
	}

	/**
	 * now can except for exception
	 */
	@Test(expected=ArithmeticException.class)
	public void func02() {
		System.out.println("func02... ");
		System.out.println("result is: " + (2/0));
	}

	/**
	 * this function will not run
	 * we want ignore this function
	 */
	@Ignore
	public void func03() {
		System.out.println("func03... ");
	}  

	/**
	 * test time out
	 */
	@Test(timeout=500)
	public void func04() {

		System.out.println("func04... ");
		try {
			Thread.sleep(300);
		} catch (InterruptedException ex) {
			// do nothing
		}
	}

	/**
	 * make junit4 programe alse can be used in 
	 * junit3 environment
	 */
	public static junit.framework.Test suite() {  
		return new JUnit4TestAdapter(HelloTest.class);      
	}  
}
