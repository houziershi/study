package ch04;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class TCPEchoServerExecutor {

	public static void main(String[] args) throws IOException {

		if (args.length != 1) { // Test for correct # of args
			throw new IllegalArgumentException("Parameter(s): <Port>");
		}

		int echoServPort = Integer.parseInt(args[0]); // Server port

		// Create a server socket to accept client connection requests
		ServerSocket servSock = new ServerSocket(echoServPort);

		Logger logger = Logger.getLogger("practical");

		// Dispatch svc
		Executor service = Executors.newCachedThreadPool(); 

		// Run forever, accepting and spawning threads 
		// to service each connection
		while (true) {
			// Block waiting for connection
			Socket clntSock = servSock.accept(); 
			service.execute(new EchoProtocol(clntSock, logger));
		}
		/* NOT REACHED */
	}
}
