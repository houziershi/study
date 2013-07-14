package test;

import static org.junit.Assert.*;
import org.junit.Test;
import junit.framework.JUnit4TestAdapter;

import java.io.*;

import example.*;

public class FileTest {

	private final String fileName = "testFile.txt";
	private final String exp ="This is the Header.\n" +
				"This is the Body.\n" + 
				"This is the Footer.\n";

	private void deleteFile(String fileName) {
		File f = new File(fileName);
		if(f.exists()) {
			assertTrue("Unable to delete " + fileName,
					f.delete());
		}
	}

	@Test 
	public void testReport() throws IOException {
		try{
			this.deleteFile(fileName);

			FileExample fe = new FileExample();
			fe.writeReport(fileName);

			BufferedReader r = new BufferedReader(
					new FileReader(fileName));
			StringBuffer sb = new StringBuffer();
			String line = null;
			while(null != (line = r.readLine())) {
				sb.append(line).append("\n");
			}
			r.close();

			assertEquals(exp, sb.toString());
		} catch (Exception e) {
			//
		} finally {
			this.deleteFile(fileName);
		}
	}

}
