package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import junit.framework.JUnit4TestAdapter;

import java.io.Writer;
import java.io.IOException;
import java.io.StringWriter;

import example.ReportExample;

public class ReportTest {

	@Test 
	public void testReport() throws IOException {
		String exp ="This is the Header.\n" +
			"This is the Body.\n" + "This is the Footer.\n";

		Writer w = new StringWriter();
		ReportExample re = new ReportExample();
		re.writeReport(w);

		assertEquals(exp, w.toString());
	}

}
