package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import junit.framework.JUnit4TestAdapter;

import java.util.Date;

import example.CalendarExample;

public class CalendarTest {

	@Test 
	public void testCreateDate() {
		Date day = CalendarExample.createDate(1984,8,9);
		assertEquals("Thu Aug 09 00:00:00 CST 1984", day.toString());

		day = CalendarExample.addDay(day,10227);
		assertEquals("Thu Aug 09 00:00:00 CST 2012", day.toString()); 
	}

}
