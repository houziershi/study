package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import stringtools.StringConstans;

public class StringConstansTest {

	@Test
	public void testNewLine() {
		assertNotNull(StringConstans.NEW_LINE);
	}

}
