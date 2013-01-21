package test;

import static org.junit.Assert.*;
import org.junit.Test;
import junit.framework.JUnit4TestAdapter;

import java.io.*;
import java.util.*;

import example.*;

public class BaseTypeTest {

	private final String fileName = "testBaseType.txt";

	private void deleteFile(String fileName) {
		File f = new File(fileName);
		if(f.exists()) {
			assertTrue("Unable to delete " + fileName,
					f.delete());
		}
	}

	@Test 
	public void testBinaryFile() throws IOException {
		BaseTypeExample be = new BaseTypeExample();
		LogRecord r = new LogRecord();
		r.setId(1L);
		r.setName("rec1");
		r.setCreateTime(new Date());
		be.add(r);
		//
		r = new LogRecord();
		r.setId(2L);
		r.setName("rec2");
		r.setCreateTime(new Date());
		be.add(r);
		//
		r = new LogRecord();
		r.setId(3L);
		r.setName("rec3");
		r.setCreateTime(new Date());
		be.add(r);
		try{
			this.deleteFile(fileName);
			//
			be.store(fileName);
			//
			be.load(fileName);
			assertEquals(3, be.getRecs().size());
			for(int i=0; i<be.getRecs().size(); i++) {
				LogRecord l = be.getRecs().get(i);
				assertEquals(new Long(i+1), l.getId());
				assertEquals("rec"+(i+1), l.getName());
			}
		} catch (Exception e) {
			//
		} finally {
			this.deleteFile(fileName);
		}
	}

}
