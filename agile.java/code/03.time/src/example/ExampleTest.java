package example;

import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.Ignore;
import junit.framework.JUnit4TestAdapter;

import java.util.Date;

public class ExampleTest {

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
	public void testCreateDate() {
		CalendarExample ce = new CalendarExample();
		System.out.println(ce.createDate(1984,8,9));
	}

	@Test 
	public void testAddDate() {
		CalendarExample ce = new CalendarExample();
		Date myBirthday = ce.createDate(1984,8,9);
		System.out.println(ce.addDay(myBirthday,10227));
	}


	/**
	 * make junit4 programe alse can be used in 
	 * junit3 environment
	 */
	public static junit.framework.Test suite() {  
		return new JUnit4TestAdapter(ExampleTest.class);      
	}  
}
