package example;

import java.io.*;

public class ReportExample {

	private Writer writer;

	public void writeReport(Writer writer) throws IOException {
		this.writer = writer;
		this.writeHeader();
		this.writeBody();
		this.writeFooter();
	}

	public void writeHeader() throws IOException {
		this.writer.write("This is the Header.\n");
	}

	public void writeBody() throws IOException {
		this.writer.write("This is the Body.\n");
	}

	public void writeFooter() throws IOException {
		this.writer.write("This is the Footer.\n");
	}

}
