package test;

import static org.junit.Assert.*;
import org.junit.Test;
import junit.framework.JUnit4TestAdapter;

import example.*;

public class DctTest {

	@Test 
	public void testAdapter() {
		Dct mockDct = new DctAdapter() {
			public String sizeImage(String url, 
					int width, int height) 
			{
				return "/"+ width + "x" + height +
					"/" + url;
			}
		};

		assertEquals("/30x30/aa.png", mockDct.sizeImage("aa.png", 30, 30));

	}

}
