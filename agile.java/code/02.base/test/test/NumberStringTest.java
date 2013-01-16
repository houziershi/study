package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import junit.framework.JUnit4TestAdapter;

import java.util.Date;

import example.UserAuth;
import example.SysAdmin;

public class NumberStringTest {

	@Test 
	public void testNumberString() {
		assertEquals("101", Integer.toBinaryString(5));
		assertEquals("21",  Integer.toOctalString(17));
		assertEquals("32",  Integer.toHexString(50));

		assertEquals("101", Integer.toString( 5, 2));
		assertEquals("21",  Integer.toString(17, 8));
		assertEquals("32",  Integer.toString(50,16));

		assertEquals((int)253,  (int)Integer.decode("0xFD"));
		assertEquals((int)253,  (int)Integer.decode("0XFD"));
		assertEquals((int)253,  (int)Integer.decode( "#FD"));
		assertEquals((int)15,   (int)Integer.decode( "017"));
		assertEquals((int)10,   (int)Integer.decode(  "10"));

		assertEquals((int)-253,  (int)Integer.decode("-0xFD"));
		assertEquals((int)-253,  (int)Integer.decode("-0XFD"));
		assertEquals((int)-253,  (int)Integer.decode( "-#FD"));
		assertEquals((int)-15,   (int)Integer.decode( "-017"));
		assertEquals((int)-10,   (int)Integer.decode(  "-10"));
	}

}
