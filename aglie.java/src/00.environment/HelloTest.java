
public class HelloTest
{
	/**
	 * class setup must be static
	 */
	@org.junit.BeforeClass
	public static void runBeforeClass() {  
		System.out.println("class setUp... ");
	}  

	/**
	 * class tearDown must be static
	 */
	@org.junit.AfterClass
	public static void runAfterClass() {  
		System.out.println("class tearDown... ");
	}  

	@org.junit.Before
	public void setUp() {
		System.out.println("func setUp... ");
	}

	@org.junit.After
	public void tearDown() {
		System.out.println("func tearDown... ");
	}

	@org.junit.Test 
	public void func01() {
		System.out.println("func01... ");
		org.junit.Assert.assertTrue("hello".equals("hello"));
	}

	/**
	 * now can except for exception
	 */
	@org.junit.Test(expected=ArithmeticException.class)
	public void func02() {
		System.out.println("func02... ");
		System.out.println("result is: " + (2/0));
	}

	/**
	 * this function will not run
	 * we want ignore this function
	 */
	@org.junit.Ignore
	public void func03() {
		System.out.println("func03... ");
	}  

	/**
	 * test time out
	 */
	@org.junit.Test(timeout=500)
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
      return new junit.framework.JUnit4TestAdapter(HelloTest.class);      
    }  
}
