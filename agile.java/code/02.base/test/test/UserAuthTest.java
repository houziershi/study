package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import junit.framework.JUnit4TestAdapter;

import java.util.Date;

import example.UserAuth;
import example.SysAdmin;

public class UserAuthTest {

	private static SysAdmin a = new SysAdmin();
	private static UserAuth add = UserAuth.ADD;
	private static UserAuth edit = UserAuth.EDIT;
	private static UserAuth del = UserAuth.DELETE;
	private static UserAuth find = UserAuth.SEARCH;

	@Test 
	public void testAuth() {
		a.setAuth(add, del);
		assertEquals(Integer.valueOf("101",2).intValue(), a.getAuthValue());
		assertTrue(  a.hasAuth(add, del)  );
		assertFalse( a.hasAuth(edit, find) );
		assertTrue(  a.hasAuth(add)  );
		assertTrue(  a.hasAuth(del)  );
		assertFalse( a.hasAuth(edit) );
		assertFalse( a.hasAuth(find) );

		a.setAuth(edit);
		a.setAuth(find);
		a.unsetAuth(add, del);
		assertFalse(  a.hasAuth(add, del)  );
		assertTrue( a.hasAuth(edit, find) );
		assertFalse(  a.hasAuth(add)  );
		assertFalse(  a.hasAuth(del)  );
		assertTrue( a.hasAuth(edit) );
		assertTrue( a.hasAuth(find) );

		a.unsetAuth(edit);
		assertFalse(  a.hasAuth(add, del, edit)  );
		assertTrue( a.hasAuth(find) );
		assertFalse(  a.hasAuth(add)  );
		assertFalse(  a.hasAuth(del)  );
		assertFalse( a.hasAuth(edit) );
		assertTrue( a.hasAuth(find) );
	}

}
