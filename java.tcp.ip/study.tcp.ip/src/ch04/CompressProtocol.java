package ch04;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPOutputStream;

public class CompressProtocol implements Runnable {

	// Size of receive buffer
	public static final int BUFSIZE = 1024;
	private Socket clntSock;
	private Logger logger;

	public CompressProtocol(Socket clntSock, Logger logger) {
		this.clntSock = clntSock;
		this.logger = logger;
	}

	public static void handleCompressClient(//
			Socket clntSock, Logger logger)//
	{
		try {
			// Get the input and output streams from socket
			InputStream in = clntSock.getInputStream();
			GZIPOutputStream out = new GZIPOutputStream(
					clntSock.getOutputStream());

			// Allocate read/write buffer
			byte[] buffer = new byte[BUFSIZE];
			int bytesRead; // Number of bytes read
			// Receive until client closes connection,
			// indicated by -1 return
			while ((bytesRead = in.read(buffer)) != -1)
				out.write(buffer, 0, bytesRead);
			out.finish(); // Flush bytes from GZIPOutputStream

			logger.info("Client " + clntSock.getRemoteSocketAddress()
					+ " finished");
		} catch (IOException ex) {
			logger.log(Level.WARNING, "Exception in echo protocol", ex);
		}

		try { // Close socket
			clntSock.close();
		} catch (IOException e) {
			logger.info("Exception = " + e.getMessage());
		}
	}

	public void run() {
		handleCompressClient(this.clntSock, this.logger);
	}
}
