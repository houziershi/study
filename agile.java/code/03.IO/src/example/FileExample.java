package example;

import java.io.*;

public class FileExample extends ReportExample {

	public void writeReport(String fileName) throws IOException {
		Writer w = new BufferedWriter(new FileWriter(fileName));
		try{
			super.writeReport(w);
		} catch (IOException e) {
			//
		} finally {
			w.close();
		}
	}

}
