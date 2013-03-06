package test;

import static org.junit.Assert.*;
import org.junit.*;

import java.lang.reflect.*;

import sis.security.*;
import sis.studentinfo.*;

public class SecureProxyTest {
	private static final String secureMethodName = "secure";
	private static final String insecureMethodName = "insecure";
	private Object object;
	private SecureProxy proxy;
	private boolean secureMethodCalled;
	private boolean insecureMethodCalled;

	@Before
	public void setUp() {
		object = new Object() {
			public void secure() {
				secureMethodCalled = true;
			}
			public void insecure() {
				insecureMethodCalled = true;
			}
		};
		proxy = new SecureProxy(object, secureMethodName);
	}

	@Test
	public void testSecureMethod() throws Throwable {
		Method secureMethod =
			object.getClass().getDeclaredMethod(
					secureMethodName, new Class[]{});
		try {
			proxy.invoke(proxy, secureMethod, new Object[]{});
			fail("expected PermissionException");
		} catch (PermissionException expected) {
			assertFalse(secureMethodCalled);
		}
	}

	@Test
	public void testInsecureMethod() throws Throwable {
		Method insecureMethod =
			object.getClass().getDeclaredMethod(
					insecureMethodName, new Class[]{});
		proxy.invoke(object, insecureMethod, new Object[]{});
		assertTrue(insecureMethodCalled);
	}
}
